<%@ page language="java" import="com.xyz.mvc.Constants" errorPage="error.jsp" isErrorPage="true" %>
<%@ page import="com.xyz.mvc.Database" %>
<%@ page import="com.xyz.mvc.FullTimeStudent" %>
<%@ page import="com.xyz.mvc.Student" %>

<%
    ServletContext context = config.getServletContext();
    Student[] students = (Student[]) context.getAttribute("students");

    if (students == null) {
        students = new Database().selectAll(new FullTimeStudent(), Constants.FULL);
    }

    Student student = (Student) context.getAttribute("student");
    String mode = request.getParameter("mode");
    String cmd = request.getParameter("cmd");
%>

<html>
<head><title>com.xyz.mvc.Student List</title></head>
<body>

<table border="1">
    <tr bgcolor="#ccffcc">
        <td>Number</td>
        <td>Name</td>
        <td>SSN</td>
        <td>Phone</td>
        <td>Email</td>
        <td>Remove</td>
        <td>Update</td>
    </tr>
    <%
        for (int index = 0; index < students.length; index++) {
    %>
    <tr>
        <td><%= index + 1 %>
        </td>
        <td><%= students[index].getName() %>
        </td>
        <td><%= students[index].getSSN() %>
        </td>
        <td><%= students[index].getPhone() %>
        </td>
        <td><%= students[index].getEmail() %>
        </td>
        <td>
            <a href="/web-mvc/Controller?name=<%= students[index].getName()%>&ssn=<%= students[index].getSSN()%>&phone=<%= students[index].getPhone()%>&email=<%= students[index].getEmail() %>&cmd=3&mode=<%= mode%>">R</a>
        </td>
        <td>
            <a href="/web-mvc/Controller?name=<%= students[index].getName()%>&ssn=<%= students[index].getSSN()%>&phone=<%= students[index].getPhone()%>&email=<%= students[index].getEmail() %>&cmd=2&mode=<%= mode%>">U</a>
        </td>
    </tr>
    <%}%>
</table>

<form action="/web-mvc/Controller" method="get">
    <table>
        <tr>
            <td>SSN</td>
            <td><input type="Text" name="ssn"></td>
            <td>
                <select name="mode">
                    <option value="<%= Constants.FULL %>"><%= Constants.FULL %>
                    <option value="<%= Constants.PART %>"><%= Constants.PART %>
                </select>
            </td>
            <td><input type="Hidden" name="cmd" value="4"></td>
            <td><input type="submit" value="search"></td>
        </tr>
    </table>
</form>
</body>
</html>
