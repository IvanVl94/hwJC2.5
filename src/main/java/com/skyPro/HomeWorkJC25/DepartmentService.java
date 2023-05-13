package com.skyPro.HomeWorkJC25;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public  class DepartmentService implements DepartmentServiseImpl{
    private final EmployeeService employeeService;


    public DepartmentService (EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @Override
    public Employee getEmployeeMaxSalary(Integer departments) {
        return employeeService.getAllEmployee().values().stream()
                .filter(employee -> employee.getDepartment().equals(departments))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }


    @Override
    public Employee getEmployeeMinSalary(Integer departments) {
        return employeeService.getAllEmployee().values().stream()
                .filter(employee -> employee.getDepartment().equals(departments))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }
    @Override
    public Map<Integer, List<Employee>> getGroupDepartmens(Integer departmets){
        return employeeService.getAllEmployee().values().stream()
                .filter(employee -> departmets==null|| employee.getGroupDepartment().equals(departmets))
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
