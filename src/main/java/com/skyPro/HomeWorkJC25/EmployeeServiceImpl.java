package com.skyPro.HomeWorkJC25;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees = new ArrayList<>();
    private final int length = 9;

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        employees.add(employee);

        if (!employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        if (employees.size() > length) {
            throw new EmployeeStorageIsFullException("Коллекция переполнена}");
        }
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Такой сотрудник не найден");
        }
        employees.remove(employee);
        return employee;
    }


    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (!employees.contains(employee))
            throw new EmployeeNotFoundException("Такой сотрудник не найден");

        for (Employee value : employees) {
            if (value.equals(employee)) {
                return employee;
            }
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employees;
    }
}
