package com.skyPro.HomeWorkJC25;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException (String message) {

        super(message);
    }
}
