package com.skyPro.HomeWorkJC25;

import java.util.HashMap;
import java.util.Map;



public abstract class EmployeeServiceImpl implements EmployeeService {

    private static final int EMPLOYEES_STORAGE_SIZE = 100;
    private final Map<String, Employee> employees = new HashMap<>();


    public Employee addEmployee() {
        return addEmployee();
    }

    @Override
    public String addEmployee(String firstName, String lastName, Integer salary, Integer department) {
        String employeeKey = employeeKey(firstName, lastName);

        employees.put(employeeKey, new Employee(firstName, lastName, salary, department));

        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        if (employees.size() == EMPLOYEES_STORAGE_SIZE)
            throw new EmployeeStorageIsFullException("Коллекция переполнена");
        {


        }

        return employeeKey;
    }

    @Override
    public String removeEmployee(String firstName, String lastName, Integer salary, Integer department) {
        String employeeKey = employeeKey(firstName, lastName, salary, department);

        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException("Такой сотрудник не найден");
        }

        Employee remove = employees.remove(employeeKey);

        return employeeKey;
    }

    @Override
    public String findEmployee(String firstName, String lastName, Integer salary, Integer department) {
        return null;
    }


    @Override
    public String findEmployee(String firstName, String lastName) {
        String employeeKey = employeeKey(firstName, lastName);

        if (!employees.containsKey(employeeKey))
            throw new EmployeeNotFoundException("Такой сотрудник не найден");

        return employeeKey;
    }

    public Map<String, Employee> getAllEmployee() {
        return employees;
    }


    public String employeeKey(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}


