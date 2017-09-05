package com.key.service;

import com.key.entity.Employee;

import java.util.List;

/**
 * Created by key, learn from hisenyuan on 5/Sep/2017 at 21:37.
 */
public interface EmployeeService {
    Employee getById(long empId);
    List<Employee> getList(int start, int pageNum);
    int addEmployee(Employee employee);
    int updateEmployee(Employee employee);
    int deleteEmployeeById(long id);
}