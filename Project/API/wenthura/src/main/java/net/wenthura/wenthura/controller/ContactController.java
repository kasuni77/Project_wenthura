package net.wenthura.wenthura.controller;


import net.wenthura.wenthura.exception.ResourceNotFoundException;
import net.wenthura.wenthura.model.Contact;
import net.wenthura.wenthura.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/con")
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/contact/all")
    public List<Contact> getAllContact(){
        return contactRepository.findAll();
    }

    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable(value = "id") Long contactId)
        throws ResourceNotFoundException {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("contact not found for this id :: " + contactId));
        return ResponseEntity.ok().body(contact);
    }

    @PostMapping("/contact")
    public Contact createContact(@Valid @RequestBody Contact contact) {

        return contactRepository.save(contact);
    }

    @PutMapping("/contact/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable(value = "id") Long contactId,
                                                 @Valid @RequestBody Contact contactDetails) throws ResourceNotFoundException {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("contact not found for this id :: " + contactId));

        contact.setCname(contactDetails.getCname());
        contact.setClname(contactDetails.getClname());
        contact.setCemail(contactDetails.getCemail());
        contact.setCsubject(contactDetails.getCsubject());
        contact.setCproblem(contactDetails.getCproblem());
        contact.setCexp(contactDetails.isCexp());

        final Contact updatedContact = contactRepository.save(contact);
        return ResponseEntity.ok(updatedContact);
    }

    @DeleteMapping("/contact/{id}")
    public Map<String, Boolean> deleteContact(@PathVariable(value = "id") Long contactId)
            throws ResourceNotFoundException {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found for this id :: " + contactId));

        contactRepository.delete(contact);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
