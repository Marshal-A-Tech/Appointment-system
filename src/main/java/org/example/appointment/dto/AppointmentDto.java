package org.example.appointment.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.appointment.model.Appointment;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AppointmentDto {
    private Integer id;
    @FutureOrPresent(message = "Appointment Date can't be in the past!")
    private LocalDate appointmentDate;
    @NotEmpty(message = "Please provide session!")
    private String session;
    @NotEmpty(message = "Please provide slot!")
    private String slot;
    @NotEmpty(message = "Please select a speciality!")
    private String speciality;
    @NotEmpty(message = "Please select a consultant!")
    private String consultant;

    public AppointmentDto(Appointment appointment) {
        this.id = appointment.getId();
        this.appointmentDate = appointment.getAppointmentDate();
        this.session = appointment.getSession();
        this.slot = appointment.getSlot();
        this.speciality = appointment.getSpeciality();
        this.consultant = appointment.getConsultant();
    }
    
}
