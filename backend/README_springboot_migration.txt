# Spring Boot Migration Instructions

The Node.js/Express backend is being replaced by a Java Spring Boot backend. Please follow these steps:

1. Delete all files in the backend directory except this README.
2. Create a new Spring Boot project (using Spring Initializr or your IDE) with the following dependencies:
   - Spring Web
   - Spring Data MongoDB
   - (Optional) Spring Boot DevTools
   - (Optional) Lombok
3. Use the following Java code structure for your backend:

---

## Contact.java (Model)

package com.mkdesignstudios.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contacts")
public class Contact {
    @Id
    private String id;
    private String name;
    private String email;
    private String mobile;
    private String message;
    private String status = "received"; // Default value: received
    private java.util.Date createdAt = new java.util.Date();
    // Getters and setters
}

---

## ContactRepository.java

package com.mkdesignstudios.backend.repository;

import com.mkdesignstudios.backend.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {}

---

## ContactController.java

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

---

## application.properties

spring.data.mongodb.uri=YOUR_MONGODB_ATLAS_URI
server.port=5000

---

4. Build and run your Spring Boot backend. It will be available at http://localhost:5000/api/contact and http://localhost:5000/api/contacts

5. You can now delete this README after migration is complete.
