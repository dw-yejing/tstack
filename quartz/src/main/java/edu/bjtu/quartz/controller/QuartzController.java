package edu.bjtu.quartz.controller;

import edu.bjtu.quartz.entity.Schedule;
import edu.bjtu.quartz.mapper.ScheduleMapper;
import edu.bjtu.quartz.vo.ResultVO;
import lombok.RequiredArgsConstructor;
import org.quartz.Scheduler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import edu.bjtu.quartz.util.QuartzUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuartzController {
    //注入任务调度
    private final ScheduleMapper scheduleMapper;
    private final Scheduler scheduler;

    @PostMapping("/quartz/createJob")
    public ResultVO createJob(@RequestBody Schedule schedule)  {
        try {
            //进行测试所以写死
            QuartzUtils.createScheduleJob(scheduler, schedule);
            scheduleMapper.insert(schedule);
        } catch (Exception e) {
            return  ResultVO.failure("创建失败");
        }
        return ResultVO.success("创建成功");
    }

    @PutMapping("/quartz/pauseJob")
    public ResultVO  pauseJob(String jobName)  {
        try {
            QuartzUtils.pauseScheduleJob (scheduler,jobName);
        } catch (Exception e) {
            return ResultVO.failure("暂停失败");
        }
        return ResultVO.success("暂停成功");
    }

    @PutMapping("/quartz/runOnce")
    public ResultVO runOnce(String jobName)  {
        try {
            QuartzUtils.runOnce (scheduler,jobName);
        } catch (Exception e) {
            return ResultVO.failure("运行一次失败");
        }
        return ResultVO.success("运行一次成功");
    }

    @PutMapping("/quartz/resume")
    public ResultVO  resume(String jobName)  {
        try {
            QuartzUtils.resumeScheduleJob(scheduler,jobName);
        } catch (Exception e) {
            return ResultVO.failure("重启失败");
        }
        return ResultVO.success("重启成功");
    }

    @PutMapping("/quartz/update")
    public ResultVO  update(Schedule schedule)  {
        try {
            QuartzUtils.updateScheduleJob(scheduler, schedule);
        } catch (Exception e) {
            return ResultVO.failure("更新失败");
        }
        return ResultVO.success("更新成功");
    }
}