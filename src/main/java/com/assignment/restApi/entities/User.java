package com.assignment.restApi.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
<<<<<<< HEAD
@Table
=======
@Table(name = "users")
>>>>>>> ccac54b (new project)
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

<<<<<<< HEAD
    @NotBlank
    private String username;

    @Email
    @NotEmpty
    private String email;
=======
    // @NotBlank
    // private String username;

    // @Email
    // @NotEmpty
    // private String email;
>>>>>>> ccac54b (new project)

}
