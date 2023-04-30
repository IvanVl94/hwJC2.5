package com.skyPro.HomeWorkJC25;


public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException (String message ){
        super(message);
    }
}
