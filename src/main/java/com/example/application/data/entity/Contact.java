package com.example.application.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "contacts")
public class Contact extends BaseEntity {

    @NotEmpty
    @Column(name = "first_name")
    private String firstName = "";

    @NotEmpty
    @Column(name = "last_name")
    private String lastName = "";

    @NotEmpty
    @Email
    @Column(name = "email")
    private String email = "";

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = true)
    @JsonIgnoreProperties({ "employees" })
    private Company company;

    @OneToOne
    @JoinColumn(name = "status_id", nullable = true)
    private Status status;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
