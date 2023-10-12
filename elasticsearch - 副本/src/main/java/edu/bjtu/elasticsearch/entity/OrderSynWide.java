//package edu.bjtu.elasticsearch.entity;
//
//import com.alibaba.fastjson2.annotation.JSONField;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.*;
//
//import java.util.Date;
//
///**
// * OrderSynWide
// *
// * @ClassName OrderSynWide
// * @Author lixingxing
// * @Date 2021/11/21 下午 17:08
// * @Version 1.0
// */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Document(indexName = "order_wide")
//public class OrderSynWide {
//
//    /**
//     * 工单id
//     */
//    @Id
//    private String orderId;
//
//    /**
//     * 姓名
//     */
//    @Field(type = FieldType.Text,analyzer = "my_ngram",searchAnalyzer = "my_ngram")
//    private String callerName;
//
//    /**
//     * 性别
//     */
//    private String callerSex;
//
//    /**
//     * 来电号码
//     */
//    @Field(type = FieldType.Text,analyzer = "my_ngram",searchAnalyzer = "my_ngram")
//    private String callerPhone;
//
//    /**
//     * 联系方式
//     */
//    @Field(type = FieldType.Text,analyzer = "my_ngram",searchAnalyzer = "my_ngram")
//    private String callerContact;
//
//    /**
//     * 邮箱
//     */
//    private String mail;
//
//    /**
//     * 公司名称
//     */
//    private String companyName;
//
//    /**
//     * 来电人标签
//     */
//    private String callerLabel;
//
//    /**
//     * 来电主体
//     */
//    private String callSubject;
//
//    /**
//     * 工单编号
//     */
//    @Field(type = FieldType.Text,analyzer = "my_ngram",searchAnalyzer = "my_ngram")
//    private String orderNum;
//
//    /**
//     * 来电时间
//     *
//     */
//    @Field(type = FieldType.Keyword)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date callTimeOrderBy;
//
//    /**
//     * 来电时间
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date callTime;
//
//    /**
//     * 受理渠道
//     */
//    private String sourceType;
//
//    /**
//     * 来电类别
//     */
//    private String callerType;
//
//    /**
//     * 被投诉人
//     */
//    private String reflectName;
//
//    /**
//     * 被反映人电话
//     */
//    private String reflectPhone;
//
//    /**
//     * 紧急程度
//     */
//    private String pilotLight;
//
//    /**
//     * 办理类型
//     */
//    private String handleModelType;
//
//    /**
//     * 问题分类编码
//     */
//    private String questionCode;
//
//    /**
//     * 问题分类名称
//     */
//    private String questionName;
//
//    /**
//     * 是否保密
//     */
//    private String isSecret;
//
//    /**
//     * 事发地
//     */
//    @Field(type = FieldType.Text,analyzer = "my_ngram",searchAnalyzer = "my_ngram")
//    private String address;
//
//    /**
//     * 承办单位
//     */
//    private String organizationName;
//
//    /**
//     * 承办单位编码
//     */
//    private String organizationCode;
//
//    /**
//     * 工单标题
//     */
//    @Field(type = FieldType.Text,analyzer = "my_ngram",searchAnalyzer = "my_ngram")
//    private String title;
//
//    /**
//     * 催办单号
//     */
//    private String urgeOrderNum;
//
//    /**
//     * 主要内容
//     */
//    @Field(type = FieldType.Text,analyzer = "my_ngram",searchAnalyzer = "my_ngram")
//    private String majorContent;
//
//    /**
//     * 地图关联
//     */
//    private String addressPoints;
//
//    /**
//     * 处理时限单位
//     */
//    private String timeUnit;
//
//    /**
//     * 处理时限
//     */
//    private String handleDays;
//
//    /**
//     * 备注
//     */
//    @Field(type = FieldType.Text,analyzer = "my_ngram",searchAnalyzer = "my_ngram")
//    private String dispatchAdvice;
//
//    /**
//     * 办理截止时间
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date deadlineDate;
//
//    /**
//     * 是否需要回复
//     */
//    private String isVisit;
//
//    /**
//     * 工单标签
//     */
//    private String orderLabelId;
//
//    /**
//     * 是否老户
//     */
//    private String isOldCaller;
//
//    /**
//     * 旧工单编号
//     */
//    private String oldOrderNum;
//
//    /**
//     * 电话坐席id
//     */
//    @Field(type = FieldType.Text,analyzer = "my_ngram",searchAnalyzer = "my_ngram")
//    private String telOperatorId;
//
//    /**
//     * 电话坐席名
//     */
//    private String telOperatorName;
//
//    /**
//     * 电话坐席提交时间
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date telOperatorSubtime;
//
//    /**
//     * 坐席部门id
//     */
//    private String telOperatorOfficeId;
//
//    /**
//     * 占有人
//     */
//    @Field(type = FieldType.Text,analyzer = "my_ngram",searchAnalyzer = "my_ngram")
//    private String occupyUserId;
//
//    /**
//     * 所属分派人
//     */
//    private String occupyUserName;
//
//    /**
//     * 转派人部门id
//     */
//    private String occupyOfficeId;
//
//    /**
//     * 占有状态: 1 公共   2私人
//     */
//    private String occupyState;
//
//    /**
//     * 办结时间
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date completeTime;
//
//    /**
//     * 分派时间
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date dispatchTime;
//
//    /**
//     * 是否督办
//     */
//    private String isSupervise;
//
//    /**
//     * 工单状态
//     */
//    private String orderState;
//
//    /**
//     * 转派退回原因
//     */
//    private String backReason;
//
//    /**
//     * 转派退回时间
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date backTime;
//
//    /**
//     * 是否疑难工单
//     */
//    private String isHardOrder;
//
//    /**
//     * 标记疑难工单时间
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date hardOrderTime;
//
//    /**
//     * 到期状态标识
//     */
//    private String isExpire;
//
//    /**
//     * 超期状态标识
//     */
//    private String isTimeout;
//
//    /**
//     * 延期天数
//     */
//    private String delayDays;
//
//    /**
//     * 延期后截止日期
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date delayDeadlineDate;
//
//    /**
//     * 延期原因
//     */
//    private String delayReason;
//
//
//    /**
//     * 回访审核占有人id
//     */
//    private String  visitAuditOccupyUserId;
//
//    /**
//     * 回访审核占有用户名称
//     */
//    private String  visitAuditOccupyUserName;
//
//    /**
//     * 回访审核占有部门
//     */
//    private String  visitAuditOccupyOfficeId;
//
//    /**
//     * 占有状态: 1 公共  2 私人
//     */
//    private String  visitAuditOccupyState;
//
//    /**
//     * 人工回访占有用户
//     */
//    private String  visitManualOccupyUserId;
//
//    /**
//     * 人工回访占有用户名称
//     */
//    private String  visitManualOccupyUserName;
//
//    /**
//     * 人工回访占有部门id
//     */
//    private String  visitManualOccupyOfficeId;
//
//    /**
//     * 占有状态: 1 公共 2 私人
//     */
//    private String  visitManualOccupyState;
//
//    /**
//     * 通话id
//     */
//    private String  callId;
//
//    /**
//     * 通话录音文件id
//     */
//    private String  callRecordFileId;
//
//    /**
//     * 工单退回次数
//     */
//    @Field(type = FieldType.Integer)
//    private String  backNum;
//
//    /**
//     * 工单回访次数
//     */
//    @Field(type = FieldType.Integer)
//    private String visitNum;
//
//    /**
//     * 办结次数
//     */
//    private String finishNum;
//
//    /**
//     * 申请延期次数
//     */
//    private String  delayNum;
//
//    /**
//     * 回访人工号
//     */
//    @Field(type = FieldType.Text,analyzer = "my_ngram",searchAnalyzer = "my_ngram")
//    private String visitorId;
//    /**
//     * 回访录音
//     */
//    private String visitRecordFiles;
//    /**
//     * 是否接通电话
//     */
//    private String visitCallIsConnected;
//    /**
//     * 回访时间
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date visitTime;
//    /**
//     * 当事人联系不上
//     */
//    private String visitIsFailContact;
//    /**
//     * 办理真实度
//     */
//    private String visitHandleTrueness;
//    /**
//     * 工作人员是否联系市民
//     */
//    private String visitIscontactCitizens;
//    /**
//     * 问题是否解决
//     */
//    private String visitIsSolved;
//    /**
//     * 对办理结果是否满意
//     */
//    private String visitIsSatisfaction;
//    /**
//     * 首次满意度
//     */
//    private String firstVisitIsSatisfaction;
//    /**
//     * 最终满意度
//     */
//    private String finalVisitIsSatisfaction;
//    /**
//     * 考核申诉是否通过
//     */
//    private String orderAppealState;
//    /**
//     * 意见是否明确
//     */
//    private String visitIsClear;
//    /**
//     * 常用回访意见
//     */
//    private String visitOpinionType;
//    /**
//     * 回访意见
//     */
//    private String visitOpinion;
//    /**
//     * 回访结果
//     */
//    private String visitResult;
//
//    /**
//     * 扩展字段1
//     */
//    private String extend1;
//
//    /**
//     * 扩展字段2
//     */
//    private String extend2;
//
//    /**
//     * 扩展字段3
//     */
//    private String extend3;
//
//    /**
//     * 扩展字段4
//     */
//    private String extend4;
//
//    /**
//     * 扩展字段5
//     */
//    private String extend5;
//
//    /**
//     * 删除标记
//     */
//    private String delFlag;
//
//    /**
//     * 任务id
//     */
//    private String taskId;
//
//
//// info 不合理诉求--------------------------start---------------------------------------
//
//    /**
//     * 不合理诉求状态
//     */
//    @Field(type = FieldType.Text,fielddata = true)
//    private String nonsenseState;
//
//    /**
//     * 不合理诉求单位id
//     */
//    private String nonsenseOfficeId;
//
//    /**
//     * 申请不合理诉求时间
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date nonsenseTime;
//
//    /**
//     * 申请不合理诉求原因
//     */
//    @Field(type = FieldType.Text,analyzer = "my_ngram",searchAnalyzer = "my_ngram")
//    private String nonsenseReason;
//
//    @Field(type = FieldType.Text,analyzer = "my_ngram",searchAnalyzer = "my_ngram")
//    private String nonsensehandleUser;
//// info 不合理诉求--------------------------end---------------------------------------
//// info 重新办理--------------------------start---------------------------------------
//
//    /**
//     * 是否重新办理 0 否 1 是
//     */
//    private String isRehandle;
//
//    /**
//     * 重新办理时间
//     */
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date rehandleTime;
//    /**
//     * 重新办理意见
//     */
//    private String rehandleOpinion;
//
//    /**
//     * 重新办理次数
//     */
//    private String rehandleNum;
//
//// info 重新办理--------------------------end---------------------------------------
//
//    /**
//     * 二级承办单位最新的办理时间
//     */
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date submitAuditTime;
//
//
//// ------------------- info Subcenter
//
//    /**
//     * 派单组织id
//     */
//    private String subDispatchOfficeId;
//
//    /**
//     * 派单组织名称
//     */
//    private String subDispatchOfficeName;
//
//    /**
//     * 承办单位id
//     * whitespace 空格分词器
//     */
//    @Field(type = FieldType.Text, analyzer = "whitespace", searchAnalyzer = "whitespace")
//    private String subOfficeId;
//
//    /**
//     * 承办单位名称
//     */
//    @Field(type = FieldType.Text, analyzer = "whitespace", searchAnalyzer = "whitespace")
//    private String subOfficeName;
//
//    /**
//     * 上级承办单位id
//     */
//    private String subPOfficeId;
//
//    /**
//     * 上级承办单位名称
//     */
//    private String subPOfficeName;
//
//    /**
//     * 派单时间
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date subDispatchTime;
//
//    /**
//     * 派单原因
//     */
//    private String subDispatchAdvice;
//
//    /**
//     * 处理时限
//     */
//    private String subHandleDays;
//
//    /**
//     * 截止时间
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date subDeadlineDate;
//
//    /**
//     * 时限单位
//     */
//    private String subTimeUnit;
//
//    /**
//     * 超时状态标识 是1 否null
//     */
//    private String subIsTimeout;
//
//    /**
//     * 到期状态标识
//     */
//    private String subIsExpire;
//
//    /**
//     * 承办单位最后一 次申请退回工单 时间
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date subBackTime;
//
//    /**
//     * 承办单位最后一 次填写退回工单 原因
//     */
//    private String subBackReason;
//
//    /**
//     * 退回次数
//     */
//    @Field(type = FieldType.Text, analyzer = "whitespace", searchAnalyzer = "whitespace")
//    private String subBackNum;
//
//    /**
//     * 工单状态
//     */
//    private String subOrderState;
//
//    /**
//     * 延期天数
//     */
//    private String subDelayDays;
//
//    /**
//     * 延期后截止日期
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date subDelayDeadlineDate;
//
//    /**
//     * 延期原因
//     */
//    private String subDelayReason;
//
//    /**
//     * 回复时间
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date replyTime;
//
//    /**
//     * 回复内容
//     */
//    @Field(type = FieldType.Text,analyzer = "my_ngram",searchAnalyzer = "my_ngram")
//    private  String  content;
//
//    // ------------------------------------------------------------------------------------------------
//
//    /**
//     * 转办部门id （转办单位一定是二级单位，承办单位可能是二级单位也可能是三级单位）
//     */
//    @Field(type = FieldType.Text, analyzer = "whitespace", searchAnalyzer = "whitespace")
//    private String transferOfficeIds;
//
//    /**
//     * 转办部门名称 （转办单位一定是二级单位，承办单位可能是二级单位也可能是三级单位）
//     */
//    @Field(type = FieldType.Text, analyzer = "whitespace", searchAnalyzer = "whitespace")
//    private String transferOfficeNames;
//
//    /**
//     * 所有二级三级部门的id(不含退出的部门)
//     */
//    @Field(type = FieldType.Text, analyzer = "whitespace", searchAnalyzer = "whitespace")
//    private String allOfficeIds;
//
//    /**
//     * 所有工单状态
//     */
//    @Field(type = FieldType.Text, analyzer = "whitespace", searchAnalyzer = "whitespace")
//    private String states;
//
//    /**
//     * 所有工单状态回显
//     * 市级状态 ： 已转办处理中
//     * A单位： 待签收
//     * B单位： 办理中
//     */
//    private String echoStates;
//
//    // 导出的一些字段
//
//    /**
//     * 首次转办时间
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date firstDispatchTime;
//    /**
//     * 超时办结工单（1是 0否）
//     */
//    private String isOvertimeFinish;
//    /**
//     * 是否申请考核申诉(1是 0否)
//     * 属于的情况 1.二级申请 2.二级审核三级通过
//     */
//    private String isOas;
//    /**
//     * 是否申请不合理诉求(1是 0否)
//     * 属于的情况 1.二级申请 2.二级审核三级通过
//     */
//    private String isNonsense;
//    /**
//     * 办理中的二级单位id（排除退出的单位）
//     */
//    private String processSubDeptIds;
//    /**
//     * 办理中的二级单位（排除退出的单位）
//     */
//    private String processSubDeptNames;
//    /**
//     * 事发地级联id
//     */
//    private String addressIds;
//    /**
//     * 创建时间
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date createdTime;
//
//    /**
//     * 三级单位名称
//     */
//    private String s2OfficeName;
//    /**
//     * 三级承办截止时间
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date s2DeadlineDate;
//
//    /**
//     * 详细地址
//     */
//    @Field(type = FieldType.Text,analyzer = "my_ngram",searchAnalyzer = "my_ngram")
//    private String addressItem;
//
//    /**
//     * 考核申诉状态
//     */
//    @Field(type = FieldType.Text, analyzer = "whitespace", searchAnalyzer = "whitespace")
//    private String orderAppealStateIds;
//
//    /**
//     * 警示灯
//     */
//    private String  cautionLight;
//
//
//    /**
//     * 三级承办警示灯
//     */
//    private String  s2CautionLight;
//
//    /**
//     * 姓名 哈希
//     */
//    @Field(type = FieldType.Text, analyzer = "whitespace", searchAnalyzer = "whitespace")
//    private String callerNameHash;
//
//    /**
//     * 来电号码 哈希
//     */
//    @Field(type = FieldType.Text, analyzer = "whitespace", searchAnalyzer = "whitespace")
//    private String callerPhoneHash;
//
//    /**
//     * 联系方式 哈希
//     */
//    @Field(type = FieldType.Text, analyzer = "whitespace", searchAnalyzer = "whitespace")
//    private String callerContactHash;
//
//    /**
//     * 邮箱 哈希
//     */
//    @Field(type = FieldType.Text, analyzer = "whitespace", searchAnalyzer = "whitespace")
//    private String mailHash;
//
//    /**
//     * 标志通话是否开启了智能辅助：0,辅助通话，1,非辅助通话
//     */
//    private String  isAuxiliary;
//
//    /**
//     * 受理备注 增加索引
//     */
//    @Field(type = FieldType.Text,analyzer = "my_ngram",searchAnalyzer = "my_ngram")
//    private String  extend1Idx;
//
//    /**
//     * 承办单位办结次数（最后一个承办单位多少次办结）
//     */
//    private String lastDeptFinishNum;
//
//    /**
//     * 所有二级三级部门的id(包含退出的部门)
//     */
//    @Field(type = FieldType.Text, analyzer = "whitespace", searchAnalyzer = "whitespace")
//    private String allOfficeIds2;
//
//    /**
//     * 催办状态(0 待催办 , 1 已催办)
//     */
//    private String urgeState;
//
//    /**
//     * 督办工单-所属范围(0个人池/1公共池)
//     */
//    private String superviseRange;
//
//    /**
//     * 督办工单-督办状态（提交状态、下发状态（待处理）、申请退回、待审核、办理完成、督办办结）
//     */
//    private String superviseState;
//
//
//    /**
//     * 是否申请考核申述， 1已申请
//     */
//    private String isAssessment;
//
//    /**
//     * 联合督办意见
//     */
//    private String jointSuperviseOpinion;
//
//    /**
//     * 联合督办驳回意见
//     */
//    private String rejectOpinion;
//
//    /**
//     * 联合督办督办时间
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date jointTime;
//
//    /**
//     * 联合督办驳回时间
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date rejectTime;
//    /**
//     * 联合督办状态
//     */
//    @Field(type = FieldType.Text,analyzer = "my_ngram",searchAnalyzer = "my_ngram")
//    private String jointStatus;
//    /**
//     * 联合督办是否联合
//     */
//    @Field(type = FieldType.Text,analyzer = "my_ngram",searchAnalyzer = "my_ngram")
//    private String isJoint;
//    /**
//     * 督办办理部门id
//     */
//    @Field(type = FieldType.Text, analyzer = "whitespace", searchAnalyzer = "whitespace")
//    private String superviseOfficeIds;
//}
