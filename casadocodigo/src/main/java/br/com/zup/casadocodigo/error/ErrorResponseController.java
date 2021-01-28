package br.com.zup.casadocodigo.error;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorResponseController {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorResponse>> responseMethodArgumentNotValidException(MethodArgumentNotValidException errors){
        List<ErrorResponse> errorsCaptured = new ArrayList<>();
        for(FieldError fieldError:errors.getBindingResult().getFieldErrors()){
            errorsCaptured.add(new ErrorResponse(fieldError.getField(),fieldError.getDefaultMessage()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorsCaptured);
    }

}
