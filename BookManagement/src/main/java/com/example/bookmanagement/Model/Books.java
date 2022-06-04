package com.example.bookmanagement.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@AllArgsConstructor  @NoArgsConstructor
@Valid @Data @Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "ID should NOT be NULL!")
    private Integer id;
    @NotEmpty(message = "Book Name should NOT be Empty!")
    private String name;
    @NotEmpty(message = "Genre should NOT be Empty!")
    private String genre;



    // book and user M:1
    @ManyToOne
    private User user;

    // book and loan M:M
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Loan> loanSet;





}
