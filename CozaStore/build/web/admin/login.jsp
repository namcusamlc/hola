<%-- 
    Document   : login
    Created on : Jul 25, 2018, 7:29:43 AM
    Author     : HoaPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
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
    </head>
    <body>
         <header class="header-v4">
            <jsp:include page="component/header.jsp"></jsp:include>
            </header>

            <div class="container" style="margin-left: 100px;">
                <div class="account">
                    <h2 class="account-in">Login</h2>
                    <div style="color: red;">
                    ${requestScope.message == null ? '': requestScope.message }
                </div>
                <form action="login" method="POST">
                    <div class="form-group">
                        <label for="username">Username:</label>
                        <input type="text" class="form-control" id="text" placeholder="Enter username" name="username">
                    </div>
                    <div class="form-group">
                        <label for="pwd">Password:</label>
                        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
                    </div>

                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
        </div>

        <jsp:include page="component/footer.jsp"></jsp:include>
    </body>
</html>
