<%-- 
    Document   : login
    Created on : Oct 4, 2017, 1:38:19 PM
    Author     : 679810
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sait" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="saitTags" uri="/WEB-INF/tlds/sait.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <saitTags:Debug>
            Remote Host: ${pageContext.request.remoteHost}<br> 
            Session ID: ${pageContext.session.id}
        </saitTags:Debug>
        <sait:login />
    </body>
</html>
