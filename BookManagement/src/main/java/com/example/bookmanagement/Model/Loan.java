package com.example.bookmanagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor
@Valid @Data @Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "userId Name should NOT be NULL!")
    private Integer userId ;
    @NotNull(message = "bookId should NOT be NULL!")
    private Integer bookId;



    // Loan and book M:M
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Books> booksSet;








}
