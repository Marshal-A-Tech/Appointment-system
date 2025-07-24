package org.example.appointment.service;




import org.example.appointment.dto.AppointmentDto;
import org.example.appointment.exception.AppointmentNotFoundException;

import java.util.List;

public interface AppointmentService {
    AppointmentDto bookAppointment(AppointmentDto appointmentDto);

    List<AppointmentDto> getAppointmentsByCriteria(String consultant, String speciality, String session, String slot);

    void updateAppointment(Integer id,AppointmentDto appointmentDto) throws AppointmentNotFoundException;

    AppointmentDto getAppointmentById(Integer id) throws AppointmentNotFoundException;
}