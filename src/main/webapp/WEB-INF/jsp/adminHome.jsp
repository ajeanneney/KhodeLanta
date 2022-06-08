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
<div class="d-flex justify-content-center flex-nowrap">
    <h1>Page pour l'admin</h1>
</div>
<div>
    <a href="/admin/listUsers">Liste des Utilisateurs</a>
</div>
<div class="d-flex justify-content-center flex-nowrap">
    <c:forEach items="${annonces}" var="a">
        <div class="shadow rounded p-5 m-2 border border-secondary">
            ${a.title}<br>
            ${a.description}<br>
            ${a.adresse}<br>
            ${a.date}<br>
            <c:forEach items="${a.categories}" var="c">
                ${c.name}<br>
                ${c.description}<br>
                <br>
            </c:forEach>
            <br><br>
        </div>
    </c:forEach>
</div>

<div class="d-flex justify-content-center flex-nowrap">
    <form action="" method="post" class="shadow rounded p-3 m-3">
        <h3>Ajouter une catégorie :</h3>

        <div class="form-group p-2">
            <label for="name">Nom de la catégorie : </label>
            <input type="text" name="name" id="name" class="form-control">
        </div>
        <div class="form-group p-2">
            <label for="description">Description de la catégorie : </label>
            <input type="text" name="description" id="description" class="form-control">
        </div>
        <div class="form-group p-2 d-flex justify-content-center">
            <button type="submit" class="btn btn-primary m-2">Ajouter la catégorie</button>
        </div>
    </form>
</div>


</body>
</html>
