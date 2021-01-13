<%-- 
    Document   : aboutme
    Created on : Sep 21, 2018, 11:36:33 AM
    Author     : hoaktse05446
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About Me</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/aboutMe.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="container">
            <%@include file="../content/header.jsp" %>
            <%@include file="../content/menu.jsp" %>

            <div class="content">
                <div class="main">
                    <div class="title">${info.title}</div>
                    <div class="aboutme">
                        <p>
                            ${info.content}
                        </p>
                    </div>
                    <div class="signature">
                        <div>${info.messages}</div>
                        <div class="name">${info.author}</div>
                    </div>


                </div>
                <%@include file="../content/sidebar.jsp" %>
            </div>

            <%@include file="../content/footer.jsp" %>

        </div>
    </body>
</html>
