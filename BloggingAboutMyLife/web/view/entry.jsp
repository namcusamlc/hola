<%-- 
    Document   : normalEntry
    Created on : Oct 1, 2018, 11:31:44 AM
    Author     : hoaktse05446
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="${e.category.name}">
    <div class="logo">
        <img src="${e.logoPath}"/>
    </div>
    <div class="item">
        <a href="detail?id=${e.id}">${e.title}</a>
        <span>
            <f:formatDate value="${e.publishedDate}" pattern="dd-MM-yyyy"/>
        </span>

        <div class="content-item ${e.category.name == 'quote'?'right':''}">
            <c:choose>
                <c:when test="${e.getImageName() eq 'null'}">
                </c:when>
                <c:otherwise>
                    <img src="${e.imagePath}"/>
                </c:otherwise>
            </c:choose>
            <p>
                <c:choose>
                    <c:when test="${detail eq 'true'}">
                        ${e.content}
                    </c:when>
                    <c:otherwise>
                       ${e.getShortContent()}
                    </c:otherwise>
                </c:choose>
                
            </p>
        </div>
    </div>
</div>
