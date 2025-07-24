package org.example.appointment.repository;

import org.example.appointment.dto.AppointmentDto;
import org.example.appointment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<AppointmentDto> findAllByConsultantAndSpecialityAndSessionAndSlot(String consultant, String speciality, String session, String slot);
}




