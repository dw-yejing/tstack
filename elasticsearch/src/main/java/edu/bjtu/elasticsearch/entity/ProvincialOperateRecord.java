package edu.bjtu.elasticsearch.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/**
 * @author Geng
 */
@Data
@TableName("operation_record")
public class ProvincialOperateRecord {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 工单编号
     */
    private String orderNum;

    /**
     * 市级编号
     */
    @NotEmpty
    private String serialNumber;
    /**
     * 操作内容
     */
    private String operateContent;
    /**
     * 操作人
     */
    private String operateUser;
    /**
     * 操作部门id
     */
    private Integer officeId;

    /**
     * 操作部门
     */
    private String operationDepartment;
    /**
     * 操作事件
     */
    private String operateEvent;
    /**
     * 操作事件名称
     */
    private String operateEventName;
    /**
     * 入口状态名称
     */
    private String entryStateName;
    /**
     * 入口状态
     */
    private String entryState;
    /**
     * 出口状态
     */
    private String exitState;
    /**
     * 出口状态名称
     */
    private String exitStateName;

    /**
     * 操作人姓名
     */
    private String operateUserName;

    /**
     * 操作时间
     */
    private LocalDateTime operateTime;







}
