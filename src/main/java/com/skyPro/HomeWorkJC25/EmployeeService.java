package com.skyPro.HomeWorkJC25;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface EmployeeService {
    String addEmployee(String firstName, String lastName);

    abstract String addEmployee(String firstName, String lastName, Integer salary, Integer department);
    String removeEmployee (String firstName, String lastName, Integer salary, Integer department);
    String findEmployee (String firstName, String lastName, Integer salary, Integer department);

    String findEmployee(String firstName, String lastName);

    Map<String, Employee> getAllEmployee();
    String employeeKey(String firstName, String lastName, Integer salary, Integer department);
}
