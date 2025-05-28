## Patient Prescription Payload
```sh
POST
http://localhost:8081/prescriptions/user?email=hello@gmail.com
{
  "patientName": "John Doe",
  "doctorName": "Dr. Smith",
  "prescriptionDetails": [
    {"Paracetamol": "Take 1 tablet after meal"}
  ]
}
```