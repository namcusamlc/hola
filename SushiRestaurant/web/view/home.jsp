<%-- 
    Document   : home
    Created on : Oct 17, 2018, 11:22:01 AM
    Author     : hoaktse05446
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/entry.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%@include file="../content/header.jsp" %>
            <%@include file="../content/menu.jsp" %>

            <div class="content">

                <div class="main">
                    <%@include file="../content/banner.jsp" %>

                    <c:forEach items="${products}" var="product">
                        <%@include file="product.jsp" %>
                    </c:forEach>
                    
                    <div class="pagger">${pagingProduct}</div>
                </div>

                <%@include file="../content/sidebar.jsp" %>

            </div>


            <%@include file="../content/footer.jsp" %>
        </div>
    </body>
</html>
