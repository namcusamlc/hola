<%-- 
    Document   : banner
    Created on : Oct 10, 2018, 3:31:14 PM
    Author     : hoaktse05446
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="banner">
    <img src="${intro.imagePath}"/>
    <div class="banner-content">
        <h2>${intro.title}</h2>
        <p>
            ${intro.content}
        </p>
    </div>
</div>
