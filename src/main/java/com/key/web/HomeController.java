//package com.key.web;
//
//import java.lang.reflect.Method;
//import java.text.DateFormat;
//import java.util.Date;
//import java.util.Locale;
//
//import com.key.dao.Add;
//import com.key.dao.Delete;
//import com.key.dao.Edit;
//import com.key.dao.GetSql;
//import com.key.entity.Employee;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
///**
// * Handles requests for the application home page.
// */
//@Controller
//public class HomeController {
//
//    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
//    private HttpServletRequest request;
//
//    /**
//     * Simply selects the home view to render by returning its name.
//     */
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String hocme(Locale locale, Model model) {
//
//        logger.info("Welcome home! The client locale is {}.", locale);
//        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//
//        String formattedDate = dateFormat.format(date);
//
//        model.addAttribute("serverTime", formattedDate);
//
//        String idStr = "YAya";
//
//        try {
//            Method method = GetSql.class.getMethod("main", String[].class);
//            method.invoke(GetSql.class.newInstance(), new Object[]{new String[]{idStr}});
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        // get SQL data
//        GetSql Sql = GetSql.getInstance();
//        Sql.connect();
//        Sql.display(model);
//        Sql.showMessage();
//
//
//        return "home";
////        return "EditEmployee";
//
//    }
//
//
//    @RequestMapping("/AddEmployee")
//    public String ToAddPage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//
////            resp.getWriter().println("hello HttpServletResponse");
//        return "AddEmployee";
//    }
//
//    @RequestMapping("/AddEmployeeMethod")
//    public String AddEmp(HttpServletRequest req, HttpServletResponse resp, Model model, Employee emp) throws Exception {
//
//
////        String name = req.getParameter("name");//同Servlet一样，获取页面属性名叫name的值
////        Integer id = Integer.parseInt(request.getParameter("id"));
////        String job = req.getParameter("job");
////        String hiredate = req.getParameter("hiredate");
////        Float salary = Float.parseFloat(req.getParameter("salary"));
//
//
//        Add.AddMethod(emp.getName(), emp.getId(), emp.getJob(), emp.getHiredate(), emp.getSalary());
//        GetSql Sql = GetSql.getInstance();
//        Sql.connect();
//        Sql.display(model);
//
//        return "home";
//    }
//
//    @RequestMapping("/delete/{id}")
//    public String DeleteEmp(HttpServletRequest req, HttpServletResponse res, Model model, @PathVariable int id) throws Exception {
//        Delete.DeleteMethod(id);
//
//        GetSql Sql = GetSql.getInstance();
//        Sql.connect();
//        Sql.display(model);
//        return "home";
//    }
//
//    @RequestMapping("/edit")
//    public String ToEditPage(HttpServletRequest req, HttpServletResponse res, Model model) throws Exception {
//
//        Integer id = Integer.parseInt(req.getParameter("id"));
//        String name = req.getParameter("name");
//        String job = req.getParameter("job");
//
//        String hiredate = req.getParameter("hiredate");
//        Float salary = Float.parseFloat(req.getParameter("salary"));
//
//        Employee emp = new Employee();
//        emp.setId(id);
//        emp.setName(name);
//        emp.setJob(job);
//        emp.setHiredate(hiredate);
//        emp.setSalary(salary);
//
//
//        model.addAttribute("emp", emp);
//        model.addAttribute("oriId", id);
//
////        request.setAttribute("id",emp.getId());
//
//        return "EditEmployee";
//    }
//
//    @RequestMapping("/EditEmployeeMethod")
//    public String EditEmp(HttpServletRequest req, HttpServletResponse resp, Model model, Employee emp) throws Exception {
//
//        Integer id = Integer.parseInt(req.getParameter("oriId"));
//        Edit.EditMethod(emp, id);
//        GetSql Sql = GetSql.getInstance();
//        Sql.connect();
//        Sql.display(model);
//
//        return "home";
//    }
//
//
////	@RequestMapping("/home")
////	public String hello(){
////		System.out.println("inside hello()");
////		return "home";
////	}
//
//}
