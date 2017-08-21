<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/EditEmployeeMethod/?oriId=${oriId}" method="post" onsubmit="return check(this);">
    <table align="center" width="450">
        <tr>
            <td align="center" colspan="2">
                <h2>Edit Employee</h2>
                <hr>
            </td>
        </tr>
        <tr>
            <td align="right">
                Employee ID
            </td>
            <td>
                <input type="text" name ="id" value =${emp.id} />
            </td>
        </tr>
        <tr>
            <td align="right">
                Employee Name
            </td>
            <td>
                <input type="text" name ="name" value =${emp.name} />
            </td>
        </tr>
        <tr>
            <td align="right">
                Job
            </td>
            <td>
                <input type="text" name ="job" value =${emp.job} />
            </td>
        </tr>
        <tr>
            <td align="right">
                Hire date
            </td>
            <td>
                <input type="text" name ="hiredate" value =${emp.hiredate} />
            </td>
        </tr>
        <tr>
            <td align="right">
                Salary
            </td>
            <td>
                <input type="text" name ="salary" value =${emp.salary} />
            </td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" value="Save">
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/">Cancel</a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>