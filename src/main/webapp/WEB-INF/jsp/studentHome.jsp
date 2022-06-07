<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Accueil</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
    <jsp:include page="header.jsp"/>
</head>
<body>

<div class="d-flex justify-content-center flex-nowrap">
    <div class="shadow rounded p-5 m-2 border border-secondary">
        <h1>Page pour étudiants</h1>
        <div class="d-flex justify-content-center">
            <a href="/student/search"><button class="btn btn-primary m-2">Rechercher une annonce</button></a>
        </div>
        <h2>Toutes les annonces disponibles : </h2>
        <c:forEach items="${annonces}" var="a">
        <div class="shadow rounded p-2 m-2 border border-secondary">
            <b>Titre :</b> ${a.title}<br>
            <b>Description : </b>${a.description}<br>
            <b>Localisation : </b>${a.city.name}<br>
            <b>Date : </b>${a.date}<br>
            <b>Prix : </b>${a.price}<br>
            <b>Catégories : </b><br>
            <c:forEach items="${a.categories}" var="c">
                <div class="shadow rounded p-2 m-2 border border-secondary">
                <b>Catégorie : </b>${c.name}<br>
                <b>Description : </b>${c.description}
                </div>
            </c:forEach>
        </div>
        </c:forEach>
    </div>
</div>
</div>

</body>
</html>
