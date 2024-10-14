package com.hospital.appointmentservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto
{
    private Long id;
    private Long patientId;
    private Long doctorId;
    private String date;
}
