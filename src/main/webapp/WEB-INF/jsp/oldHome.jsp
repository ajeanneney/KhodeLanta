<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Connexion</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css" />
    <jsp:include page="header.jsp"/>
</head>
<body>
<h1>Home</h1>
<a href="/old/newannonce">nouvelle annonce</a>
<div class="d-flex justify-content-around">

    <div class="shadow rounded p-5 m-2 border border-secondary">
        Prenom : ${user.firstname}<br>
        Nom : ${user.lastname}<br>
        Mail : ${user.mail}<br>
    </div>

</div>

<div class="d-flex justify-content-around">
    <div class="p-5 m-2">
        Mes annonces
    </div>
    <form action="/old/deleteannonce" method="post" class=" rounded p-3 m-3">
        <c:forEach items="${annoncesByOwner}" var="a">
            <div class="shadow rounded p-5 m-2 border border-secondary">
                    ${a.title}<br>
                    ${a.description}<br>
                    ${a.price}€<br>
                    ${a.adresse}<br>
                    ${a.date}<br>
                <c:forEach items="${a.categories}" var="c">
                    ${c.name}<br>
                    ${c.description}<br>
                    <br>
                </c:forEach>
                <button type="submit" name="id" id="id" value="${a.id}" class="btn btn-primary m-2">Supprimer l'annonce</button>
                <br><br>
            </div>
        </c:forEach>
    </form>
</div>

<div class="d-flex justify-content-around">
    <div class="p-5 m-2">
        Aujourd'hui :
    </div>
    <form action="/old/deleteannonce" method="post" class=" rounded p-3 m-3">
        <c:forEach items="${annoncesByOwnerAndDate}" var="a">
            <div class="shadow rounded p-5 m-2 border border-secondary">
                    ${a.title}<br>
                    ${a.description}<br>
                    ${a.price}€<br>
                    ${a.adresse}<br>
                    ${a.date}<br>
                <c:forEach items="${a.categories}" var="c">
                    ${c.name}<br>
                    ${c.description}<br>
                    <br>
                </c:forEach>
                <button type="submit" name="id" id="id" value="${a.id}" class="btn btn-primary m-2">Supprimer l'annonce</button>
                <br><br>
            </div>
        </c:forEach>
    </form>
</div>

</body>
</html>
