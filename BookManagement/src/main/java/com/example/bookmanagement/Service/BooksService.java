package com.example.bookmanagement.Service;

import com.example.bookmanagement.Model.Books;
import com.example.bookmanagement.Model.Loan;
import com.example.bookmanagement.Model.User;
import com.example.bookmanagement.Repo.RepoBooks;
import com.example.bookmanagement.Repo.RepoLoan;
import com.example.bookmanagement.Repo.RepoUser;
import com.example.bookmanagement.expecterrors.InvalidIDException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service @RequiredArgsConstructor

public class BooksService {

    private final RepoLoan repoLoan;
    private final RepoBooks repoBooks;
    private final RepoUser repoUser;


    public List<Books> getAllBooks() {
        return repoBooks.findAll();
    }


    public Books addNewBooks(Books books) {
        return repoBooks.save(books);
    }

    public void LendBookToUser(Integer bookId, Integer userId) {
    Optional<User> targer_useID = repoUser.findById(userId);
    Optional<Books> targer_bookID = repoBooks.findById(bookId);
        if (targer_useID.isEmpty() || targer_bookID.isEmpty()){
            throw new InvalidIDException("Invalid userId or bookId!");
        }

        Loan saveToLoan = new Loan();
        saveToLoan.setUserId(userId);
        saveToLoan.setBookId(bookId);
        targer_bookID.get().getLoanSet().add(saveToLoan);
        targer_bookID.get().setUser(targer_useID.get());
        repoBooks.save(targer_bookID.get());
    }
    public Set<Loan> returnBook(Integer bookId) {
        Optional<Books> targer_book = repoBooks.findById(bookId);
        if (targer_book.isEmpty()){
            throw new InvalidIDException("Invalid bookId!");
        }
        // return all books back instead of one by one
        return targer_book.get().getLoanSet();

    }
}
