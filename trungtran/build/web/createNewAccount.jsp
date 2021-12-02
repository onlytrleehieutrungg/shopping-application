<%-- 
    Document   : createNewAccount
    Created on : Jun 28, 2021, 1:35:32 PM
    Author     : trung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Account</title>
    </head>
    <body>  
        <h1>Create Account</h1>
        <form action="DispatchController" method="POST">
            <c:set var="errors" value="${requestScope.INSERT_ERRORS}"/>
            Username* <input type="text" name="txtUsername" value="${param.txtUsername}" />(6-20 chars)<br/>
           <c:if test="${not empty errors.usernameLengthErr}">
               <font color ="red">
               ${errors.usernameLengthErr};
               </font><br/>
           </c:if>
                <c:if test="${not empty errors.usernameIsExisted}">
               <font color ="red">
               ${errors.usernameIsExisted};
               </font><br/>
           </c:if>
           Password* <input type="password" name="txtPassword" value="" />(6-20 chars)<br/>
            <c:if test="${not empty errors.passwordLenthErr}">
               <font color ="red">
               ${errors.passwordLenthErr};
               </font><br/>
           </c:if>
           Confirm* <input type="password" name="txtConfirm" value="" /><br/>
            <c:if test="${not empty errors.confirmNotMatch}">
               <font color ="red">
               ${errors.confirmNotMatch};
               </font><br/>
           </c:if>
               Full Name* <input type="text" name="txtFullname" value="${param.txtFullname}" />(2-50 chars)<br/>
            <c:if test="${not empty errors.fullNameLengthErr}">
               <font color ="red">
               ${errors.fullNameLengthErr};
              </font><br/>
           </c:if>
           <input type="submit" name="btAction" value="Create New Account" />
           <input type="reset" value="Reset" />
        </form>
    </body>
</html>
