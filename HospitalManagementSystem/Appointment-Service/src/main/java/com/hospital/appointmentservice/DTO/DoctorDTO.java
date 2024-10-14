package com.hospital.appointmentservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO
{
    private Long id;
    private String name;
    private String specialization;
}
//We've created a DoctorDTO in the AppointmentService as well. But we don't need to fully implement it as part of the AppointmentService's logic.
//This DTO will be used for data transfer when the AppointmentService communicates with the DoctorService via Feign clients.

