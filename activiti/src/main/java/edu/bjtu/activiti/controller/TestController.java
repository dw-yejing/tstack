package edu.bjtu.activiti.controller;

import lombok.AllArgsConstructor;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@AllArgsConstructor
public class TestController {
    private RuntimeService runtimeService;
    private TaskService taskService;



    @GetMapping("/query")
    public List<Task> getTasks(String assignee) {
        return taskService.createTaskQuery().taskAssignee(assignee).list();
    }

    /**
     * 启动流程
     */
    @PostMapping("/process/start")
    public void startProcess(String orderId, String flag, String processDefinitionKey) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("flag", flag);
        runtimeService.startProcessInstanceByKey(processDefinitionKey, orderId, variables);
    }

    /**
     * 处理任务
     */
    @PutMapping("/task/complete")
    public void completeTask(String taskId, String flag){
        Map<String, Object> variables = new HashMap<>(5);
        variables.put("flag", flag);
        taskService.complete(taskId, variables);
    }

}
