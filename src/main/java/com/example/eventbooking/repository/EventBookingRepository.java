package com.example.eventbooking.repository;

import com.example.eventbooking.model.EventBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventBookingRepository extends JpaRepository<EventBooking, Long> {
}
