package com.hospital.patientservice.controller;

import com.hospital.patientservice.DTO.PatientDTO;
import com.hospital.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController
{
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patientDTO)
    {
        PatientDTO createdPatient = patientService.createPatient(patientDTO);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    //Get all patients
    @GetMapping("/getAllPatients")
    public ResponseEntity<List<PatientDTO>> getAllPatients()
    {
       List<PatientDTO> patientList = patientService.getAllPatients();
        return ResponseEntity.ok(patientList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id)
    {
        PatientDTO patientDto = patientService.getPatientById(id);
        return ResponseEntity.ok(patientDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatientData(@PathVariable Long id, @RequestBody PatientDTO patientDTO)
    {
        try
        {
            PatientDTO updatedPatient = patientService.updatePatientInfo(id, patientDTO);
            return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id)
    {
        /*  "/{id}" This is a URL template variable.  */
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }
}
