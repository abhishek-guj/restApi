package com.assignment.restApi.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee {

    public interface Create {
    }

    public interface Update {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(groups = {Update.class}, message = "fname is required")
    private String employeeFName;
    @NotBlank(message = "lname is required")
    private String employeeLName;
    @NotBlank(message = "department is required")
    private String department;

    private String profileImagePath;

    private boolean is_deleted = false;
}
