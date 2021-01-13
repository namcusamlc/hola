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
        <title>Home</title>
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
                    <!--banner-->
                    <%@include file="banner.jsp" %>

                    <!--entry-->
                    <div class="entry">

                        <c:forEach items="${products}" var="p" varStatus="loop">
                            <c:choose>
                                <c:when test="${loop.index eq 0}">
                                    <%@include file="product.jsp" %>
                                    <div class="separator"></div>
                                </c:when>
                                <c:otherwise>
                                     <%@include file="product.jsp" %>
                                </c:otherwise>
                            </c:choose>

                        </c:forEach>
                    </div>

                    <div class="welcome">
                        <h2>Visit my cafe</h2>
                        <p>${info.content}</p>
                        <p>${info.address}</p>
                        <p>Phone: ${info.phone}</p>

                    </div>

                    <div class="signature">
                        <p>${info.message}</p>
                        <p>${info.author}</p>
                    </div>

                </div>

                <!--right content-->
                <%@include file="../content/sidebar.jsp" %>
            </div>

            <%@include file="../content/footer.jsp" %>
        </div>
    </body>
</html>
