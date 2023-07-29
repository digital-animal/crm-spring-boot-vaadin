package com.example.application.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.data.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
