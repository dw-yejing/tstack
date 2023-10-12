package edu.bjtu.elasticsearch.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExportData1 {
    @ExcelProperty("市级工单号")
    private String orderNo;

    @ExcelProperty("承办单位")
    private String deptName;

    @ExcelProperty("交办时间")
    private String dispatchTime;

    @ExcelProperty("签收时间")
    private String signTime;

    @ExcelProperty("处理时限")
    private String ddl;

    @ExcelProperty("回复市级时间")
    private String doneTime;

    @ExcelProperty("是否退单")
    private String refused;
}
