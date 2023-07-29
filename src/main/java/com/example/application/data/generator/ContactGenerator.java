package com.example.application.data.generator;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.application.data.entity.Company;
import com.example.application.data.entity.Contact;
import com.example.application.data.entity.Status;
import com.example.application.data.repository.CompanyRepository;
import com.example.application.data.repository.ContactRepository;
import com.example.application.data.repository.StatusRepository;
import com.github.javafaker.Faker;

@Order(3)
@Component
public class ContactGenerator implements CommandLineRunner {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        Faker faker = new Faker();

        List<Contact> contacts = contactRepository.findAll();

        if (contacts.size() == 0) {

            List<Contact> newContacts = new LinkedList<>();
            List<Company> companyList = companyRepository.findAll();
            List<Status> statusList = statusRepository.findAll();

            for (int i = 0; i < 50; i++) {
                Contact contact = new Contact();
                contact.setFirstName(faker.name().firstName());
                contact.setLastName(faker.name().lastName());
                contact.setEmail(faker.internet().emailAddress());

                contact.setCompany(companyList.get(new Random(123L).nextInt(companyList.size())));
                contact.setStatus(statusList.get(new Random(123L).nextInt(statusList.size())));

                newContacts.add(contact);
            }

            contactRepository.saveAll(newContacts);
        }
    }

}
