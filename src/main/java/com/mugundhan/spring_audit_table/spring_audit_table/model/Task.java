package com.mugundhan.spring_audit_table.spring_audit_table.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mugundhan.spring_audit_table.spring_audit_table.service.AuditService;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@EntityListeners(AuditService.class)
@Table(name = "task")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String taskName;
    private String taskDesc;
    private Boolean isActive;
    private String severity;

    @OneToOne(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private SubTask subTask;

    @OneToOne(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private ObjectString objectString;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public SubTask getSubTask() {
        return subTask;
    }

    public void setSubTask(SubTask subTask) {
        this.subTask = subTask;
    }

    public ObjectString getObjectString() {
        return objectString;
    }

    public void setObjectString(ObjectString objectString) {
        this.objectString = objectString;
    }
}
