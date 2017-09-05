package com.key.test;

import com.key.dao.EmployeeDao;
import com.key.entity.Employee;
import java.util.List;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by key, learn from hisenyuan on 5/Sep/2017 at 21:37.
 */
public class EmployeeDaoTest extends BaseTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private EmployeeDao employeeDao;

    @Test
    public void addEmployee() {
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setEmpName("testPerson " + i);
            employee.setJob("testJob " + i);
            employee.setHiredate("2017-9-5");
            employee.setSalary((float) 1000 + i);
            int num = employeeDao.addEmployee(employee);
        }
    }

    @Test
    public void queryById() {
        Employee employee = employeeDao.queryById(1);
        System.out.println(employee);
    }

    @Test
    public void queryAll() {
        List<Employee> employees = employeeDao.queryAll(1, 10000);
        System.out.println(employees);
    }

    @Test
    public void updateEmployee() {
        Employee employee = employeeDao.queryById(8974);
        employee.setEmpName("updatePerson");
        employee.setJob("updateJob");
        employee.setHiredate("2017-9-30");
        employee.setSalary((float) 2000);
        int num = employeeDao.updateEmployee(employee);
    }

    @Test
    public void deleteEmployeeById() {
        employeeDao.deleteEmployeeById(8974);
    }
}