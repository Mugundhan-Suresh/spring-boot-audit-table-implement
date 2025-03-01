package com.mugundhan.spring_audit_table.spring_audit_table;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class SpringAuditTableApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAuditTableApplication.class, args);
	}

}
