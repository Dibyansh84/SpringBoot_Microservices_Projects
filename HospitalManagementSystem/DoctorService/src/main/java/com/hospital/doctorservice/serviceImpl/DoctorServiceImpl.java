package com.hospital.doctorservice.serviceImpl;

import com.hospital.doctorservice.DTO.DoctorDTO;
import com.hospital.doctorservice.entity.Doctor;
import com.hospital.doctorservice.repository.DoctorRepository;
import com.hospital.doctorservice.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService
{
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public DoctorDTO createDoctor(DoctorDTO doctorDTO)
    {
        //Convert DTO to entity.
        Doctor doctor = convertDtoToEntity(doctorDTO);
        Doctor savedPatient = doctorRepository.save(doctor);
        //Convert Entity to DTO
        return convertEntityToDto(savedPatient);
    }

    @Override
    public List<DoctorDTO> getAllDoctors()
    {
        List<Doctor> doctorList = doctorRepository.findAll();
        return doctorList.stream().map(this::convertEntityToDto).collect(Collectors.toList());
        //Collectors.toList() is used to collect elements from a stream into a List.
    }

    @Override
    public DoctorDTO getDoctorById(Long id)
    {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
        return convertEntityToDto(doctor);
    }


    //Convert DTO to entity.
    private Doctor convertDtoToEntity(DoctorDTO doctorDTO)
    {
        Doctor doctor = new Doctor();
        doctor.setId(doctorDTO.getId());
        doctor.setName(doctorDTO.getName());
        doctor.setSpecialization(doctorDTO.getSpecialization());
        return doctor;
    }

    //Convert entity to DTO.
    private DoctorDTO convertEntityToDto(Doctor doctor)
    {
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setId(doctor.getId());
        doctorDTO.setName(doctor.getName());
        doctorDTO.setSpecialization(doctor.getSpecialization());
        return doctorDTO;
    }
}
