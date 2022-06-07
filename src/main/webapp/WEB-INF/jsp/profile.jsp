<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Profil</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
    <jsp:include page="header.jsp"/>
</head>
<body>
<div class="page">
<h1>Mon profil</h1>
    <div class="profile">
        <h3>Prénom</h3>
        ${user.firstname}<br>
        <h3>Nom</h3>
        ${user.lastname}<br>
        <h3>Mail</h3>
        ${user.mail}<br>
    </div>
</div>

</body>
</html>
