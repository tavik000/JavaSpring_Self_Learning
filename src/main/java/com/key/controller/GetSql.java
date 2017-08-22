package com.key.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.key.model.Employee;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


public class GetSql {

    private HttpServletRequest request;

    private String job = null;
    private Integer id = null;
    private String name = null;
    private String hiredate = null;
    private Float salary = null;

    //声明Connection对象
    Connection con;
    //驱动程序名
    String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    String url = "jdbc:mysql://localhost:3306/sqltestdb";
    //MySQL配置时的用户名
    String user = "root";
    //MySQL配置时的密码
    String password = "Equilibrium2017#";
    //遍历查询结果集
    ResultSet rs = null;
    //要执行的SQL语句
    String sqlRq = null;


    private static GetSql instance = new GetSql();

    private GetSql() {
    }

    ;

    public static GetSql getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello GetSql");
    }

    public void disconnect() {
        try {
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void connect() {
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            sqlRq = "select * from emp";
            //3.ResultSet类，用来存放获取的结果集！！
            rs = statement.executeQuery(sqlRq);

//            For called by outer class objective, rs and con does not close.

        } catch (ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            System.out.println("Successful access to the Database！！");
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void display(Model model) {
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Result:");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Id" + "\t" + "Name" + "\t\t\t\t" + "Job" + "\t\t\t\t\t" + "Hire Date" + "\t" + "Salary");
        System.out.println("--------------------------------------------------------------------------------------------------------");

        try {
            List<Employee> empList = new ArrayList<>();
            while (rs.next()) {
                //获取数据
                Employee employee = new Employee();
                id = Integer.parseInt(rs.getString("empno"));


                name = rs.getString("ename");

                job = rs.getString("job");

                hiredate = rs.getString("hiredate");

                salary = rs.getFloat("sal");

                employee.setId(id);
                employee.setName(name);
                employee.setJob(job);
                employee.setHiredate(hiredate);
                employee.setSalary(salary);

                empList.add(employee);

                //输出结果
                System.out.println(id + "\t" + name + "\t\t\t" + job + "\t\t\t" + hiredate + "\t" + salary);

                model.addAttribute("empList", empList);
            }
        } catch (SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            System.out.println("Successful access to the Database！！");
        }


    }



    public static void main(String[] args) {

    }

}