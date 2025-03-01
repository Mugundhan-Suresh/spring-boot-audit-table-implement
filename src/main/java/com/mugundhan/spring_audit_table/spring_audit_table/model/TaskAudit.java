package com.mugundhan.spring_audit_table.spring_audit_table.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "task_audit")
@Data
public class TaskAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskAuditId;

    private Long taskId;
    private String name;
    private String description;
    private String severity;
    private String subTaskJson;
    private String objStringJson;
    private LocalDateTime timestamp;
    private String action; // CREATE, UPDATE, DELETE

    public Long getTaskAuditId() {
        return taskAuditId;
    }

    public void setTaskAuditId(Long taskAuditId) {
        this.taskAuditId = taskAuditId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getSubTaskJson() {
        return subTaskJson;
    }

    public void setSubTaskJson(String subTaskJson) {
        this.subTaskJson = subTaskJson;
    }

    public String getObjStringJson() {
        return objStringJson;
    }

    public void setObjStringJson(String objStringJson) {
        this.objStringJson = objStringJson;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
