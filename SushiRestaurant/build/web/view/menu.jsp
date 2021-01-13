<%-- 
    Document   : menu
    Created on : Oct 17, 2018, 3:38:19 PM
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
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%@include file="../content/header.jsp" %>
            <%@include file="../content/menu.jsp" %>

            <div class="content">

                <div class="main">
                    <div class="title">Menu and Price list</div>

                    <c:forEach items="${menus}" var="menu">
                        <div class="item">
                            <div class="cover">
                                <hr>
                                <div class="col-95">
                                    <span>Menu ${menu.index}</span>
                                    <span class="right">Price</span>
                                </div>

                                <hr>
                                <div class="col-95">
                                    <span>${menu.title}</span>
                                    <span class="right">€${menu.price}</span>
                                </div>

                            </div> 

                            <div class="item-content">
                                ${menu.content}
                            </div>
                        </div>
                    </c:forEach>
                    
                    <div class="pagger">${pagingMenu}</div>

                </div>

                <%@include file="../content/sidebar.jsp" %>

            </div>


            <%@include file="../content/footer.jsp" %>
        </div>
    </body>
</html>
