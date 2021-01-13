<%-- 
    Document   : menu
    Created on : Oct 10, 2018, 4:30:09 PM
    Author     : hoaktse05446
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="cake">
    <c:choose>
        <c:when test="${detail eq 'true'}">
            <div class="title">${menu.title}</div>
            <img src="${menu.imagePath}"/>
            <p>${menu.content}</p>

            <p>Price: $${menu.price}</p>
        </c:when>
        <c:otherwise>
            <div class="title"><a href="?menuId=${menu.id}">${menu.title}</a></div>
            <img src="${menu.imagePath}"/>

            <p>${menu.shortContent}</p>
        </c:otherwise>
    </c:choose>
</div>

