package com.example.bookmanagement.Repo;

import com.example.bookmanagement.Model.Books;
import com.example.bookmanagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoBooks extends JpaRepository<Books,Integer> {

//List<Books> findBooksById(Integer bookId);
}
