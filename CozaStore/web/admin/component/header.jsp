<%-- 
    Document   : header
    Created on : Jul 17, 2018, 10:22:55 AM
    Author     : HoaPC
--%>

<%@page import="model.Item"%>
<%@page import="java.util.Map"%>
<%@page import="model.Cart"%>
<%@page import="model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String username = null;
            Cookie[] cookies = request.getCookies();
            for (Cookie cooky : cookies) {
                if (cooky.getName().equals("admin")) {
                    username = cooky.getValue();
                }
            }
        %>

        <header>
            <div class="container-menu-desktop">
                <div class="wrap-menu-desktop">
                    <nav class="limiter-menu-desktop container">

                        <!-- Logo desktop -->		
                        <a href="#" class="logo">
                            <img src="../images/icons/logo-01.png" alt="IMG-LOGO">
                        </a>

                        <!-- Menu desktop -->
                        <div class="menu-desktop">
                            <ul class="main-menu">
                                <li>
                                    <a href="index.jsp">Home</a>
                                </li>

                                <li>
                                    <a href="#">Manage product</a>
                                </li>

                                <li>
                                    <a href="invoice">Manage invoice</a>
                                </li>
                                
                                <li>
                                    <a href="<%=(username == null) || (username == "") ? "login" : "logout"%>"><%=(username == null) || (username == "") ? "Login" : "Logout"%></a>
                                </li>

                            </ul>
                        </div>	

                    </nav>
                </div>	
            </div>

            <!-- Header Mobile -->
            <div class="wrap-header-mobile">
                <!-- Logo moblie -->		
                <div class="logo-mobile">
                    <a href="home"><img src="../images/icons/logo-01.png" alt="IMG-LOGO"></a>
                </div>

                <!-- Icon header -->
                <div class="wrap-icon-header flex-w flex-r-m m-r-15">
                    <div class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 js-show-modal-search">
                        <i class="zmdi zmdi-search"></i>
                    </div>

                    <div class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10 icon-header-noti js-show-cart" data-notify="0">
                        <i class="zmdi zmdi-shopping-cart"></i>
                    </div>

                    <a href="#" class="dis-block icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10 icon-header-noti">
                        <i class="zmdi zmdi-favorite-outline"></i>
                    </a>

                </div>

                <!-- Button show menu -->
                <div class="btn-show-menu-mobile hamburger hamburger--squeeze">
                    <span class="hamburger-box">
                        <span class="hamburger-inner"></span>
                    </span>
                </div>
            </div>
            <!-- Menu Mobile -->
            <div class="menu-mobile">
                <ul class="main-menu-m">
                    <li>
                        <a href="home">Home</a>

                        <span class="arrow-main-menu-m">
                            <i class="fa fa-angle-right" aria-hidden="true"></i>
                        </span>
                    </li>

                    <li>
                        <a href="/view">View Invoices</a>
                    </li>
                </ul>
            </div>

            <!-- Modal Search -->
            <div class="modal-search-header flex-c-m trans-04 js-hide-modal-search">
                <div class="container-search-header">
                    <button class="flex-c-m btn-hide-modal-search trans-04 js-hide-modal-search">
                        <img src="../images/icons/icon-close2.png" alt="CLOSE">
                    </button>

                    <form class="wrap-search-header flex-w p-l-15">
                        <button class="flex-c-m trans-04">
                            <i class="zmdi zmdi-search"></i>
                        </button>
                        <input class="plh3" type="text" name="search" placeholder="Search...">
                    </form>
                </div>
            </div>
        </header>

        <!-- Sidebar -->
        <aside class="wrap-sidebar js-sidebar">
            <div class="s-full js-hide-sidebar"></div>

            <div class="sidebar flex-col-l p-t-22 p-b-25">
                <div class="flex-r w-full p-b-30 p-r-27">
                    <div class="fs-35 lh-10 cl2 p-lr-5 pointer hov-cl1 trans-04 js-hide-sidebar">
                        <i class="zmdi zmdi-close"></i>
                    </div>
                </div>

                <div class="sidebar-content flex-w w-full p-lr-65 js-pscroll">
                    <ul class="sidebar-link w-full">
                        <li class="p-b-13">
                            <a href="#" class="stext-102 cl2 hov-cl1 trans-04">
                                Help & FAQs
                            </a>
                        </li>
                    </ul>

                    <div class="sidebar-gallery w-full p-tb-30">
                        <span class="mtext-101 cl5">
                            @ CozaStore
                        </span>

                        <div class="flex-w flex-sb p-t-36 gallery-lb">
                            <!-- item gallery sidebar -->
                            <div class="wrap-item-gallery m-b-10">
                                <a class="item-gallery bg-img1" href="../images/gallery-01.jpg" data-lightbox="gallery" 
                                   style="background-image: url('images/gallery-01.jpg');"></a>
                            </div>

                            <!-- item gallery sidebar -->
                            <div class="wrap-item-gallery m-b-10">
                                <a class="item-gallery bg-img1" href="../images/gallery-02.jpg" data-lightbox="gallery" 
                                   style="background-image: url('images/gallery-02.jpg');"></a>
                            </div>

                            <!-- item gallery sidebar -->
                            <div class="wrap-item-gallery m-b-10">
                                <a class="item-gallery bg-img1" href="../images/gallery-03.jpg" data-lightbox="gallery" 
                                   style="background-image: url('images/gallery-03.jpg');"></a>
                            </div>

                            <!-- item gallery sidebar -->
                            <div class="wrap-item-gallery m-b-10">
                                <a class="item-gallery bg-img1" href="../images/gallery-04.jpg" data-lightbox="gallery" 
                                   style="background-image: url('images/gallery-04.jpg');"></a>
                            </div>

                            <!-- item gallery sidebar -->
                            <div class="wrap-item-gallery m-b-10">
                                <a class="item-gallery bg-img1" href="../images/gallery-05.jpg" data-lightbox="gallery" 
                                   style="background-image: url('images/gallery-05.jpg');"></a>
                            </div>

                            <!-- item gallery sidebar -->
                            <div class="wrap-item-gallery m-b-10">
                                <a class="item-gallery bg-img1" href="../images/gallery-06.jpg" data-lightbox="gallery" 
                                   style="background-image: url('images/gallery-06.jpg');"></a>
                            </div>

                            <!-- item gallery sidebar -->
                            <div class="wrap-item-gallery m-b-10">
                                <a class="item-gallery bg-img1" href="../images/gallery-07.jpg" data-lightbox="gallery" 
                                   style="background-image: url('images/gallery-07.jpg');"></a>
                            </div>

                            <!-- item gallery sidebar -->
                            <div class="wrap-item-gallery m-b-10">
                                <a class="item-gallery bg-img1" href="../images/gallery-08.jpg" data-lightbox="gallery" 
                                   style="background-image: url('images/gallery-08.jpg');"></a>
                            </div>

                            <!-- item gallery sidebar -->
                            <div class="wrap-item-gallery m-b-10">
                                <a class="item-gallery bg-img1" href="../images/gallery-09.jpg" data-lightbox="gallery" 
                                   style="background-image: url('images/gallery-09.jpg');"></a>
                            </div>
                        </div>
                    </div>

                    <div class="sidebar-gallery w-full">
                        <span class="mtext-101 cl5">
                            About Us
                        </span>

                        <p class="stext-108 cl6 p-t-27">
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur maximus vulputate hendrerit. Praesent faucibus erat vitae rutrum gravida. Vestibulum tempus mi enim, in molestie sem fermentum quis. 
                        </p>
                    </div>
                </div>
            </div>
        </aside>
    </body>
</html>
