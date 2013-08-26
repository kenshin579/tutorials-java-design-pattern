<%@ page language="java" import="com.xyz.mvc.*" errorPage="error.jsp" isErrorPage="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
  ServletContext context = config.getServletContext();
  Student []students = (Student[])context.getAttribute(Constants.STUDENTS);
  Student student = (Student)context.getAttribute(Constants.STUDENT);
  String mode = request.getParameter("mode");
  String cmd = request.getParameter("cmd");
%>
<html>
  <head>
    <title>com.xyz.mvc.Student Regist</title>
  </head>

<body>
  <form action="/web-mvc/Controller" method="get">
  <table bgcolor="#ccffcc">
    <tr>
      <td>Name</td>
	  <td><input type="text" name="name" value="<%= student == null ? "" : student.getName() %>"></td>
    </tr>
    <tr>
      <td>SSN</td>
	  <td><input type="text" name="ssn" value="<%= student == null ? "" : student.getSSN() %>"></td>
    </tr>
    <tr>
      <td>Phone</td>
	  <td><input type="text" name="phone" value="<%= student == null ? "" : student.getPhone() %>"></td>
    </tr>
    <tr>
      <td>Email</td>
	  <td><input type="text" name="email" value="<%= student == null ? "" : student.getEmail() %>"></td>
    </tr>
    <tr>
      <td>Type</td>
      <td>
        <select name="mode">
        <%if(mode != null){
              if(mode.equals(Constants.FULL)){ %>
                <option value="<%= Constants.FULL %>"><%= Constants.FULL %>
                <option value="<%= Constants.PART %>"><%= Constants.PART %>
          <%  }else if(mode.equals(Constants.PART)){ %>
                <option value="<%= Constants.PART %>"><%= Constants.PART %>
                <option value="<%= Constants.FULL %>"><%= Constants.FULL %>
          <%  }
          }else{%>
            <option value="<%= Constants.FULL %>"><%= Constants.FULL %>
            <option value="<%= Constants.PART %>"><%= Constants.PART %>
        <%} %>
        </select>
      </td>
    </tr>
    <tr>
      <td><input type="Hidden" name="cmd" value="<%= student == null ? "1" : "5" %>"></td>
    </tr>
    <tr>
      <td><input type="submit" value="<%= student == null ? "regist" : "update" %>"></td>
      <td><input type="Reset" value="reset"></td>
    </tr>
  </table>
  </form>

  <% context.setAttribute(Constants.STUDENT,null);%>
</body>
</html>
