package net.weg.produtosestoque.controller;

import net.weg.produtosestoque.model.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponseDTO> handleNoSuchElementException(NoSuchElementException e) {
        return new ResponseEntity<>( new ErrorResponseDTO( e.getMessage() , Instant.now() )  , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<ErrorResponseDTO> handleDuplicateEntryException(DuplicateEntryException e) {
        return new ResponseEntity<>( new ErrorResponseDTO( e.getMessage() , Instant.now() )  , HttpStatus.CONFLICT);
    }
}
