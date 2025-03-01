package com.mugundhan.spring_audit_table.spring_audit_table.repository;

import com.mugundhan.spring_audit_table.spring_audit_table.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

}
