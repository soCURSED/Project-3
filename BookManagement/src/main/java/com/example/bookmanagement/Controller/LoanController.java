package com.example.bookmanagement.Controller;

import com.example.bookmanagement.DTO.API;
import com.example.bookmanagement.Model.Loan;
import com.example.bookmanagement.Model.User;
import com.example.bookmanagement.Service.LoanService;
import com.example.bookmanagement.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/loan")
public class LoanController {

    //Services & Repo
    private final LoanService loanService;
    Logger logs= LoggerFactory.getLogger(LoanController.class);

    // Code
    @GetMapping
    public ResponseEntity getAllLoans(){
        logs.info(">> getAllLoans << in |LoanController| Has been used. All loans have been displayed!");
        return ResponseEntity.status(200).body(loanService.getAllLoans());
    }

    @PostMapping
    public ResponseEntity addNewLoan(@RequestBody @Valid Loan loan){
        logs.info(">> addNewLoan << in |LoanController| Has been used. New Loan Added!");
        loanService.addNewLoan(loan);
        return ResponseEntity.status(201).body(new API("New Loan Added!",201));

    }


}
