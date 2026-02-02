package com.assignment.restApi.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeFName;
    private String employeeLName;
    private String department;

    private String profileImagePath;

    private boolean is_deleted = false;
}
