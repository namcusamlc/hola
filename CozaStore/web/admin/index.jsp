<%-- 
    Document   : index
    Created on : Jul 25, 2018, 7:40:57 AM
    Author     : HoaPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
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
        <header>
            <jsp:include page="component/header.jsp"></jsp:include>
            </header>
            <section class="section-slide">
                <div class="wrap-slick1">
                    <div class="slick1">
                        <div class="item-slick1" style="background-image: url(../images/slide-01.jpg);">
                            <div class="container h-full">
                                <div class="flex-col-l-m h-full p-t-100 p-b-30 respon5">
                                    <div class="layer-slick1 animated visible-false" data-appear="fadeInDown" data-delay="0">
                                        <span class="ltext-101 cl2 respon2">
                                            Welcome to Management Website
                                        </span>
                                    </div>

                                    <div class="layer-slick1 animated visible-false" data-appear="fadeInUp" data-delay="800">
                                    </div>

                                    <div class="layer-slick1 animated visible-false" data-appear="zoomIn" data-delay="1600">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        <jsp:include page="component/footer.jsp"></jsp:include>
    </body>
</html>
