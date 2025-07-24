package org.example.appointment.service;



import org.example.appointment.dto.AppointmentDto;
import org.example.appointment.exception.AppointmentNotFoundException;
import org.example.appointment.model.Appointment;
import org.example.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public AppointmentDto bookAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = appointmentRepository.save(new Appointment(appointmentDto));
        return new AppointmentDto(appointment);
    }

    @Override
    public List<AppointmentDto> getAppointmentsByCriteria(String consultant, String speciality, String session, String slot) {
        return appointmentRepository.findAllByConsultantAndSpecialityAndSessionAndSlot(consultant,speciality,session,slot);
    }

    @Override
    public void updateAppointment(Integer id, AppointmentDto appointmentDto) throws AppointmentNotFoundException {
        Optional<Appointment> optional = appointmentRepository.findById(id);
        optional.orElseThrow(()->new AppointmentNotFoundException("Appointment Booking Not Found!"));
        // if exists
        Appointment newAppointment = optional.get();

        newAppointment.setId(appointmentDto.getId());
        newAppointment.setAppointmentDate(appointmentDto.getAppointmentDate());
        newAppointment.setConsultant(appointmentDto.getConsultant());
        newAppointment.setSpeciality(appointmentDto.getSpeciality());
        newAppointment.setSession(appointmentDto.getSession());
        // only update this in frontend
        newAppointment.setSlot(appointmentDto.getSlot());
    }

    @Override
    public AppointmentDto getAppointmentById(Integer id) throws AppointmentNotFoundException {
        Optional<Appointment> optional = appointmentRepository.findById(id);
        optional.orElseThrow(()->new AppointmentNotFoundException("Appointment can't be found in database!"));
        // if exists
        return new AppointmentDto(optional.get());
    }

}