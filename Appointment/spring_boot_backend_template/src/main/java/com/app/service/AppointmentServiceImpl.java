package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AppointmentRepository;
import com.app.pojos.Appointment;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment createAppointment(Appointment appointment) {
        // Additional logic (e.g., check for conflicts) can be added here
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getUpcomingAppointments(Long userId) {
        // Implement logic to retrieve upcoming appointments for a specific user
        // For simplicity, let's assume user ID is not used in this example
        return appointmentRepository.findAll();
    }

    @Override
    public void cancelAppointment(Long appointmentId) {
        // Implement logic to cancel the appointment
        appointmentRepository.deleteById(appointmentId);
    }


}

