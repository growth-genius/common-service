package com.gg.commonservice.advice;

import static com.gg.commonservice.utils.ApiUtil.fail;

import com.gg.commonservice.advice.exceptions.BadRequestException;
import com.gg.commonservice.advice.exceptions.ExpiredTokenException;
import com.gg.commonservice.utils.ApiUtil;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    private ResponseEntity<ApiUtil.ApiResult<?>> newResponse(Throwable throwable, HttpStatus status) {
        return newResponse(throwable.getMessage(), status);
    }

    private ResponseEntity<ApiUtil.ApiResult<?>> newResponse(String message, HttpStatus status) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<>(fail(message, status), headers, status);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ApiUtil.ApiResult<?>> defaultException(Exception e) {
        log.error("defaultException : {} ", e.getMessage());
        e.printStackTrace();
        return newResponse(e, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler({ExpiredTokenException.class})
    protected ResponseEntity<ApiUtil.ApiResult<?>> expiredTokenException(Exception e) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        log.error("expiredTokenException : {} ", e.getMessage());
        return new ResponseEntity<>(fail(e.getMessage(), -401), headers, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class, ConstraintViolationException.class, MethodArgumentNotValidException.class,
        BadRequestException.class, HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<?> handleBadRequestException(Exception e) {
        log.error("Bad request exception occurred: {}", e.getMessage(), e);
        if (e instanceof MethodArgumentNotValidException methodargumentnotvalidexception) {
            return newResponse(methodargumentnotvalidexception.getBindingResult().getAllErrors().get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
        return newResponse(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return newResponse(e, HttpStatus.BAD_REQUEST);
    }

}
