package com.skyPro.HomeWorkJC25;

import java.util.List;
import java.util.Map;

interface DepartmentServiseImpl {
    Employee getEmployeeMaxSalary (Integer departments);

    Employee getEmployeeMinSalary(Integer departments);
    Map<Integer, List<Employee>> getGroupDepartmens (Integer departmets);
}
