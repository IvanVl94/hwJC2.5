package com.skyPro.HomeWorkJC25;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, Integer salary, Integer department);
    void removeEmployee (String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Map<String, Employee> getAllEmployees();
}
