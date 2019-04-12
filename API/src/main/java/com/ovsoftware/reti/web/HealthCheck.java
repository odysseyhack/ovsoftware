package com.ovsoftware.reti.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Responsible for performing a Health Check.
 */

@RestController
@CrossOrigin
@ControllerAdvice
public class HealthCheck {
	
	@RequestMapping(value = "/health", method = RequestMethod.GET)
    public ResponseEntity<?> healthCheck() {
        return ResponseEntity.ok().build();
    }
}