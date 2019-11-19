package com.api.countrydetails.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(CountryNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleResourceNotFound(final CountryNotFoundException exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());

		return error;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> customHandleNotFound(Exception ex, HttpServletRequest request) {

		ExceptionResponse errors = new ExceptionResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setErrorMessage(ex.getMessage());
		errors.setStatus(HttpStatus.NOT_FOUND.value());
		errors.callerURL(request.getRequestURI());

		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

	}

}
