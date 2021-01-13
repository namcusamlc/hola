<%-- 
    Document   : menu
    Created on : Sep 24, 2018, 11:09:39 AM
    Author     : hoaktse05446
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="home" value="${active != 'aboutme'?'active':''}"></c:set>
<c:set var="aboutme" value="${active != 'aboutme'?'':'active'}"></c:set>
<nav class="menu">
    <a href="home" class="${home}">My Blog</a>
<a href="aboutme" class="${aboutme}">About Me</a>
</nav>