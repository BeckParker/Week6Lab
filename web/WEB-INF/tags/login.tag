<%-- 
    Document   : loginTag
    Created on : Oct 16, 2017, 8:13:55 AM
    Author     : 679810
--%>

<%@tag description="tag to log in" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="loginBox"%>

<%-- any content can be specified here e.g.: --%>
<h1>Remember Me Login Page</h1>
<div>
    <form action="login" method="POST">
        Username: <input type="text" name="username" value="${username}"><br>
        Password: <input type="password" name="password"><br>
        <input type="checkbox" name="rememberme" ${isChecked} > Remember me<br>
        <input type="submit" value="Login">
    </form>
</div>
${errorMessage}
${success}