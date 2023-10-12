package edu.bjtu.elasticsearch.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 工单信息表
 * </p>
 *
 * @author jihua.ux
 * @since 2021-11-21
 */
@Data
@Accessors(chain = true)
@TableName("order_info")
public class OrderInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(type = IdType.INPUT)
    private String orderId;

    /**
     * 姓名
     */
    @NotEmpty
    private String callerName;

    @NotEmpty
    private String callerNameHash;

    /**
     * 性别
     */
    @NotEmpty
    private String callerSex;

    /**
     * 来电号码
     */
    private String callerPhone;


    /**
     * 来电号码
     */
    private String callerPhoneHash;

    /**
     * 联系方式
     */
    private String callerContact;


    /**
     * 联系方式
     */
    private String callerContactHash;

    /**
     * 邮箱
     */
    private String mail;


    /**
     * 邮箱
     */
    private String mailHash;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 来电人标签
     */
    private String callerLabel;

    /**
     * 来电主体
     */
    private String callSubject;

    /**
     * 工单编号
     */
    @NotEmpty
    private String orderNum;

    /**
     * 来电时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime callTime;

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
     * 被反映人电话
     */
    private String reflectPhone;

    /**
     * 紧急程度
     */
    private String pilotLight;

    /**
     * 办理类型 直办 1 转办 2 催办 3
     */
    @NotEmpty
    private String handleModelType;

    /**
     * 问题分类编码
     */
    private String questionCode;

    /**
     * 问题分类名称
     */
    private String questionName;

    /**
     * 是否保密
     */
    private String isSecret;

    /**
     * 事发地
     */
    private String address;

    /**
     * 承办单位
     */
    @NotEmpty
    private String organizationName;

    /**
     * 承办单位编码
     */
    @NotEmpty
    private String organizationCode;

    /**
     * 工单标题
     */
    private String title;

    /**
     * 催办单号
     */
    private String urgeOrderNum;

    /**
     * 主要内容
     */
    private String majorContent;

    /**
     * 地图关联
     */
    private String addressPoints;

    /**
     * 处理时限单位
     */
    private String timeUnit;

    /**
     * 处理时限
     */
    private String handleDays;

    /**
     * 备注
     */
    private String dispatchAdvice;

    /**
     * 办理截止时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime deadlineDate;

    /**
     * 是否需要回复
     */
    private String isVisit;

    /**
     * 工单标签
     */
    private String orderLabelId;

    /**
     * 是否老户  0 否  1 是
     */
    private String isOldCaller;

    /**
     * 旧工单编号
     */
    private String oldOrderNum;

    /**
     * 电话坐席id
     */
    private String telOperatorId;

    /**
     * 电话坐席名
     */
    private String telOperatorName;

    /**
     * 电话坐席提交时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime telOperatorSubtime;

    /**
     * 坐席部门id
     */
    private String telOperatorOfficeId;

    /**
     * 占有人
     */
    private String occupyUserId;

    /**
     * 所属分派人
     */
    private String occupyUserName;

    /**
     * 转派人部门id
     */
    private String occupyOfficeId;

    /**
     * 占有状态: 1 公共   2私人
     */
    private String occupyState;

    /**
     * 办结时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime completeTime;

    /**
     * 分派时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime dispatchTime;

    /**
     * 是否督办   0 否 1 是
     */
    private String isSupervise;

    /**
     * 工单状态
     */
    private String orderState;

    /**
     * 转派退回原因
     */
    private String backReason;

    /**
     * 转派退回时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime backTime;

    /**
     * 是否疑难工单 0 否 1 是
     */
    private String isHardOrder;

    /**
     * 标记疑难工单时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime hardOrderTime;

    /**
     * 到期状态标识
     */
    private String isExpire;

    /**
     * 超期状态标识
     */
    private String isTimeout;

    /**
     * 延期天数
     */
    private String delayDays;

    /**
     * 延期申请单位id
     */
    private String delayOfficeId;

    /**
     * 延期申请状态
     */
    private String delayState;

    /**
     * 延期后截止日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime delayDeadlineDate;

    /**
     * 延期原因
     */
    private String delayReason;


    /**
     * 回访审核占有人id
     */
    private String  visitAuditOccupyUserId;

    /**
     * 回访审核占有用户名称
     */
    private String  visitAuditOccupyUserName;

    /**
     * 回访审核占有部门
     */
    private String  visitAuditOccupyOfficeId;

    /**
     * 占有状态: 1 公共  2 私人
     */
    private String  visitAuditOccupyState;

    /**
     * 人工回访占有用户
     */
    private String  visitManualOccupyUserId;

    /**
     * 人工回访占有用户名称
     */
    private String  visitManualOccupyUserName;

    /**
     * 人工回访占有部门id
     */
    private String  visitManualOccupyOfficeId;

    /**
     * 占有状态: 1 公共 2 私人
     */
    private String  visitManualOccupyState;

    /**
     * 通话id
     */
    private String  callId;

    /**
     * 通话录音文件id
     */
    private String  callRecordFileId;

    /**
     * 工单退回次数
     */
    private String  backNum;

    /**
     * 工单回访次数
     */
    private String visitNum;

    /**
     * 申请延期次数
     */
    private String  delayNum;

    /**
     * 回访人工号
     */
    private String visitorId;
    /**
     * 回访录音
     */
    private String visitRecordFiles;
    /**
     * 是否接通电话
     */
    private String visitCallIsConnected;
    /**
     * 回访时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime visitTime;
    /**
     * 当事人联系不上
     */
    private String visitIsFailContact;
    /**
     * 办理真实度
     */
    private String visitHandleTrueness;
    /**
     * 工作人员是否联系市民
     */
    private String visitIscontactCitizens;
    /**
     * 问题是否解决
     */
    private String visitIsSolved;
    /**
     * 对办理结果是否满意
     */
    private String visitIsSatisfaction;
    /**
     * 意见是否明确
     */
    private String visitIsClear;
    /**
     * 常用回访意见
     */
    private String visitOpinionType;
    /**
     * 回访意见
     */
    private String visitOpinion;
    /**
     * 回访结果
     */
    private String visitResult;

    /**
     * 附件集合
     */
    private String attachmentList;

    /**
     * 扩展字段--受理备注
     */
    private String extend1;

    /**
     * 扩展字段 --办理情况
     */
    private String extend2;

    /**
     * 扩展字段 -- 详细地址
     */
    private String extend3;

    /**
     * 扩展字段  来电人反馈是否加密
     */
    private String extend4;

    /**
     * 扩展字段 --  延期通过-答复口径
     */
    private String extend5;

    /**
     * 删除标记
     */
    private String delFlag;

    /**
     * 不合理诉求状态
     */
    private String nonsenseState;

    /**
     * 申请不合理诉求单位id
     */
    private String nonsenseOfficeId;

    /**
     * 申请不合理诉求时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime nonsenseTime;

    /**
     * 申请不合理诉求原因
     */
    private String nonsenseReason;
    /**
     * 乐观锁
     */
    @TableField("REVISION")
    private String revision;

    /**
     * 创建人
     */
    @TableField("CREATED_BY")
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField("CREATED_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createdTime;

    /**
     * 更新人
     */
    @TableField("UPDATED_BY")
    private String updatedBy;

    /**
     * 更新时间
     */
    @TableField("UPDATED_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updatedTime;


    @TableField(exist=false)
    private String taskId;

    /**
     * 是否重新办理 0 否 1 是
     */
    private String isRehandle;

    /**
     * 是否重新办理
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime rehandleTime;
    /**
     * 重新办理意见
     */
    private String rehandleOpinion;

    /**
     * 办理情况
     */
    @TableField(exist = false)
    private String content;

    /**
     * 是否省级工单: 0 否,1 是
     */
    private String isProvinceOrder;

    /**
     * 挂断时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime hangUpTime;

    /**
     * 是否 不纳入考核 0 否,1 是
     */
    private String isKbi;

    /**
     * 标志通话是否开启了智能辅助：0,辅助通话，1,非辅助通话
     */
    private String  isAuxiliary;

    /**
     * 警示灯
     */
    @TableField(exist = false)
    private String  cautionLight;


    /**
     * 三级承办警示灯
     */
    @TableField(exist = false)
    private String  s2CautionLight;

    /**
     * 挂账督办 申请原因
     */
    private String applyReason;

    /**
     * 挂账督办状态
     */
    @TableField(exist = false)
    private String orderAppealState;

    /**
     * 答复口径
     */
    @TableField(exist = false)
    private String replyCaliber;

    /**
     * 审核时间
     */
    @TableField(exist = false)
    private LocalDateTime orderAppealAuditTime;

    /**
     * 是否申请考核申述， 1已申请
     */
    private String isAssessment;

    /**
     * 详细发生地
     */
    private String incidentSiteDetailLabel;

    /**
     * 是否禁止退回
     */
    private Boolean isForbidBack;


}
