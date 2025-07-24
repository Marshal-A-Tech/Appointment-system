package org.example.appointment.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.appointment.dto.AppointmentDto;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "appointment_tbl")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDate appointmentDate;
    private String session;
    private String slot;
    private String speciality;
    private String consultant;

    public Appointment(AppointmentDto appointmentDto) {
        this.id = appointmentDto.getId();
        this.appointmentDate = appointmentDto.getAppointmentDate();
        this.session = appointmentDto.getSession();
        this.slot = appointmentDto.getSlot();
        this.speciality = appointmentDto.getSpeciality();
        this.consultant = appointmentDto.getConsultant();
    }

}
