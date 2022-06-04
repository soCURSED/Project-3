package com.example.bookmanagement.Controller;

import com.example.bookmanagement.DTO.API;
import com.example.bookmanagement.Model.User;
import com.example.bookmanagement.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    //Services & Repo
    private final UserService userService;
    Logger logs= LoggerFactory.getLogger(UserController.class);


    // Code
    @GetMapping
    public ResponseEntity getUsers(){
        logs.info(">> getUsers << in |UserController| Has been used. All users have been displayed!");
    return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity addNewUser(@RequestBody @Valid User user){
        logs.info(">> addNewUser << in |UserController| Has been used. New User Added!");
        userService.addNewUser(user);
        return ResponseEntity.status(201).body(new API("New User Added!",201));

    }


}
