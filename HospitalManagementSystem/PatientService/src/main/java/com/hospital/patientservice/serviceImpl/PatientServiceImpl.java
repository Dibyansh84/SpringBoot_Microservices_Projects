package com.hospital.patientservice.serviceImpl;

import com.hospital.patientservice.DTO.PatientDTO;
import com.hospital.patientservice.entity.Patient;
import com.hospital.patientservice.repository.PatientRepository;
import com.hospital.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService
{
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public PatientDTO createPatient(PatientDTO patientDTO)
    {
        //Convert DTO to entity.
       Patient patient = convertDtoToEntity(patientDTO);
       Patient savedPatient = patientRepository.save(patient);
       //Convert Entity to DTO
        return convertEntityToDto(savedPatient);
    }

    @Override
    public List<PatientDTO> getAllPatients()
    {
        //findAll() method of JPA repository returns the list of patients.
        //Note:- JPA always interacts with the entity.
        //JPA never interacts with the DTO class.*/
        List<Patient> patientList = patientRepository.findAll();

        //convert the above entity to DTO.
        return patientList.stream().map(this::convertEntityToDto).collect(Collectors.toList());
        //Collectors.toList() is used to collect elements from a stream into a List.
    }

    @Override
    public PatientDTO getPatientById(Long id)
    {
        Patient patient =  patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
        return convertEntityToDto(patient);
    }

    @Override
    public PatientDTO updatePatientInfo(Long id, PatientDTO patientDTO)
    {
        //Find the patient by its id and then update it.
        Patient existingPatient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));

        //If the patient data exists then update the patient data else return null.
        if(existingPatient !=null)
        {
            //convert the DTO into entity then set the data and call the save method to update.
            existingPatient.setName(patientDTO.getName());
            existingPatient.setAge(patientDTO.getAge());
            existingPatient.setGender(patientDTO.getGender());
            Patient updatedPatient = patientRepository.save(existingPatient);

            //Convert the JPA entity into a DTO.
            return convertEntityToDto(updatedPatient);
        }
        else
        {
            return null;
        }
    }

    @Override
    public void deletePatient(Long id)
    {
        //FInd the patient by its id then delete it.
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
        patientRepository.deleteById(id);
    }


    //Convert DTO to entity.
    private Patient convertDtoToEntity(PatientDTO patientDTO)
    {
        Patient patient = new Patient();
        patient.setId(patientDTO.getId());
        patient.setName(patientDTO.getName());
        patient.setAge(patientDTO.getAge());
        patient.setGender(patientDTO.getGender());
        return patient;
    }

    //Convert entity to DTO.
    private PatientDTO convertEntityToDto(Patient patient)
    {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setName(patient.getName());
        patientDTO.setAge(patient.getAge());
        patientDTO.setGender(patient.getGender());
        return patientDTO;
    }
}
