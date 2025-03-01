package com.mugundhan.spring_audit_table.spring_audit_table.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mugundhan.spring_audit_table.spring_audit_table.model.Task;
import com.mugundhan.spring_audit_table.spring_audit_table.model.TaskAudit;
import com.mugundhan.spring_audit_table.spring_audit_table.repository.TaskAuditRepo;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditService {

//
//    @Autowired
//    private TaskAuditRepo taskAuditRepo;

    private final TaskAuditRepo taskAuditRepo;

    public AuditService(@Lazy TaskAuditRepo taskAuditRepo) {
        this.taskAuditRepo = taskAuditRepo;
    }


    @PrePersist
    @PreUpdate
    @PreRemove
    public void auditTask(Task task) {
        System.out.println("Task Audit happening");
        captureAudit(task, determineAction(task));

    }

    private String determineAction(Task task) {
        return task.getTaskId() == null ? "CREATE" : "UPDATE";
    }

    private void captureAudit(Task task, String action) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            String subTaskJson = task.getSubTask() != null ?
                    objectMapper.writeValueAsString(task.getSubTask()) : "{}";
            String drlJson = task.getObjectString() != null ?
                    objectMapper.writeValueAsString(task.getObjectString()) : "{}";

            TaskAudit audit = new TaskAudit();

            audit.setTaskId(task.getTaskId());
            audit.setName(task.getTaskName());
            audit.setDescription(task.getTaskDesc());
            audit.setSeverity(task.getSeverity());
            audit.setSubTaskJson(subTaskJson);
            audit.setObjStringJson(drlJson);
            audit.setTimestamp(LocalDateTime.now());
            audit.setAction(action);

            taskAuditRepo.save(audit);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
