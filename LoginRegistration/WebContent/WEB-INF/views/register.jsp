
 <%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Registration Page</title> 
    <style>
    .error
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>
</head>
 
<body bgcolor="#AAE6FA">
<div align="center" >
    <h2><spring:message code="lbl.page" text="Add New User" /></h2>
    <br/>
    <form:form method="post" action="add" modelAttribute="user">
        <table>
            <tr>
                <td><spring:message text="User Name" /></td>
                <td><form:input path="userName" /></td>
                <td><form:errors path="userName" cssClass="error" /></td>
            </tr>
            <tr>
               <td><spring:message text="User Password" /></td>
                <td><form:input path="userPassword" /></td>
                <td><form:errors path="userPassword" cssClass="error" /></td>
            </tr>
            <tr>
               <td><spring:message text="Conform Password" /></td>
                <td><form:input path="userConformPassword" /></td>
                <td><form:errors path="userConformPassword" cssClass="error" /></td>
            </tr>
             <tr>
                <td><spring:message text="User Email Address" /></td>
                <td><form:input path="userEmailaddress" /></td>
                <td><form:errors path="userEmailaddress" cssClass="error" /></td>
            </tr>
             <tr>
                <td><spring:message text="User  Address" /></td>
                <td><form:input path="userAddress" /></td>
                <td><form:errors path="userAddress" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message text="User Mobile" /></td>
                <td><form:input path="usermobile" /></td>
                <td><form:errors path="usermobile" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="Resister"/></td>
            </tr>
        </table>
    </form:form>
    
    <form:form method="post" action="login">
    <tr>
       <td colspan="3"><input type="submit" value="Back"/></td>
     </tr>
    </form:form>
    </div>
</body>
</html> 