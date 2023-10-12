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
// * 统计宽表
// * 所有“是否”的字段默认都是（1是 null否）
// */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Document(indexName = "statistics_wide")
//public class StatisticsWide {
//
//    @Id
//    private String orderId;
//
//    /**
//     * 创建时间
//     */
//    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date createdTime;
//
//    /**
//     * 承办单位id
//     */
//    private String officeId;
//
//    /**
//     * 承办单位
//     */
//    private String officeName;
//
//    /**
//     * 来电主体
//     */
//    private String callSubject;
//
//    /**
//     * 工单标签
//     */
//    @Field(type = FieldType.Text, analyzer = "whitespace", searchAnalyzer = "whitespace")
//    private String orderLabelId;
//
//    // 表头---------------------------------------------------------------------------------------------------------
//
//    /**
//     * 是否办结
//     */
//    @Field(type = FieldType.Integer)
//    private String isFinish;
//
//    /**
//     * 是否纳入考核
//     */
//    @Field(type = FieldType.Integer)
//    private String isAssess;
//
//    /**
//     * 是否不合理诉求单
//     */
//    @Field(type = FieldType.Integer)
//    private String isNonsense;
//
//    /**
//     * 是否不合理诉求查否单
//     */
//    @Field(type = FieldType.Integer)
//    private String isNonsenseNo;
//
//    /**
//     * 是否考核申诉单
//     */
//    @Field(type = FieldType.Integer)
//    private String isAppeal;
//
//    /**
//     * 是否考核申诉单查否
//     */
//    @Field(type = FieldType.Integer)
//    private String isAppealNo;
//
//    /**
//     * 是否超时办结工单
//     */
//    @Field(type = FieldType.Integer)
//    private String isOvertimeFinish;
//
//    /**
//     * 是否超期办结工单
//     */
//    @Field(type = FieldType.Integer)
//    private String isOverExpectFinish;
//
//    /**
//     * 是否一次解决
//     */
//    @Field(type = FieldType.Integer)
//    private String oneSat;
//
//    /**
//     * 是否二次解决
//     */
//    @Field(type = FieldType.Integer)
//    private String twoSat;
//
//    /**
//     * 是否三次解决
//     */
//    @Field(type = FieldType.Integer)
//    private String threeSat;
//
//    /**
//     * 是否按时签收
//     */
//    private String isSignTime;
//
//    /**
//     * 是否及时反馈
//     */
//    private String timelyFeedback;
//
//    /**
//     * 是否 未按时签收
//     */
//    private String isNotSignTime;
//
//    /**
//     * 是否 未及时反馈
//     */
//    private String notTimelyFeedback;
//
//    /**
//     * 是否满意工单
//     */
//    private String isSatOrder;
//
//    /**
//     * 是否有效回访
//     */
//    private String isValidReturn;
//
//// 图表-----------------------------------------------------------------------------------------------------------
//
//    /**
//     * 来电类别
//     */
//    private String callerType;
//
//    /**
//     * 来电类别名称
//     */
//    private String callerTypeName;
//
//    /**
//     * 受理渠道
//     */
//    private String sourceType;
//
//    /**
//     * 受理渠道名称
//     */
//    private String sourceTypeName;
//
//    /**
//     * 一级问题分类id
//     */
//    private String level1QuestionCode;
//
//    /**
//     * 一级问题分类名称
//     */
//    private String level1QuestionName;
//
//    /**
//     * 二级问题分类id
//     */
//    private String level2QuestionCode;
//
//    /**
//     * 二级问题分类名称
//     */
//    private String level2QuestionName;
//
//    /**
//     * 三级问题分类id
//     */
//    private String level3QuestionCode;
//
//    /**
//     * 三级问题分类名称
//     */
//    private String level3QuestionName;
//
//    /**
//     * 四级问题分类id
//     */
//    private String level4QuestionCode;
//
//    /**
//     * 四级问题分类名称
//     */
//    private String level4QuestionName;
//
//    /**
//     * 五级问题分类id
//     */
//    private String level5QuestionCode;
//
//    /**
//     * 五级问题分类名称
//     */
//    private String level5QuestionName;
//
//    /**
//     * 末级问题分类id
//     */
//    private String questionCode;
//
//    /**
//     * 日
//     */
//    private String day;
//
//    /**
//     * 月
//     */
//    private String month;
//
//
//}
//
