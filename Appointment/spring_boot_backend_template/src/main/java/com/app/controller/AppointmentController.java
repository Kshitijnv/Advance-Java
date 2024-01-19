package com.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.pojos.Appointment;
import com.app.service.AppointmentService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/ongoing")
    public ResponseEntity<?> createAppointments(@RequestBody List<Appointment> appointments) {
        List<Appointment> createdAppointments = new ArrayList<>();

        for (Appointment appointment : appointments) {
            createdAppointments.add(appointmentService.createAppointment(appointment));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(createdAppointments);
    }

    @GetMapping("/{userId}/upcoming")
    public List<Appointment> getUpcomingAppointments(@PathVariable Long userId) {
        return appointmentService.getUpcomingAppointments(userId);
    }

    @DeleteMapping("/{appointmentId}")
    public void cancelAppointment(@PathVariable Long appointmentId) {
        appointmentService.cancelAppointment(appointmentId);
    }
}

