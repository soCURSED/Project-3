package com.example.bookmanagement.Repo;

import com.example.bookmanagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoUser extends JpaRepository<User,Integer> {

//List<User> findUserById(Integer userId);
}
