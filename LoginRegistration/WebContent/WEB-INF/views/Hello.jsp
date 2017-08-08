<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#AAE6FA"> 
 <h1><marquee>Hello ${msg}</marquee></h1>
 <div align="center">
 <form:form method="post" action="logout">
 <tr>
 <td colspan="3"><input type="submit" value="Logout"/></td>
 </tr>
 </form:form>
 </div>
<!-- <a href="logout">logout</a> -->
</body>
</html>