package com.social.patientprescription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.social.patientprescription.repository")
@EntityScan(basePackages = "com.social.patientprescription.entity")
public class PatientPrescriptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientPrescriptionApplication.class, args);
	}

}
