package com.mkdesignstudios.backend.repository;

import com.mkdesignstudios.backend.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {
}
