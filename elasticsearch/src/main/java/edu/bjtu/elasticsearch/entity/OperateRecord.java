package edu.bjtu.elasticsearch.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p>
 * 工单操作记录表
 * </p>
 *
 * @author jihua.ux
 * @since 2021-11-21
 */
@Data
@Accessors(chain = true)
@TableName("order_operate_record")
public class OperateRecord implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 记录id
     */
    @TableId(type = IdType.INPUT)
    private String recordId;

    /**
     * 工单id
     */
    private String orderId;

    /**
     * 记录类型
     */
    private String recordType;

    /**
     * 记录类型名称
     */
    private String recordTypeName;

    /**
     * 操作内容
     */
    private String operateContent;

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
     * 操作人
     */
    private String operateUser;

    /**
     * 账号名
     */
    private String operateUserName;
    /**
     *  姓名
     */
    private String operateUserNameZh;
    /**
     * 操作部门id
     */
    private String officeId;
    /**
     * 操作部门名称
     */
    private String officeName;


    /**
     * 入口页面id
     */
    private String  enterMenuId;
    /**
     * 入口页面名称
     */
    private String  enterMenuName;
    /**
     * 出口页面id
     */
    private String  exitMenuId;
    /**
     * 出口页面名称
     */
    private String  exitMenuName;

    /**
     * 操作时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime operateTime;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperateRecord that = (OperateRecord) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(operateContent, that.operateContent) && Objects.equals(operateUser, that.operateUser) && Objects.equals(officeId, that.officeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, operateContent, operateUser, officeId);
    }

    /**
     * 删除标记
     */
    private String delFlag;

}
