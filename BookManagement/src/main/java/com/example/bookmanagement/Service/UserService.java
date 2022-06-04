package com.example.bookmanagement.Service;

import com.example.bookmanagement.Model.User;
import com.example.bookmanagement.Repo.RepoUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor

public class UserService {

    private final RepoUser repoUser;


    public List<User> getAllUsers() {
       return repoUser.findAll();
    }


    public User addNewUser(User user) {
        return repoUser.save(user);
    }
}
