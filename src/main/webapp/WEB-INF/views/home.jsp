<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1 align="center">
    Hello SpringMVC!
</h1>
<div id="empEdit" align="center">
    <a href="empform">Add Employee</a>
    <a href="viewemp">View Employees</a>

</div>


<div>

    <%-- <form:errors path="*" cssClass="errorblock" element="div"/>
     --%>

<hr>

        <table align="center" width="500" border="1px" cellpadding="0" cellspacing="0" >
            <thead>
            <tr>

                <th width="15">ID</th>
                <th width="25">Name</th>
                <th width="30">Job</th>
                <th width="40">Hire date</th>
                <th width="35">Salary</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${empList}" var="employee">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.job}</td>
                    <td>${employee.hiredate}</td>
                    <td>${employee.salary}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/user/edit/${employee.id} ">Edit</a><br/>
                        <a href="${pageContext.request.contextPath}/user/delete/${employee.id} ">Delete</a><br/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
</div>


</body>
</html>