package com.social.patientprescription.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import  org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.patientprescription.dto.Prescriptiondto;
import com.social.patientprescription.service.PrescriptionService;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @Autowired
    public PrescriptionService prescriptionService;

    @PostMapping("/user")
    private String getPrescriptionService(@RequestParam String email, @RequestBody Prescriptiondto prescriptiondto){
        prescriptiondto.setEmail(email); // Set the email from the request param
        return prescriptionService.getPrescription(prescriptiondto);
    }
}
