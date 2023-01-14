package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String firstName;
    @NonNull
    private String surName;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<SchoolClass> schoolClasses;
}
