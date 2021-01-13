<%-- 
    Document   : menu
    Created on : Sep 24, 2018, 11:09:39 AM
    Author     : hoaktse05446
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="home" value="${active == 'home'?'active':''}"></c:set>
<c:set var="menu" value="${active == 'menu'?'active':''}"></c:set>
<c:set var="contact" value="${active == 'contact'?'active':''}"></c:set>
<nav class="menu">
    <a href="home" class="${home}">Home</a>
    <a href="menu" class="${menu}">Menu and Price list</a>
    <a href="contact" class="${contact}">Find us</a>
</nav>