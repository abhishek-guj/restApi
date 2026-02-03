package com.assignment.restApi.entities;


import jakarta.persistence.*;
<<<<<<< HEAD
=======
import jakarta.validation.constraints.NotBlank;
>>>>>>> ccac54b (new project)
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee {
<<<<<<< HEAD
=======

    public interface Create {
    }

    public interface Update {
    }


>>>>>>> ccac54b (new project)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    private String employeeFName;
    private String employeeLName;
=======
    @NotBlank(groups = {Update.class}, message = "fname is required")
    private String employeeFName;
    @NotBlank(message = "lname is required")
    private String employeeLName;
    @NotBlank(message = "department is required")
>>>>>>> ccac54b (new project)
    private String department;

    private String profileImagePath;

    private boolean is_deleted = false;
}
