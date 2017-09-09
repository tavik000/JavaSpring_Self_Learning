<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/6
  Time: 20:10
  note: 使用bootstrap输出后台返回的requestScope对象
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<head>
    <title>Employee List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    Key
                    <small>Employee System - SSM framework</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-tabs">
                <li class="active"><a href="<%=appPath%>/employee/list">Home</a></li>
                <%--<li><a href="<%=appPath%>/employee/detail/1000">Employee Detail</a></li>--%>
                <li><a href="<%=appPath%>/employee/gotoAdd">Add Employee</a></li>
                <li class="disabled"><a href="#">Information</a></li>
            </ul>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>Employee List
                    <small>show current information of employee</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>Employee ID</th>
                    <th>Employee Name</th>
                    <th>Job</th>
                    <th>Hire Date</th>
                    <th>Salary</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="employee" items="${requestScope.get('list')}" varStatus="status">
                    <tr>
                        <td>${employee.empId}</td>
                        <td>${employee.empName}</td>
                        <td>${employee.job}</td>
                        <td>${employee.hiredate}</td>
                        <td>${employee.salary}</td>
                        <td>
                            <a href="<%=appPath%>/employee/detail/${employee.empId}">Detail</a> |
                            <a href="<%=appPath%>/employee/del/${employee.empId}">Delete</a>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://code.jquery.com/jquery.js"></script>
</body>
</html>