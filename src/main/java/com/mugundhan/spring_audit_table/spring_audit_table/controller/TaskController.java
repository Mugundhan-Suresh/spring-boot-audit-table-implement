package com.mugundhan.spring_audit_table.spring_audit_table.controller;

import com.mugundhan.spring_audit_table.spring_audit_table.model.Task;
import com.mugundhan.spring_audit_table.spring_audit_table.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    @Autowired
    private TaskRepo taskRepo;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Task createTask(@RequestBody Task task){
        if (task.getSubTask() != null) {
            task.getSubTask().setTask(task);
        }
        if (task.getObjectString() != null) {
            task.getObjectString().setTask(task);
        }
        return taskRepo.save(task);
    }

    @PutMapping("/update/{id}/{type}")
    public String updateTask(@PathVariable long id, @PathVariable String type){
        Task task = taskRepo.findById(id).get();
        task.setTaskDesc(type);
        System.out.println(task);
        taskRepo.save(task);
        return "Task Updated";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable long id) {
        Task task = taskRepo.findById(id).orElseThrow();
        taskRepo.delete(task);
    }
}
