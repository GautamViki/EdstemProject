package com.edstem.controller;

import com.edstem.entity.Contact;
import com.edstem.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("/")
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.saveContact(contact);
    }

    @GetMapping("/{id}")
    public Contact viewById(@PathVariable Integer id) {
        return contactService.findById(id);
    }

    @GetMapping("/fName/{name}")
    public List<Contact> viewByName(@PathVariable String name) {
        List<Contact> list = contactService.findByFirstName(name);
        return list;
    }

    @GetMapping("/start/{subString}")
    public List<Contact> viewByStart(@PathVariable String subString) {
        List<Contact> contacts = contactService.findAllContact();
        List<Contact> list = contacts.stream()
                .filter(obj -> obj.getFirstName().startsWith(subString))
                .collect(Collectors.toList());
        return list;
    }
}
