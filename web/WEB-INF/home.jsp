<%-- 
    Document   : home
    Created on : Oct 7, 2017, 5:37:59 PM
    Author     : 679810
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sait" uri="/WEB-INF/tlds/sait.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <sait:Debug>
            Remote Host: ${pageContext.request.remoteHost}<br> 
            Session ID: ${pageContext.session.id}
        </sait:Debug>
        <h1>Hello there ${user.username}</h1>
        <a href="login?action=logout">Log out</a>
    </body>
</html>
