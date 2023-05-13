package com.skyPro.HomeWorkJC25;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final  DepartmentServiseImpl  departmentServiseImpl;
    public DepartmentController(DepartmentServiseImpl departmentServiseImpl) {
        this.departmentServiseImpl= departmentServiseImpl;

    }

    @GetMapping("/max-salary")

    public Employee getEmployeeMaxSalary(@RequestParam("departmentId") Integer departments) {
        return departmentServiseImpl.getEmployeeMaxSalary(departments);

    }
    @GetMapping("/min-salary")
    public Employee getEmployeeMinSalary(@RequestParam("departmentId") Integer departments) {
        return departmentServiseImpl.getEmployeeMinSalary(departments);

    }
    @GetMapping("/all")
    public Map <Integer, List<Employee>> getGroupDepartmens (
            @RequestParam (name = "departmentID", required = false)
            Integer departmentId){
        return  null;
    }
}
