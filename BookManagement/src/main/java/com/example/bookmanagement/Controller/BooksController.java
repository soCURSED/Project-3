package com.example.bookmanagement.Controller;

import com.example.bookmanagement.DTO.API;
import com.example.bookmanagement.Model.Books;
import com.example.bookmanagement.Model.Loan;
import com.example.bookmanagement.Model.User;
import com.example.bookmanagement.Service.BooksService;
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
@RequestMapping("/api/v1/books")
public class BooksController {

    //Services & Repo
    private final BooksService booksService;
    Logger logs= LoggerFactory.getLogger(BooksController.class);


    // Code
    @GetMapping
    public ResponseEntity getAllBooks(){
        logs.info(">> getAllBooks << in |BooksController| Has been used. All books have been displayed!");
        return ResponseEntity.status(200).body(booksService.getAllBooks());
    }

    @PostMapping
    public ResponseEntity addNewBooks(@RequestBody @Valid Books books){
        logs.info(">> addNewBooks << in |BooksController| Has been used. New Book Added!");
        booksService.addNewBooks(books);
        return ResponseEntity.status(201).body(new API("New Book Added!",201));

    }


    @PostMapping("/lend/{userId}/{bookId}")
    public ResponseEntity LendBookToUser(@PathVariable Integer bookId, @PathVariable Integer userId){
        logs.info(">> LendBookToUser << in |BooksController| Has been used. A book lent to user!");
        booksService.LendBookToUser(bookId,userId);
        return ResponseEntity.status(201).body(new API("Book Lent to user!",201));
    }

    @PostMapping("/return/{bookId}")
    public ResponseEntity returnBook(@PathVariable Integer bookId){
        logs.info(">> returnBook << in |BooksController| Has been used. A user has returned the book!");
        booksService.returnBook(bookId);
        return ResponseEntity.status(201).body(new API("Book Returned!",201));
    }
}
