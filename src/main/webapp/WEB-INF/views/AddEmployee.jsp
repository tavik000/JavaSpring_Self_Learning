<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<form action="AddEmployeeMethod" method="post" onsubmit="return check(this);">
    <table align="center" width="450">
        <tr>
            <td align="center" colspan="2">
                <h2>Add Employee</h2>
                <hr>
            </td>
        </tr>
        <tr>
            <td align="right">
                Employee ID
            </td>
            <td>
                <input type="text" name ="id"/>
            </td>
        </tr>
        <tr>
            <td align="right">
                Employee Name
            </td>
            <td>
                <input type="text" name ="name"/>
            </td>
        </tr>
        <tr>
            <td align="right">
                Job
            </td>
            <td>
                <input type="text" name ="job"/>
            </td>
        </tr>
        <tr>
            <td align="right">
                Hire date
            </td>
            <td>
                <input type="text" name ="hiredate"/>
            </td>
        </tr>
        <tr>
            <td align="right">
                Salary
            </td>
            <td>
                <input type="text" name ="salary"/>
            </td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" value="Add">
            </td>
        </tr>
    </table>
</form>

</body>
</html>