<%-- 
    Document   : aboutcake
    Created on : Oct 5, 2018, 4:36:48 PM
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
    </head>
    <body>

        <div class="container">
            <%@include file="../content/header.jsp" %>
            <%@include file="../content/menu.jsp" %>

            <div class="content">
                <div class="main">
                    <c:forEach items="${list}" var="menu">

                        <%@include file="menu.jsp" %>

                    </c:forEach>

                    <div class="pagger">${paging}</div>
                </div>
                <%@include file="../content/sidebar.jsp" %>
            </div>

            <%@include file="../content/footer.jsp" %>

        </div>
    </body>
</html>
