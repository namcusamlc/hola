<%-- 
    Document   : product
    Created on : Oct 19, 2018, 11:32:24 AM
    Author     : hoaktse05446
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="product">
    <c:choose>
        <c:when test="${detail eq 'true'}">
            <h2>${product.title}</h2>
        </c:when>
        <c:otherwise>
            <a href="?id=${product.id}"><h2>${product.title}</h2></a>
        </c:otherwise>
    </c:choose>
    <div class="entry">
        <img src="${product.imagePath}"/>
        <div class="entry-content">
            <c:choose>
                <c:when test="${detail eq 'true'}">
                    <p>${product.content}</p>
                </c:when>
                <c:otherwise>
                    <p>${product.shortContent}</p>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
