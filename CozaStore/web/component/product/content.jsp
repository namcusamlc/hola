<%-- 
    Document   : content
    Created on : Jul 23, 2018, 8:33:33 PM
    Author     : HoaPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Content</title>
    </head>
    <body>
        <div class="row isotope-grid">
            <c:forEach items="${requestScope.products}" var="product">
                <div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
                    <!-- Block2 -->
                    <div class="block2">
                        <div class="block2-pic hov-img0">
                            <img src="${product.url}" alt="IMG-PRODUCT">
                        </div>

                        <div class="block2-txt flex-w flex-t p-t-14">
                            <div class="block2-txt-child1 flex-col-l ">
                                <a href="productdetail?productID=${product.id}" class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                    <c:out value="${product.name}"></c:out>
                                    </a>

                                    <span class="stext-105 cl3">
                                    <c:out value="$${product.price}"></c:out>
                                    </span>
                                </div>

                                <div class="block2-txt-child2 flex-r p-t-3">
                                    <a href="#" class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                        <img class="icon-heart1 dis-block trans-04" src="images/icons/icon-heart-01.png" alt="ICON">
                                        <img class="icon-heart2 dis-block trans-04 ab-t-l" src="images/icons/icon-heart-02.png" alt="ICON">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
            </c:forEach>
        </div>


    </body>
</html>
