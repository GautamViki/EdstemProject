package com.edstem.service;

import com.edstem.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {
    public Contact saveContact(Contact contact);

    public Contact findById(Integer id);

    public List<Contact> findByFirstName(String firstName);

    public List<Contact> findAllContact();

}
