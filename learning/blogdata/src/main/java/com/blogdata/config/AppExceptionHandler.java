package com.blogdata.config;

import com.blogdata.users.entity.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
@Configuration
public class AppExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorObject> handlerUserNotFoundException(UserNotFoundException e){

        return new ResponseEntity<>(
                new ErrorObject(
                        e.getMessage(),
                        HttpStatus.NOT_FOUND.value(),
                        new Date(System.currentTimeMillis())
                ),
                HttpStatus.NOT_FOUND
        );
    }

    @Bean
    public ErrorObject getErrorObject(){
        return new ErrorObject();
    }
}


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class ErrorObject{
    String message;
    int statCode;
    Date when;
}