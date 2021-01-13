<%-- 
    Document   : form
    Created on : Jul 17, 2018, 9:46:51 AM
    Author     : HoaPC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>

            function getProduct(type) {
                window.location.href = "product?categoryID=" + type;
            }

        </script>
    </head>
    <body>

        <div class="flex-w flex-sb-m p-b-52">
            <div class="flex-w flex-l-m filter-tope-group m-tb-10">
                <button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5
                        ${requestScope.selectedCategoryID == -1 ? 'how-active1':''}" 
                        data-filter="*" onclick="getProduct(-1)">
                    All Products 
                </button>
                <c:forEach items="${requestScope.categories}" var="category">
                    <button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5 
                            ${category.id == requestScope.selectedCategoryID ? 'how-active1':''}" 
                            data-filter=".${category.name.toLowerCase()}" onclick="getProduct(${category.id})">
                        <c:out value="${category.name}"></c:out>
                        </button>
                </c:forEach>
            </div>

            <div class="flex-w flex-c-m m-tb-10">
                <div class="flex-c-m stext-106 cl6 size-105 bor4 pointer hov-btn3 trans-04 m-tb-4 js-show-search">
                    <i class="icon-search cl2 m-r-6 fs-15 trans-04 zmdi zmdi-search"></i>
                    <i class="icon-close-search cl2 m-r-6 fs-15 trans-04 zmdi zmdi-close dis-none"></i>
                    Search
                </div>
            </div>

            <script>
                function search() {
                    document.getElementById('search').submit();
                }
            </script>
            <!-- Search product -->
            <div class="dis-none panel-search w-full p-t-10 p-b-15">
                <div class="bor8 dis-flex p-l-15">
                    <button class="size-113 flex-c-m fs-16 cl2 hov-cl1 trans-04" onclick="search()">
                        <i class="zmdi zmdi-search"></i>
                    </button>
                    <form action="product" id="search">
                        <input class="mtext-107 cl2 size-114 plh2 p-r-15" type="text" name="searchProduct" placeholder="Search">
                    </form>
                </div>	
            </div>
        </div>
    </body>
</html>
