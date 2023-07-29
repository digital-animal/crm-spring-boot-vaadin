package com.example.application.data.generator;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.application.data.entity.Company;
import com.example.application.data.repository.CompanyRepository;

@Order(2)
@Component
public class CompanyGenerator implements CommandLineRunner {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {

        List<Company> companies = companyRepository.findAll();

        if (companies.size() == 0) {
            List<Company> newCompanies = new LinkedList<>();

            Company company1 = new Company();
            company1.setName("Google");
            company1.setEmployeeCount(12000);

            Company company2 = new Company();
            company2.setName("Microsoft");
            company2.setEmployeeCount(8000);

            Company company3 = new Company();
            company3.setName("Meta");
            company3.setEmployeeCount(15000);

            Company company4 = new Company();
            company4.setName("Amazon");
            company4.setEmployeeCount(16000);

            Company company5 = new Company();
            company5.setName("Apple");
            company5.setEmployeeCount(6000);

            newCompanies.add(company1);
            newCompanies.add(company2);
            newCompanies.add(company3);
            newCompanies.add(company4);
            newCompanies.add(company5);

            companyRepository.saveAll(newCompanies);
        }
    }

}
