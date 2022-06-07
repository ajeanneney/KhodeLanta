<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Rechercher une annonce</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css" />
    <jsp:include page="header.jsp"/>
</head>

<body>
<div class="d-flex justify-content-center flex-nowrap">
<h1>Résultat de votre recherche</h1>
</div>

<div class="d-flex justify-content-center flex-nowrap">
    <div class="shadow rounded p-5 m-2 border border-secondary">
    <c:choose>
    <c:when test="${annonces.size() == 0}">
        <h2>Il n'y a aucune annonce correspondant à vos critères !</h2>
    </c:when>
    </c:choose>
    <c:forEach items="${annonces}" var="a">
        <div class="shadow rounded p-2 m-2 border border-secondary">
            <b>Titre :</b> ${a.title}<br>
            <b>Description : </b>${a.description}<br>
            <b>Localisation : </b>${a.city.name}<br>
            <b>Date : </b>${a.date}<br>
            <b>Prix : </b>${a.price} €<br>
            <b>Catégories : </b><br>
            <c:forEach items="${a.categories}" var="c">
                <div class="shadow rounded p-2 m-2 border border-secondary">
                    <b>Catégorie : </b>${c.name}<br>
                    <b>Description : </b>${c.description}
                </div>
            </c:forEach>
        </div>
    </c:forEach>
        <div class="d-flex justify-content-center">
        <a href="/student/search"><button class="btn btn-secondary m-2">Retour à la recherche</button></a>
        </div>
    </div>
</div>

</body>
</html>


</body>
</html>
