package com.edstem.service;

import com.edstem.entity.Contact;
import com.edstem.repositery.ContactDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactDAO contactDAO;

    @Override
    public Contact saveContact(Contact contact) {

        return contactDAO.save(contact);
    }

    @Override
    public Contact findById(Integer id) {
        Optional<Contact> optional = contactDAO.findById(id);
        Contact contact = optional.get();
        if (optional.isPresent()) {
            return contact;
        }
        return null;
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        List<Contact> contacts = contactDAO.findByFirstName(firstName);
        if (!contacts.isEmpty()) {
            return contacts;
        }
        return null;
    }

    @Override
    public List<Contact> findAllContact() {
        List<Contact> contacts = contactDAO.findAll();
        return contacts;
    }


}
