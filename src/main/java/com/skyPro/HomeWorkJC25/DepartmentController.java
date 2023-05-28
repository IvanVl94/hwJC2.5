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
    private final DepartmentServise departmentServise;
    public DepartmentController(DepartmentServise departmentServise) {
        this.departmentServise= departmentServise;

    }
    @GetMapping("/max-salary")
    public Employee getEmployeeMaxSalary(@RequestParam("departmentId") Integer departments) {
        return departmentServise.getEmployeeMaxSalary(departments);
    }
    @GetMapping("/min-salary")
    public Employee getEmployeeMinSalary(@RequestParam("departmentId") Integer departments) {
        return departmentServise.getEmployeeMinSalary(departments);

    }
    @GetMapping("/all")
    public Map <Integer, List<Employee>> getGroupDepartmens (
            @RequestParam (name = "departmentID", required = false)
            Integer departmentId){
        return  departmentServise.getGroupDepartments(departmentId);
    }
}
