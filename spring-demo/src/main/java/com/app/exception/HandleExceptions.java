package com.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.entity.APIError;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;

@RestControllerAdvice
public class HandleExceptions {

	public ResponseEntity<APIError> validationException(ValidationException ex, HttpServletRequest request) {
		APIError apiError = new APIError();
		apiError.setErrorMessage(ex.getLocalizedMessage());
		apiError.setErrorCode(HttpStatus.BAD_REQUEST.toString());
		return ResponseEntity.ok(apiError);
	}
}
