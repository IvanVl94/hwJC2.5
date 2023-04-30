package com.skyPro.HomeWorkJC25;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService {
    Employee addEmployee (String firstName, String lastName);
    Employee removeEmployee (String firstName, String lastName);
    Employee findEmployee (String firstName, String lastName);
    List<Employee> getAllEmployee();
}
