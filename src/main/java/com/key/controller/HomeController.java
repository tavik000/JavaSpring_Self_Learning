package com.key.controller;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private HttpServletRequest request;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hocme(Locale locale, Model model) {

        logger.info("Welcome home! The client locale is {}.", locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        String idStr = "YAya";

        try {
            Method method = GetSql.class.getMethod("main", String[].class);
            method.invoke(GetSql.class.newInstance(), new Object[]{new String[]{idStr}});
        } catch (Exception e) {
            e.printStackTrace();
        }


        // get SQL data
        GetSql Sql = GetSql.getInstance();
        Sql.connect();
        Sql.display(model);
        Sql.showMessage();


        return "home";

    }


    @RequestMapping("/AddEmployee")
    public String handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

//            resp.getWriter().println("hello HttpServletResponse");
        return "AddEmployee";
    }

    @RequestMapping("/AddEmployeeMethod")
    public String ReturnHome(HttpServletRequest req, HttpServletResponse resp, Model model, Employee emp) throws Exception {



//        String name = req.getParameter("name");//同Servlet一样，获取页面属性名叫name的值
//        Integer id = Integer.parseInt(request.getParameter("id"));
//        String job = req.getParameter("job");
//        String hiredate = req.getParameter("hiredate");
//        Float salary = Float.parseFloat(req.getParameter("salary"));

        Add AddEmployee = new Add();
        Add.AddMethod(emp.getName(),emp.getId(),emp.getJob(),emp.getHiredate(),emp.getSalary());
        GetSql Sql = GetSql.getInstance();
        Sql.connect();
        Sql.display(model);
        Sql.showMessage();

        return "home";
    }


//	@RequestMapping("/home")
//	public String hello(){
//		System.out.println("inside hello()");
//		return "home";
//	}

}
