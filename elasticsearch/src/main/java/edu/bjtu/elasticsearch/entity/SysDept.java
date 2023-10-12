package edu.bjtu.elasticsearch.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * <p>
 * 部门管理
 * </p>
 *
 * @author shiyanpeng
 * @since 2018-01-22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysDept{

    private static final long serialVersionUID = 1L;

    @TableId(value = "dept_id", type = IdType.INPUT)
    private Integer deptId;

    /**
     * 部门名称
     */
    @NotBlank(message = "部门名称不能为空")
    private String name;

    /**
     * 部门类型
     */
    private Integer type;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     * 父级Id
     */
    private Integer parentId;

    /**
     * 是否删除  -1：已删除  0：正常
     */
    @TableLogic
    private String delFlag;


    private Integer tenantId;

    /**
     * 承办单位简称
     */
    private String abbreviation;

    /**
     * 特殊受理标识
     */
    private String specialAcceptance;

    /**
     * 单位类型
     * 1 市直部门
     * 2 县(市、区)
     * 3 公服企业
     * 4 乡镇（街道）
     * 5 市受理中心-受理组
     * 6 市受理中心-审核组
     * 7 市受理中心-回访组
     * 8 市受理中心-质检组
     * 9 市受理中心-督导部
     * 10 市纪委监委
     */
    private String unitType;
    /**
     * 承办单位标识
     * 1 市级
     * 2 二级承办单位
     * 3 三级承办单位
     */
    private String unitTypeMark;

    /**
     * 通知手机号 多个,分隔
     */
    private String noticePhoneinfo;
}
