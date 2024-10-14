package com.hospital.doctorservice.DTO;

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
