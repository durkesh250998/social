package com.social.patientprescription.service;
import java.util.Optional;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

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
                return "success";
            } else {
                return "failure";
            }
        }

        public String getPrescriptionPdf(Prescriptiondto prescriptiondto) {
            try(PDDocument document = new PDDocument()){
            int lineSpacing = 15;
            PDPage page = new PDPage();
            document.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.COURIER , 12);
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText("PRESCRIPTION DETAILS");
            contentStream.newLineAtOffset(0, -lineSpacing);
            contentStream.showText("Patient Name: " + prescriptiondto.getPatientName());
            contentStream.newLineAtOffset(0, -lineSpacing);
            contentStream.showText("Doctor Name: " + prescriptiondto.getDoctorName());
            contentStream.newLineAtOffset(0, -lineSpacing);
            contentStream.showText("Prescription Details: " + prescriptiondto.getPrescriptionDetails());
            contentStream.newLineAtOffset(0, -lineSpacing);
            contentStream.showText("Email: " + prescriptiondto.getEmail());
            contentStream.newLineAtOffset(0, -lineSpacing);
            contentStream.showText("Thank you for using our service!");
            contentStream.endText();
            contentStream.close();
            document.save("prescription.pdf");
            document.close();
            return "successufully generated pdf";
            } catch (Exception e) {
                e.printStackTrace();
                return "failure";
            }
        }
}
