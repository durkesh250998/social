package com.social.patientprescription.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Map;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prescriptiondto {
    private Long id;
    private String patientName;
    private String doctorName;
   private List<Map<String, String>> prescriptionDetails;
    private Timestamp dateIssued;
    private String email;
}
