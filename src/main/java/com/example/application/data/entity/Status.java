package com.example.application.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "statuses")
@Getter
@Setter
@NoArgsConstructor
public class Status extends BaseEntity {
    
    @NotBlank
    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
