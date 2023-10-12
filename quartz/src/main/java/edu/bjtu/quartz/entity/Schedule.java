package edu.bjtu.quartz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Schedule {
    /** 任务id */
    @TableId(type = IdType.AUTO)
    private String  id;

    /** 任务分组 */
    private String jobGroup;

    /** 任务名称 */
    private String jobName;

    /** 任务执行类 */
    private String jobClass;

    /** 任务状态 启动还是暂停*/
    private Integer status;

    /** 任务运行时间表达式 */
    private String cron;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;
}
