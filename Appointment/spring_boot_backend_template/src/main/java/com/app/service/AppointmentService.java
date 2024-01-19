package com.app.service;


import java.util.List;

import com.app.pojos.Appointment;

public interface AppointmentService {

    Appointment createAppointment(Appointment appointment);

    List<Appointment> getUpcomingAppointments(Long userId);

    void cancelAppointment(Long appointmentId);

}

