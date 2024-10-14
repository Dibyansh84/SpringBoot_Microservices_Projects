package com.hospital.doctorservice.service;

import com.hospital.doctorservice.DTO.DoctorDTO;

import java.util.List;

public interface DoctorService
{
    //add a doctor
    DoctorDTO createDoctor(DoctorDTO doctorDTO);

    //Get all doctors
    List<DoctorDTO> getAllDoctors();

    //Get doctor by id.
    DoctorDTO getDoctorById(Long id);
}
