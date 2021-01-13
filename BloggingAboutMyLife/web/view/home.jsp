<%-- 
    Document   : home
    Created on : Sep 24, 2018, 11:10:10 AM
    Author     : hoaktse05446
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Blog</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/entry.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="container">
            <%@include file="../content/header.jsp" %>
            <%@include file="../content/menu.jsp" %>

            <div class="content">
                <div class="main">
                    <div class="title">My Blog</div>
                    <c:forEach items="${entries}" var="e">
                        <%@ include file="entry.jsp" %>
                    </c:forEach>
                    <div class="overview">
                        <a href="overview">Overview</a>
                    </div>
                </div>
                <%@include file="../content/sidebar.jsp" %>
            </div>

            <%@include file="../content/footer.jsp" %>
        </div>

    </body>
</html>
