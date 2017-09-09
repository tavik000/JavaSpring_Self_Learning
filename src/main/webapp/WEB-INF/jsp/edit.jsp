<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/7
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<head>
    <title>Edit Employee</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-tabs">
                <li><a href="<%=appPath%>/employee/list">Home</a></li>
                <li class="active"><a href="<%=appPath%>/employee/gotoAdd">Edit Employee Detail</a></li>
                <li class="disabled"><a href="#">Information</a></li>
            </ul>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    Edit Employee
                    <small>Edit Employee Detail</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" id="edit" method="post" action="<%=appPath%>/employee/edit" accept-charset="utf-8">
                <div class="form-group">
                    <label>Employee ID</label><input class="form-control" name="empId" readonly="readonly" value="${requestScope.get('employee').empId}"/>
                </div>
                <div class="form-group">
                    <label>Employee Name</label><input class="form-control" name="empName" value="${requestScope.get('employee').empName}"/>
                </div>
                <div class="form-group">
                    <label>Job</label><input class="form-control" name="job" value="${requestScope.get('employee').job}"/>
                </div>
                <div class="form-group">
                    <label>Hire Date</label><input class="form-control" name="hiredate" value="${requestScope.get('employee').hiredate}"/>
                </div>
                <div class="form-group">
                    <label>Salary</label><input class="form-control" name="salary" value="${requestScope.get('employee').salary}"/>
                </div>
                <button class="btn btn-default" id="sub">Submit</button>
                <button class="btn btn-default" id="cancel">Cancel</button>
            </form>
        </div>
    </div>

    <div id="warning" class="row clearfix" style="display:none;">
        <div class="col-md-12 column">
            <div class="alert alert-dismissable alert-danger">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×
                </button>
                <strong>Warning：</strong><span id="warning-text"></span>
            </div>
        </div>
    </div>
</div>

<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
    function list() {
        window.location.href="<%=appPath%>/employee/list";
    }
    $('#warning').css('display', 'none');
    var frm = $('#edit');
    frm.submit(function (ev) {
        $.ajax({
            type: frm.attr('method'),
            url: frm.attr('action'),
            data: frm.serialize(),
            success:function(data) {
                list();
            },
            error:function(data){
                alert("Failure");
            }
        });
        ev.preventDefault();
    });
    $(function() {
        $("#cancel").click(function(event) {
            event.preventDefault();
            list();
        });
    })
</script>
</body>
</html>
