package com.wiley.traineesapp.exception;


import com.wiley.traineesapp.dto.ErrorResponseDto;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TraineeApiErrorHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleRecordNotFoundException(RecordNotFoundException ex,
                                                                          HttpServletRequest request){
        HttpStatus status=HttpStatus.NOT_FOUND;
        ErrorResponseDto errorResponseDto=
                new ErrorResponseDto(LocalDateTime.now(), status.value(),
                        status.getReasonPhrase(), ex.getMessage(),request.getRequestURI());
                return ResponseEntity.status(status).body(errorResponseDto);
    }


    //This should be written at the last
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleAllException(Exception ex){
     HttpStatus status=HttpStatus.INTERNAL_SERVER_ERROR;
     ProblemDetail problemDetail=ProblemDetail.forStatusAndDetail(status,ex.getMessage());
     return problemDetail;
    }
}
