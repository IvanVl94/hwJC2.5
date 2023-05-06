package com.skyPro.HomeWorkJC25;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface EmployeeService {
    String addEmployee (String firstName, String lastName);
    String removeEmployee (String firstName, String lastName);
    String findEmployee (String firstName, String lastName);
    Map<String, Employee> getAllEmployee();
    String employeeKey(String firstName, String lastName);
}
