package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactService {
    private ContactRepository contactRepository;

    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }

    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

}
