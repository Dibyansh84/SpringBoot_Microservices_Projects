package com.hospital.appointmentservice.controller;

import com.hospital.appointmentservice.DTO.AppointmentDto;
import com.hospital.appointmentservice.DTO.PatientDTO;
import com.hospital.appointmentservice.entity.Appointment;
import com.hospital.appointmentservice.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController
{
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto)
    {
        AppointmentDto appointmentCreated = appointmentService.createAppointment(appointmentDto);
        return new ResponseEntity<>(appointmentCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointments()
    {
       List<AppointmentDto> appointmentList = appointmentService.getAllAppointments();
       return ResponseEntity.ok(appointmentList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable Long id)
    {
        AppointmentDto appointmentDto = appointmentService.getAppointmentById(id);
        return ResponseEntity.ok(appointmentDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDto> updateAppointment(@PathVariable Long id, @RequestBody AppointmentDto appointmentDto)
    {
        try
        {
            AppointmentDto updatedAppointment = appointmentService.updateAppointment(id, appointmentDto);
            return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
