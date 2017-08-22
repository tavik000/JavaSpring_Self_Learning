package com.key.dao;


import com.key.dao.GetSql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

    public static void DeleteMethod( Integer id){
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
            //预处理删除数据


            psql = Sql.con.prepareStatement("delete from emp where empno = ?");
            psql.setFloat(1, id);
            psql.executeUpdate();
            psql.close();

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
