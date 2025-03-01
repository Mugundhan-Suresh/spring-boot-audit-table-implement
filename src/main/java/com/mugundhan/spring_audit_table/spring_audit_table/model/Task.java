package com.mugundhan.spring_audit_table.spring_audit_table.model;

import jakarta.persistence.*;

@Entity
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

    @OneToOne(mappedBy = "task", cascade = CascadeType.ALL)
    private SubTask subTask;

    @OneToOne(mappedBy = "task", cascade = CascadeType.ALL)
    private Drl drl;
}
