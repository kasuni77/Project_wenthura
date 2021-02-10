package net.wenthura.wenthura.controller;


import net.wenthura.wenthura.exception.ResourceNotFoundException;
import net.wenthura.wenthura.model.Event;
import net.wenthura.wenthura.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/eve")
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/event/all")
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable(value = "id") Long eventId)
        throws ResourceNotFoundException {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));
        return ResponseEntity.ok().body(event);
    }

    @PostMapping("/event")
    public Event createEvent(@Valid @RequestBody Event event) {

        return eventRepository.save(event);
    }

    @PutMapping("/event/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable(value = "id") Long eventId,
                                                   @Valid @RequestBody Event eventDetails) throws ResourceNotFoundException {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id :: " + eventId));

        event.seteName(eventDetails.geteName());
        event.seteDate(eventDetails.geteDate());
        event.seteDesc(eventDetails.geteDesc());
        event.setePlace(eventDetails.getePlace());
        event.seteAny(eventDetails.geteAny());
        event.seteMeet(eventDetails.iseMeet());
        event.seteStatus(eventDetails.geteStatus());
        event.seteServices(eventDetails.geteServices());

        final Event updatedEvent = eventRepository.save( event);
        return ResponseEntity.ok(updatedEvent);
    }
    @PutMapping("/event/status/{id}")
    public ResponseEntity<Event> updateStatus(@PathVariable(value = "id") Long eventId,
                                             @Valid @RequestBody Event eventDetails) throws ResourceNotFoundException {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id :: " + eventId));

        event.seteStatus(eventDetails.geteStatus());

        final Event updatedEvent = eventRepository.save(event);
        return ResponseEntity.ok(updatedEvent);
    }
    @DeleteMapping("/event/{id}")
    public Map<String, Boolean> deleteVehicle(@PathVariable(value = "id") Long eventId)
            throws ResourceNotFoundException {
        Event event= eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));

        eventRepository.delete(event);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
