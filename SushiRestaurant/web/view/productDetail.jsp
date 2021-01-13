<%-- 
    Document   : productDetail
    Created on : Oct 12, 2018, 3:49:50 PM
    Author     : hoaktse05446
--%>

<%-- 
    Document   : home
    Created on : Oct 5, 2018, 2:51:31 PM
    Author     : hoaktse05446
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/entry.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%@include file="../content/header.jsp" %>
            <%@include file="../content/menu.jsp" %>

            <div class="content">
                <!--left content-->
                <div class="main">
                    <!--entry-->
                    <div class="no-border">
                        <%@include file="product.jsp" %>
                    </div>
                </div>

                <!--right content-->
                <%@include file="../content/sidebar.jsp" %>
            </div>

            <%@include file="../content/footer.jsp" %>
        </div>
    </body>
</html>
