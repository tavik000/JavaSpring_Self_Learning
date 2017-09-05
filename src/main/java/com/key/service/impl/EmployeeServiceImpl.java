package com.key.service.impl;

import com.key.dao.EmployeeDao;
import com.key.entity.Employee;
import com.key.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by key, learn from hisenyuan on 5/Sep/2017 at 21:37.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired(required = false)
    private EmployeeDao employeeDao;

    @Override
    public Employee getById(long empId) {
        return employeeDao.queryById(empId);
    }

    @Override
    public List<Employee> getList(int start, int pageNum) {
        return employeeDao.queryAll(start, pageNum);
    }

    @Override
    public int addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    @Override
    public int deleteEmployeeById(long id) {
        return employeeDao.deleteEmployeeById(id);
    }
}