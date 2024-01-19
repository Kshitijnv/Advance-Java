package com.app.dao;




import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // Additional query methods can be added here if needed
}

