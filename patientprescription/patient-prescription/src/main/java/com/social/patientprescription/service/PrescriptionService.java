package com.social.patientprescription.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.patientprescription.dto.Prescriptiondto;
import com.social.patientprescription.entity.PrescriptionEntity;
import com.social.patientprescription.entity.UserEntity;
import com.social.patientprescription.repository.PrescriptionRepository;
import com.social.patientprescription.repository.UserRepository;

@Service
public class PrescriptionService {
        @Autowired
        UserRepository userRepository;
        @Autowired
        PrescriptionRepository prescriptionRepository;
        public String getPrescription(Prescriptiondto prescriptiondto) {
            if (prescriptiondto.getEmail() == null || prescriptiondto.getEmail().isEmpty()) {
                return "Email is required";
            }
            Optional<UserEntity> mailCheck = userRepository.findByEmail(prescriptiondto.getEmail());
            System.out.println("PrescriptionDTO email: " + prescriptiondto.getEmail());
            PrescriptionEntity prescriptionEntity = new PrescriptionEntity();
            prescriptionEntity.setPatientName(prescriptiondto.getPatientName());
            prescriptionEntity.setDoctorName(prescriptiondto.getDoctorName());
            prescriptionEntity.setPrescriptionDetails(prescriptiondto.getPrescriptionDetails());
            prescriptionEntity.setEmail(prescriptiondto.getEmail());
            System.out.println("PrescriptionEntity email: " + prescriptionEntity.getEmail());
            if (mailCheck.isPresent()) {
                prescriptionRepository.save(prescriptionEntity);
                return "Prescription saved successfully for " + prescriptiondto.getEmail();
            } else {
                return "Email not found";
            }
        }
}
