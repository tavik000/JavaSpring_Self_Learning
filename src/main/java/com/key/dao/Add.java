package com.key.dao;


import com.key.dao.GetSql;

import java.util.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import java.sql.PreparedStatement;

public class Add {

    public static void AddMethod(String name, Integer id, String job, String hiredate, Float salary){
        GetSql Sql = GetSql.getInstance();
        try {
            //加载驱动程序

            if (!Sql.con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = Sql.con.createStatement();
            //要执行的SQL语句
            Sql.sqlRq = "select * from emp";
            //3.ResultSet类，用来存放获取的结果集！！


            //修改
            PreparedStatement psql;
            //预处理添加数据，其中有两个参数--“？”
            psql = Sql.con.prepareStatement("insert into emp (empno,ename,job,hiredate,sal) " + "values(?,?,?,?,?)");
            psql.setInt(1, id);              //设置参数1，创建id为3212的数据
            psql.setString(2, name);      //设置参数2，name 为王刚
            psql.setString(3, job);

            DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            Date myDate2 = dateFormat2.parse(hiredate);
            psql.setDate(4, new java.sql.Date(myDate2.getTime()));
            psql.setFloat(5, (float) salary);
            psql.executeUpdate();

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
