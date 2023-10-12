package edu.bjtu.elasticsearch.service.province;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.bjtu.elasticsearch.entity.*;
import edu.bjtu.elasticsearch.mapper.*;
import edu.bjtu.elasticsearch.vo.OperateContentVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProvinceService {
    private final ProvincialMapper provincialMapper;
    private final OperateRecordMapper operateRecordMapper;
    private final ProvincialOperateRecordMapper provincialOperateRecordMapper;
    private final SysDeptMapper sysDeptMapper;
    private final OrderInfoMapper orderInfoMapper;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");



    // 获取省级工单
    private  List<ExportData1>  getProvincialOrder3(){
        List<Provincial> provincials = provincialMapper.selectList(new QueryWrapper<Provincial>().lambda().orderByAsc(Provincial::getId));
        List<ExportData1> exportData1List = new ArrayList<>(provincials.size());
        for (Provincial provincial : provincials) {
            String orderNumber = provincial.getSerialNumber();
            String caseSerial = provincial.getOrderNum();
            log.info("正在生成 {}", orderNumber);
            // 签收
            String deptName, signTime, dispatchTime, doneTime;
            OrderInfo orderInfo = orderInfoMapper.selectOne(new QueryWrapper<OrderInfo>().lambda().eq(OrderInfo::getOrderNum, orderNumber).select(OrderInfo::getOrderId));
            if(Objects.isNull(orderInfo)){
                deptName = "无承办单位";
                signTime = "无签收时间";
                dispatchTime = "无交办时间";
                doneTime = "无回复市级时间";
            }else{
                OperateRecord s1SignRecord = operateRecordMapper.selectOne(
                        new QueryWrapper<OperateRecord>().lambda().eq(OperateRecord::getOrderId, orderInfo.getOrderId())
                                .eq(OperateRecord::getOperateEvent, "s1Sign")
                                .orderByDesc(OperateRecord::getOperateTime).last("limit 1")
                );
                if(Objects.isNull(s1SignRecord)){
                    deptName = "无承办单位";
                    signTime = "无签收时间";

                }else {
                    deptName = s1SignRecord.getOfficeName();
                    signTime = s1SignRecord.getOperateTime().format(dateTimeFormatter);
                }

                // 交办
                OperateRecord s1DispatchRecord = operateRecordMapper.selectOne(
                        new QueryWrapper<OperateRecord>().lambda().eq(OperateRecord::getOrderId, orderInfo.getOrderId())
                                .eq(OperateRecord::getOperateEvent, "s1Dispatch")
                                .orderByDesc(OperateRecord::getOperateTime).last("limit 1")
                );
                if(Objects.isNull(s1DispatchRecord)){
                    dispatchTime = "无交办时间";
                }else {
                    dispatchTime = s1DispatchRecord.getOperateTime().format(dateTimeFormatter);
                }

                // 回复市级时间
                OperateRecord s1AuditPassRecord = operateRecordMapper.selectOne(
                        new QueryWrapper<OperateRecord>().lambda().eq(OperateRecord::getOrderId, orderInfo.getOrderId())
                                .eq(OperateRecord::getOperateEvent, "s1AuditPass")
                                .orderByDesc(OperateRecord::getOperateTime).last("limit 1")
                );
                if (Objects.isNull(s1AuditPassRecord)) {
                    doneTime = "无回复市级时间";
                } else {
                    doneTime = s1AuditPassRecord.getOperateTime().format(dateTimeFormatter);
                }
            }


            ExportData1 exportData1 = new ExportData1();
            exportData1.setOrderNo(orderNumber);
            exportData1.setDeptName(deptName);
            exportData1.setDispatchTime(dispatchTime);
            exportData1.setSignTime(signTime);
            exportData1.setDdl(provincial.getHandleDays());
            exportData1.setDoneTime(doneTime);
            exportData1.setRefused("否");
            exportData1List.add(exportData1);
            // 是否退单
            List<ProvincialOperateRecord> refuseRecordList = provincialOperateRecordMapper.selectList(
                    new QueryWrapper<ProvincialOperateRecord>().lambda().eq(ProvincialOperateRecord::getOrderNum, caseSerial)
                            .eq(ProvincialOperateRecord::getOperateEvent, "applyBackPass")
                            .eq(ProvincialOperateRecord::getExitState, "3")
                            .orderByAsc(ProvincialOperateRecord::getOperateTime)
            );
            refuseRecordList.forEach(e->{
                OperateContentVo operateContentVo = JSON.parseObject(e.getOperateContent(), OperateContentVo.class);
                ExportData1 item = new ExportData1();
                item.setOrderNo(orderNumber);
                item.setDeptName(operateContentVo.getBackOfficeNames().get(0));
                item.setDispatchTime("无交办时间");
                item.setSignTime("无签收时间");
                item.setDdl(null);
                item.setDoneTime("无回复市级时间");
                item.setRefused("是");
                exportData1List.add(item);
            });
        }
            return exportData1List;
    }

    // 生产Excel
    public void generateExcel(){
        log.info("导出开始");
        String path = "D:\\temp\\out\\e.xlsx";
        EasyExcel.write(path, ExportData1.class).sheet().doWrite(getProvincialOrder3());
        log.info("导出完成");
    }
}
