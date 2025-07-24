package org.example.appointment.controller;


import org.example.appointment.dto.AppointmentDto;
import org.example.appointment.exception.AppointmentNotFoundException;
import org.example.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;


@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService service;

    @PostMapping("/save")
    public AppointmentDto controlBookAppointment(@Valid @RequestBody AppointmentDto appointmentDto){
        return service.bookAppointment(appointmentDto);
    }
    @GetMapping("/get/{consultant}/{speciality}/{session}/{slot}")
    public List<AppointmentDto> showAppointments(@Valid @PathVariable String consultant, @Valid @PathVariable String speciality,
                                                 @Valid @PathVariable String session, @Valid @PathVariable String slot){
        return service.getAppointmentsByCriteria(consultant,speciality,session,slot);
    }
    @Transactional
    @PutMapping("/update/{id}")
    public void controlUpdateAppointment(@PathVariable Integer id,@Valid @RequestBody AppointmentDto appointmentDto) throws AppointmentNotFoundException {
        service.updateAppointment(id,appointmentDto);
    }
    @GetMapping("/get/{id}")
    public AppointmentDto controlShowAppointment(@Valid @PathVariable Integer id) throws AppointmentNotFoundException {
        return service.getAppointmentById(id);
    }

}