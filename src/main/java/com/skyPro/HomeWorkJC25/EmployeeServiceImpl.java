package com.skyPro.HomeWorkJC25;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    public final Map<String, Employee> employees = new HashMap<>();
    public String firstName;
    public String lastName;
    public Integer salary;
    public Integer department;
    private final  int EMPLOYEES_STORAGE_SIZE = 8;
    @Override
    public Employee addEmployee(String firstName, String lastName, Integer salary, Integer department) {
        String employeeKey = getEmployeeKey(firstName, lastName);

        employees.put(employeeKey, new Employee(firstName, lastName, salary, department));

        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        if (employees.size() == EMPLOYEES_STORAGE_SIZE){
            throw new EmployeeStorageIsFullException("Коллекция переполнена");
    }
        employees.put(employeeKey, new Employee(firstName, lastName, salary, department));

        return employees.get(employeeKey);
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        String employeeKey = getEmployeeKey(firstName, lastName);
        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException("Такой сотрудник не найден");
        }
       employees.remove(employeeKey);
    }
    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String employeeKey = getEmployeeKey(firstName, lastName);
        if (!employees.containsKey(employeeKey))
            throw new EmployeeNotFoundException("Такой сотрудник не найден");
        return employees.get(employeeKey);
    }

    @Override
    public Map<String, Employee> getAllEmployees() {
        return employees;
    }
    private String getEmployeeKey(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}


