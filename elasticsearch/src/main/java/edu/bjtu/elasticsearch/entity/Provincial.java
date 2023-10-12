package edu.bjtu.elasticsearch.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

/**
 * @author Geng
 */
@Data
@TableName("provincial_order_info")
public class Provincial {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private int id;

    /**
     * 名称
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 联系方式
     */
    private String  contactInformation;

    /**
     * 是否需要回复
     */
    private String isVisit;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 来电主体
     */
    private String callSubject;

    /**
     * 来电人标签
     */
    private String  callerLabel;

    /**
     * 详细地址
     */
    private String contactAddress;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 电话
     */
    private String  number;


    /**
     * 工单编号
     */
    @NotEmpty
    private String orderNum;

    /**
     * 来电时间
     */
    private String callTime;

    /**
     * 受理渠道
     */
    private String sourceType;


    /**
     * 来电类别
     */
    private String callerType;

    /**
     * 被投诉人
     */
    private String reflectName;

    /**
     * 紧急程度
     */
    private String pilotLight;

    /**
     * 办理类型
     */
    private String handleModelType;

    /**
     * 知识附件
     */
    private String accessory;

    /**
     * 问题分类编码
     */
    private String questionCode;

    /**
     * 问题分类名称
     */
    private String questionName;


    /**
     * 工单状态
     */
    private String status;

    /**
     * 是否保密
     */
    private String isSecret;

    /**
     * 事发地
     */
    private String address;

    /**
     * 催办单号
     */
    private String urgeOrderNum;

    /**
     * 办理截止时间
     */
    @Pattern(regexp="^(\\d{4}-\\d{2}-\\d{2})\\s(\\d{2}:\\d{2}:\\d{2})",message="日期格式为( 2017-08-16 13:54:12 yyyy-MM-dd HH:mm:ss)")
    @NotEmpty
    private String deadlineDate;

    /**
     * 工单标题
     */
    private String title;

    /**
     * 地图关联
     */
    private String addressPoints;

    /**
     * 主要内容
     */
    private String majorContent;
    /**
     * 处理时限
     */
    private String handleDays;
    /**
     * 回复备注
     */
    private String dispatchAdvice;

    /**
     * 工单标签
     */
    private String orderLabelId;

    /**
     * 签收时间
     */
    private LocalDateTime submissionDate;

    /**
     * 办理情况
     */
    private String signForComments;

    /**
     * 签收部门
     */
    private String operationDepartment;

    /**
     * 签收人员
     */
    private String operator;
    /**
     * 承办单位
     */
    private String organizer;

    /**
     * 提交延期审核时间
     */
    private String submitReviewTime;

    /**
     * 受理备注
     */
    private String acceptanceNotes;
    /**
     * 相似工单号
     */
    private String similarWorkOrder;
    /**
     * 市级编号
     */
    @NotEmpty
    private String serialNumber;

    /**
     * 行政区划代码
     */
    private String areaCode;
    /**
     * 承办单位name
     */
    private String organizationName;
    /**
     * 承办单位编码
     */
    private String organizationCode;
    /**
     * 补充述求
     */
    private String supplyContent;
    /**
     * 交办办结时间
     */
    private LocalDateTime assignCloseTime;
    /**
     * 交办时间
     */
    private LocalDateTime assignTime;

    /**
     * 提交办理的承办单位
     */
    private String endDept;

    /**
     * 申请退单的承办单位
     */
    private String dealDept;

    /**
     * 申请延期的承办单位
     */
    @TableField("apply_delayunit")
    private String applyDelayunit;

    /**
     * 承办单位申请截止时间
     */
    private String organizerApplyDeadlineDate;

    /**
     * 市级申请延期天数
     */
    private String numberDaysApplication;

    /**
     * 名字加密hash
     */
    private String nameHash;

    /**
     * 电话加密hash
     */
    private String telHash;

    /**
     * 详细发生地
     */
    private String incidentSiteDetailLabel;
}
