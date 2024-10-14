package com.hospital.appointmentservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO
{
    private Long id;
    private String name;
    private Integer age;
    private String gender;
}
