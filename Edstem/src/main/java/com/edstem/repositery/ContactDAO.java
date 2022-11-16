package com.edstem.repositery;

import com.edstem.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactDAO extends JpaRepository<Contact,Integer> {
    public List<Contact> findByFirstName(String firstName);
}
