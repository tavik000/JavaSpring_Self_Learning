package com.key.web;

import com.key.entity.Employee;
import com.key.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by key, learn from hisenyuan on 5/Sep/2017 at 21:37.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String list(Model model) {
        List<Employee> list = employeeService.getList(0, 10000);
        model.addAttribute("list", list);
        return "list";// WEB-INF/jsp/"list".jsp
    }

    @RequestMapping(value = "/detail/{empId}", method = RequestMethod.GET)
    private String detail(@PathVariable("empId") Long empId, Model model) {
        Employee employee = employeeService.getById(empId);
        model.addAttribute("employee", employee);
        return "detail";
    }

    @RequestMapping(value = "/gotoAdd", method = RequestMethod.GET)
    private String gotoAdd(Model model) {
        return "add";// WEB-INF/jsp/"add".jsp
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    private String add(Employee employee) {
        Employee hasEmployee = employeeService.getById(employee.getEmpId());
        int i = -2;
        if (hasEmployee == null) {
            i = employeeService.addEmployee(employee);
        }
        return i > 0 ? "success" : "error";
    }

    @RequestMapping(value = "/del/{empId}", method = RequestMethod.GET)
    private String deleteEmployeeById(@PathVariable("empId") Long id) {
        int i = employeeService.deleteEmployeeById(id);
        return "redirect:/employee/list";  //重定向list
    }
}