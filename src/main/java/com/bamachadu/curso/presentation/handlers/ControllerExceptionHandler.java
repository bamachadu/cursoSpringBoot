package com.bamachadu.curso.presentation.handlers;

import javax.servlet.http.HttpServletRequest;

import com.bamachadu.curso.application.helpers.ObjectNotFoundException;
import com.bamachadu.curso.application.helpers.DataIntegrityException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception, HttpServletRequest request) {

    StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), exception.getMessage(),System.currentTimeMillis());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  @ExceptionHandler(DataIntegrityException.class)
  public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException exception, HttpServletRequest request) {

    StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), exception.getMessage(),System.currentTimeMillis());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<StandardError> validation(MethodArgumentNotValidException exception, HttpServletRequest request) {

    ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação",System.currentTimeMillis());

    for (FieldError x:  exception.getBindingResult().getFieldErrors()){
      error.addError(x.getField(), x.getDefaultMessage());
    }

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }
}
