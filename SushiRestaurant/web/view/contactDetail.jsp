<%-- 
    Document   : contactDetail
    Created on : Oct 15, 2018, 3:31:36 PM
    Author     : hoaktse05446
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="contact">
    <div class="item-contact">
        <h3>Address and Contact:</h3>
        <div class="space">
            <p>${contact.name}</p>
            <p>${contact.address}</p>
        </div>
        <p>Tel: ${contact.tel}</p>
        <p>Email: ${contact.email}</p>
    </div>

    <div class="item-contact">
        <h3>Opening hours:</h3>
        <p>${contact.workingHour}</p>
    </div>
</div>

<div class="map">
    <img src="${contact.mapPath}"/>
</div>