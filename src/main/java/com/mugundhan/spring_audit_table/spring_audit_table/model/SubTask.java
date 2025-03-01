package com.mugundhan.spring_audit_table.spring_audit_table.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sub_task")
@Data
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String conditions;

    @OneToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
