package com.example.bookmanagement.Repo;

import com.example.bookmanagement.Model.Loan;
import com.example.bookmanagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoLoan extends JpaRepository<Loan,Integer> {


}
