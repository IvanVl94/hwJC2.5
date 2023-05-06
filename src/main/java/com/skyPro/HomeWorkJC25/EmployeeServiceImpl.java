package com.skyPro.HomeWorkJC25;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>();
    private final int length = 9;

    @Override

    public String addEmployee(String firstName, String lastName) {
        String employeeKey = employeeKey(firstName, lastName);

        employees.put(employeeKey, new Employee(firstName, lastName));

        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        if (employees.size() > length) {
            throw new EmployeeStorageIsFullException("Коллекция переполнена");
        }
        return employeeKey;
    }

    @Override
    public String removeEmployee(String firstName, String lastName) {
        String employeeKey = employeeKey(firstName, lastName);

        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException("Такой сотрудник не найден");
        }

        employees.remove(employeeKey);

        return  employeeKey;
    }


    @Override
    public String findEmployee(String firstName, String lastName) {
        String employeeKey = employeeKey(firstName, lastName);

        if (!employees.containsKey(employeeKey))
            throw new EmployeeNotFoundException("Такой сотрудник не найден");

        return employeeKey;
    }

    @Override
    public Map<String, Employee> getAllEmployee() {
        return employees;
    }

    public String employeeKey(String firstName, String lastName) {
        return firstName+" " +lastName;
    }
}
