package com.skyPro.HomeWorkJC25;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class DepartmentServiceImpl implements DepartmentServise {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeMaxSalary(Integer departments) {
        return employeeService.getAllEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals(departments))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee getEmployeeMinSalary(Integer departments) {
        return employeeService.getAllEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals(departments))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Map<Integer, List<Employee>> getGroupDepartments(Integer departments) {
        return employeeService.getAllEmployees().values().stream()
                .filter(employee -> departments == null || employee.getGroupDepartments().equals(departments))
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
