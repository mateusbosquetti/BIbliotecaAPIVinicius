package net.weg.bibliotecaapi.ErrorHandler;

import jakarta.validation.ConstraintViolationException;
import net.weg.bibliotecaapi.DTO.Response.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(exception = {NoSuchElementException.class})
    public ResponseEntity<ErrorResponseDTO> handleNoSuchElement(NoSuchElementException noSuchElementException) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(noSuchElementException.getMessage(), Instant.now());
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(exception = {MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public ResponseEntity<ErrorResponseDTO> handleValidated (Exception exception) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(exception.getMessage(), Instant.now());
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_ACCEPTABLE);
    }

}
