package com.key.test;

import com.key.entity.Employee;
import com.key.service.EmployeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hisenyuan on 2017/5/3 at 20:16.
 */
public class EmployeeServiceImplTest extends EmployeeDaoTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void getById() {
        //在service里面改了一下名字，其实就是dao里面的queryById
        Employee employee = employeeService.getById(1);
        System.out.println(employee);
    }
}