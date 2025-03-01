package com.mugundhan.spring_audit_table.spring_audit_table.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "object-string")
@Data
public class ObjectString {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String objectString;

    @OneToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
