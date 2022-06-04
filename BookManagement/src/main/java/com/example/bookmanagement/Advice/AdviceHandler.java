package com.example.bookmanagement.Advice;


import com.example.bookmanagement.DTO.API;
import com.example.bookmanagement.expecterrors.InvalidIDException;
import com.example.bookmanagement.expecterrors.NoFundsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceHandler {
    @ExceptionHandler(InvalidIDException.class)
    public ResponseEntity InvalidIDException(InvalidIDException E){
        String error = E.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(error,400));
    }

    @ExceptionHandler(NoFundsException.class)
    public ResponseEntity NoFundsException(NoFundsException E){
        String error = E.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(error,400));
    }
}
