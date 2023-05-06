package com.skyPro.HomeWorkJC25;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public String addEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ){
        return employeeService.addEmployee(firstName, lastName);
    }
    @GetMapping("/remove")
    public String removeEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ){
        return employeeService.removeEmployee(firstName, lastName);
    }
    @GetMapping("/find")
    public String findEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ){
        return employeeService.findEmployee(firstName, lastName);
    }
    @GetMapping("/get")
    public Map<String, Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

}
