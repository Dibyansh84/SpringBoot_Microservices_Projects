package com.hospital.appointmentservice.service;

import com.hospital.appointmentservice.DTO.AppointmentDto;

import java.util.List;

public interface AppointmentService
{
    AppointmentDto createAppointment(AppointmentDto appointmentDto);
    List<AppointmentDto> getAllAppointments();
    AppointmentDto getAppointmentById(Long id);
    AppointmentDto updateAppointment(Long id, AppointmentDto appointmentDto);
}
