package com.example.bookmanagement.Service;

import com.example.bookmanagement.Model.Books;
import com.example.bookmanagement.Model.Loan;
import com.example.bookmanagement.Model.User;
import com.example.bookmanagement.Repo.RepoBooks;
import com.example.bookmanagement.Repo.RepoLoan;
import com.example.bookmanagement.Repo.RepoUser;
import com.example.bookmanagement.expecterrors.InvalidIDException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor

public class LoanService {

    private final RepoLoan repoLoan;
    private final RepoBooks repoBooks;
    private final RepoUser repoUser;


    public List<Loan> getAllLoans() {
        return repoLoan.findAll();
    }


    public Loan addNewLoan(Loan loan) {
        return repoLoan.save(loan);
    }


}
