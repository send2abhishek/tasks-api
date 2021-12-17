package com.coding.project.taksapi.web.exceptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HashMap<String, String> handleNoHandlerFound(NotFoundException e, final HttpServletRequest httpServletRequest) {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", e.getLocalizedMessage());
        response.put("path", httpServletRequest.getRequestURI());
        return response;
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        ApiError apiError = new ApiError(HttpStatus.METHOD_NOT_ALLOWED);
//        apiError.setMessage(ex.getMessage());
//        apiError.setPath(((ServletWebRequest)request).getRequest().getRequestURI().toString());
//        logger.warn(ex.getMessage());

        HashMap<String, String> response = new HashMap<>();
        response.put("message",ex.getMessage());
        response.put("path",((ServletWebRequest)request).getRequest().getRequestURI().toString());
        return new ResponseEntity<>(response,HttpStatus.METHOD_NOT_ALLOWED);

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNoHandlerFoundException(NoHandlerFoundException ex) {

        return "Specified path not found on this server";
    }
}
