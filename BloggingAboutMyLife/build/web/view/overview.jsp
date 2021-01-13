.
<%-- 
    Document   : overview
    Created on : Sep 21, 2018, 11:54:09 AM
    Author     : hoaktse05446
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Overview Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/overview.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="container">
            <%@include file="../content/header.jsp" %>
            <%@include file="../content/menu.jsp" %>

            <div class="content">
                <div class="main">
                    <div class="title">Overview-My Blog</div>
                    <div class="item-overview">

                        <c:forEach items="${map}" var="entries">
                            <div class="date">
                                <hr>
                                <span>${entries.key}</span>
                                <span class="date-right">Date</span>
                            </div> 
                            <c:forEach items="${entries.value}" var="e">
                                <div class="date">
                                    <hr>
                                    <a href="detail?id=${e.id}">${e.title}</a>
                                    <span class="date-right">
                                        <f:formatDate value="${e.publishedDate}" pattern="dd-MM-yyyy"/>
                                    </span>
                                </div>
                            </c:forEach>
                            <div class="separator"></div>
                        </c:forEach>
                        <div class="pagger">${paging}</div>
                    </div>
                </div>
                <%@include file="../content/sidebar.jsp" %>
            </div>

            <%@include file="../content/footer.jsp" %>

        </div>
    </body>
</html>
