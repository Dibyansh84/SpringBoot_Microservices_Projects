package com.hospital.appointmentservice.client;

import com.hospital.appointmentservice.DTO.DoctorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "doctor-service")
public interface DoctorClient
{
    /*The Appointment Service depends on information from the Doctor Service and Patient Service to manage appointments
    or retrieve details about doctors and patients for each appointment.
    Feign Clients in the Appointment Service will allow it to make HTTP calls to these services transparently.
    */

    //get doctor by id.
    @GetMapping("/api/doctors/{id}")
    DoctorDTO getDoctorById(@PathVariable Long id);
}
