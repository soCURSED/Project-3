package com.example.bookmanagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor
@Valid @Data @Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "ID should NOT be NULL!")
    private Integer id;
    @NotEmpty(message = "User Name should NOT be Empty!")
    private String username;
    @NotEmpty(message = "Password should NOT be Empty!")
    private String password;


    // user and book 1:M
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Books> booksSet;
}
