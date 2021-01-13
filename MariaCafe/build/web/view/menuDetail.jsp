<%-- 
    Document   : cakeDetail
    Created on : Oct 10, 2018, 5:16:03 PM
    Author     : hoaktse05446
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About My Cakes</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/aboutcake.css" rel="stylesheet" type="text/css"/>
        <link href="css/entry.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="container">
            <%@include file="../content/header.jsp" %>
            <%@include file="../content/menu.jsp" %>

            <div class="content">
                <div class="main">
                    <div class="no-border">
                        <jsp:include page="menu.jsp"></jsp:include>
                        </div>
                    </div>
                <%@include file="../content/sidebar.jsp" %>
            </div>

            <%@include file="../content/footer.jsp" %>

        </div>
    </body>
</html>

