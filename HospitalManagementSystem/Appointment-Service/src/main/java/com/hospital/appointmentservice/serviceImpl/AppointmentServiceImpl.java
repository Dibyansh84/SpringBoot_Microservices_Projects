package com.hospital.appointmentservice.serviceImpl;

import com.hospital.appointmentservice.DTO.AppointmentDto;
import com.hospital.appointmentservice.client.DoctorClient;
import com.hospital.appointmentservice.client.PatientClient;
import com.hospital.appointmentservice.entity.Appointment;
import com.hospital.appointmentservice.repository.AppointmentRepository;
import com.hospital.appointmentservice.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService
{
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorClient doctorClient;

    @Autowired
    private PatientClient patientClient;

    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentDto)
    {
        //Convert DTO to entity.
        Appointment appointment = convertDtoToEntity(appointmentDto);
        Appointment createdAppointment = appointmentRepository.save(appointment);

        //Convert entity to DTO.
        return convertEntityToDto(createdAppointment);
    }

    @Override
    public List<AppointmentDto> getAllAppointments()
    {
        //findAll() method of JPA repository returns the list of patients.
        //Note:- JPA always interacts with the entity.
        //JPA never interacts with the DTO class.*/
        List<Appointment> appointmentList = appointmentRepository.findAll();

        //convert the DTO to entity
        return appointmentList.stream().map(this::convertEntityToDto).collect(Collectors.toList());
        //Collectors.toList() is used to collect elements from a stream into a List.
    }

    @Override
    public AppointmentDto getAppointmentById(Long id)
    {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found !!!"));
        return convertEntityToDto(appointment);
    }

    @Override
    public AppointmentDto updateAppointment(Long id, AppointmentDto appointmentDto)
    {
        //Find the appointment id and then update it.
       Appointment existingAppointment = appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found"));

       //If the appointment data exists update the appointment data else return null.
        if(existingAppointment != null)
        {
            //convert the DTO into entity then set the data and call the save method to update.
            existingAppointment.setPatientId(appointmentDto.getPatientId());
            existingAppointment.setDoctorId(appointmentDto.getDoctorId());
            existingAppointment.setDate(appointmentDto.getDate());

            Appointment updatedAppointment = appointmentRepository.save(existingAppointment);

            //Convert the JPA entity to DTO.
            return convertEntityToDto(updatedAppointment);
        }
        else
        {
            return null;
        }
    }


    //Convert DTO to entity.
    private Appointment convertDtoToEntity(AppointmentDto appointmentDto)
    {
        Appointment appointment = new Appointment();
        appointment.setId(appointment.getId());
        appointment.setPatientId(appointmentDto.getPatientId());
        appointment.setDoctorId(appointmentDto.getDoctorId());
        appointment.setDate(appointmentDto.getDate());
        return appointment;
    }
    //Convert entity to DTO.
    private AppointmentDto convertEntityToDto(Appointment appointment)
    {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setId(appointment.getId());
        appointmentDto.setPatientId(appointment.getPatientId());
        appointmentDto.setDoctorId(appointment.getDoctorId());
        appointmentDto.setDate(appointment.getDate());
        return appointmentDto;
    }

}
