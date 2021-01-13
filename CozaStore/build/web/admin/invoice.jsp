<%-- 
    Document   : invoice
    Created on : Jul 25, 2018, 11:30:45 AM
    Author     : HoaPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Invoice</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="icon" type="image/png" href="../images/icons/favicon.png"/>
        <link rel="stylesheet" type="text/css" href="../vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="../fonts/iconic/css/material-design-iconic-font.min.css">
        <link rel="stylesheet" type="text/css" href="../fonts/linearicons-v1.0.0/icon-font.min.css">
        <link rel="stylesheet" type="text/css" href="../vendor/animate/animate.css">
        <link rel="stylesheet" type="text/css" href="../vendor/css-hamburgers/hamburgers.min.css">
        <link rel="stylesheet" type="text/css" href="../vendor/animsition/css/animsition.min.css">
        <link rel="stylesheet" type="text/css" href="../vendor/select2/select2.min.css">
        <link rel="stylesheet" type="text/css" href="../vendor/daterangepicker/daterangepicker.css">
        <link rel="stylesheet" type="text/css" href="../vendor/slick/slick.css">
        <link rel="stylesheet" type="text/css" href="../vendor/MagnificPopup/magnific-popup.css">
        <link rel="stylesheet" type="text/css" href="../vendor/perfect-scrollbar/perfect-scrollbar.css">
        <link rel="stylesheet" type="text/css" href="../css/util.css">
        <link rel="stylesheet" type="text/css" href="../css/main.css">
        <link rel="stylesheet" type="text/css" href="../css/account.css">
        <style>
            #invoices {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            #invoices td, #invoices th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            #invoices tr:nth-child(even){background-color: #f2f2f2;}

            #invoices tr:hover {background-color: #ddd;}

            #invoices th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: 	#808080;
                color: white;
            }
        </style>
    </head>
    <body>
        <header class="header-v4">
            <jsp:include page="component/header.jsp"></jsp:include>
            </header>
            <div style="margin: 50px 100px 100px 100px; ">
                <table id="invoices">
                    <tr>
                        <th>ID</th>
                        <th>Customer</th>
                        <th>Date</th>
                        <th>Payment method</th>
                        <th>Address</th>
                        <th>Total</th>
                    </tr>

                <c:forEach items="${requestScope.bills}" var="bill">
                    <tr>
                        <td><c:out value="${bill.id}"></c:out></td>
                        <td><c:out value="${bill.customerID}"></c:out></td>
                        <td><c:out value="${bill.date}"></c:out></td>
                        <td><c:out value="${bill.payment}"></c:out></td>
                        <td><c:out value="${bill.address}"></c:out></td>
                        <td><c:out value="${bill.total}"></c:out></td>

                        </tr>
                </c:forEach>
            </table>
        </div>
        <jsp:include page="component/footer.jsp"></jsp:include>
    </body>
</html>
