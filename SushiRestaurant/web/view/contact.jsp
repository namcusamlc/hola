<%-- 
    Document   : contact
    Created on : Oct 5, 2018, 4:49:07 PM
    Author     : hoaktse05446
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/contact.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="container">
            <%@include file="../content/header.jsp" %>
            <%@include file="../content/menu.jsp" %>

            <div class="content">
                <div class="main">
                    <div class="title">Find us</div>

                        <jsp:include page="contactDetail.jsp"></jsp:include>
                        
                    </div>
                <%@include file="../content/sidebar.jsp" %>
            </div>

            <%@include file="../content/footer.jsp" %>

        </div>
    </body>
</html>
