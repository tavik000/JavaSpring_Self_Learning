package com.key.dao;


import com.key.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface EmployeeDao {
    Employee queryById(long id);

    List<Employee> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    int addEmployee(Employee employee);

    int updateEmployee(Employee employee);

    int deleteEmployeeById(long id);
}