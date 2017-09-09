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
					Simple CRUD operations
					<small>Employee System - SSM framework</small>
				</h1>
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h3>Author: key </h3>
				<h3> Reference:<a href="https://github.com/hisenyuan/SSM_BookSystem" target="_blank">Hisen Book System</a></h3>
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<button id="employeeSystem" type="button" class="btn btn-default btn-lg">Here We Go</button>
			</div>
		</div>
	</div>
</div>
</body>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
    function list() {
        window.location.href="<%=appPath%>/employee/list";
    }

    $(function() {
        $("#employeeSystem").click(function() {
            list();
        });
    })
</script>
</html>