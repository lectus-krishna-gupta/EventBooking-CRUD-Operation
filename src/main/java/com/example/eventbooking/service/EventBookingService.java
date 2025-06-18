package com.example.eventbooking.service;

import com.example.eventbooking.model.EventBooking;
import com.example.eventbooking.repository.EventBookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventBookingService {

    private final EventBookingRepository repository;

    public EventBookingService(EventBookingRepository repository) {
        this.repository = repository;
    }

    public List<EventBooking> getAll() {
        return repository.findAll();
    }

    public Optional<EventBooking> getById(Long id) {
        return repository.findById(id);
    }

    public EventBooking create(EventBooking booking) {
        return repository.save(booking);
    }

    public EventBooking update(Long id, EventBooking data) {
        return repository.findById(id).map(b -> {
            b.setName(data.getName());
            b.setCollege(data.getCollege());
            b.setEventName(data.getEventName());
            b.setDate(data.getDate());
            return repository.save(b);
        }).orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
