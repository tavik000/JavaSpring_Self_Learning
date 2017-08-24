package com.key.dao;


import com.key.pojo.Employee;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Edit {

    public static void EditMethod(Employee emp, Integer oriId){
        GetSql Sql = GetSql.getInstance();
        try {
            if(!Sql.con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = Sql.con.createStatement();
            //要执行的SQL语句
            String sql = "select * from emp";
            //3.ResultSet类，用来存放获取的结果集！！
            Sql.rs = statement.executeQuery(sql);


            //修改
            PreparedStatement psql;
            //预处理修改数据，其中有6个参数--“？”
            psql = Sql.con.prepareStatement("update emp set empno = ?, ename = ?, job = ?, hiredate = ?, sal = ? where empno = ?");
            psql.setInt(1, emp.getId());
            psql.setString(2, emp.getName());
            psql.setString(3, emp.getJob());
            psql.setString(4, emp.getHiredate());
            psql.setFloat(5,emp.getSalary());
            psql.setFloat(6,oriId);
            psql.executeUpdate();


        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("Successful access to the Database！！");
        }
    }



    public static void main(String[] args) {

    }
}
