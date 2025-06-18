package com.example.eventbooking.controller;

import com.example.eventbooking.model.EventBooking;
import com.example.eventbooking.service.EventBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class EventBookingController {

    private final EventBookingService service;

    public EventBookingController(EventBookingService service) {
        this.service = service;
    }

    @GetMapping
    public List<EventBooking> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventBooking> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EventBooking create(@RequestBody EventBooking booking) {
        return service.create(booking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventBooking> update(@PathVariable Long id, @RequestBody EventBooking data) {
        try {
            return ResponseEntity.ok(service.update(id, data));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
