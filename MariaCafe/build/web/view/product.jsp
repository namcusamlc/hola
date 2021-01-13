<%-- 
    Document   : product
    Created on : Oct 10, 2018, 3:22:46 PM
    Author     : hoaktse05446
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:choose>
    <c:when test="${detail eq 'true'}">
        <div class="no-border">
            <div class="cake">
                <div class="title">${p.title}</div>
                <img src="${p.imagePath}"/>
                <p>
                    ${p.content}
                </p>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="product">
            <img src="${p.imagePath}"/>
            <a href="?productId=${p.id}">
                <h2>${p.title}</h2>
            </a>
            <p>
                ${p.shortContent}
            </p>
        </div>
    </c:otherwise>
</c:choose>