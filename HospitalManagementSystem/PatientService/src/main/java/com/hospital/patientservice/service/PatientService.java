package com.hospital.patientservice.service;

import com.hospital.patientservice.DTO.PatientDTO;

import java.util.List;

public interface PatientService
{
    //add or create a patient.
    PatientDTO createPatient(PatientDTO patientDTO);

    //get all patients.
    List<PatientDTO> getAllPatients();

    //get patient by id.
    PatientDTO getPatientById(Long id);

    //Update patient info.
    PatientDTO updatePatientInfo(Long id, PatientDTO patientDTO);

    //Delete patient
    void deletePatient(Long id);
}
