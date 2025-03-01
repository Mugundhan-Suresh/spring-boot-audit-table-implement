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
    private String drlJson;
    private LocalDateTime timestamp;
    private String action; // CREATE, UPDATE, DELETE
}
