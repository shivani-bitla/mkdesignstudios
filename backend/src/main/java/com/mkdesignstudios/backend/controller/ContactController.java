package com.mkdesignstudios.backend.controller;

import com.mkdesignstudios.backend.model.Contact;
import com.mkdesignstudios.backend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/contact")
    public Contact createContact(@RequestBody Contact contact) {
        if (contact.getStatus() == null || contact.getStatus().isEmpty()) {
            contact.setStatus("received");
        }
        return contactRepository.save(contact);
    }

    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
