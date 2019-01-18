package se.chriskevin.microservice.springboot.exception;

import java.time.LocalDateTime;
import java.util.Collections;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionMapper extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {RuntimeException.class})
  protected ResponseEntity<ApiError> handleRuntimeException(
      final RuntimeException e, final WebRequest request) {
    return new ResponseEntity<>(
        new ApiError(
            Collections.emptyList(),
            e.getMessage(),
            HttpStatus.INTERNAL_SERVER_ERROR,
            LocalDateTime.now()),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
