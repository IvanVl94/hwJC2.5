package com.skyPro.HomeWorkJC25;

import java.util.List;
import java.util.Map;

interface DepartmentServise {
    Employee getEmployeeMaxSalary (Integer departments);
    Employee getEmployeeMinSalary(Integer departments);
    Map<Integer, List<Employee>> getGroupDepartments(Integer departments);
}
