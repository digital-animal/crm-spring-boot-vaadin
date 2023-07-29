package com.example.application.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.application.data.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query(value = """
            SELECT c.*
            FROM contacts c
            WHERE LOWER(c.firstName) LIKE LOWER(CONCAT('%', :searchTerm ,'%'))
            OR LOWER(c.lastName) LIKE LOWER(CONCAT('%', :lastTerm ,'%'))
            ORDER BY c.firstName ASC
            """, nativeQuery = true)
    List<Contact> search(@Param("searchTerm") String searchTerm);
}
