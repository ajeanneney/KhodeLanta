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
<div class="page">
<div class="admin">
    <h1>Annonces à vérifier</h1>
    <c:forEach items="${annonces}" var="a">
        <div class="validate_annonce">
            ${a.title}<br>
            ${a.description}<br>
            ${a.adresse}<br>
            <c:forEach items="${a.categories}" var="c">
                ${c.name}<br>
                ${c.description}<br>
                <br>
            </c:forEach>
            <button type="submit" class="btn btn-primary m-2">Valider</button>
             <button type="submit" class="btn btn-primary m-2">Refuser</button>
        </div>
    </c:forEach>
</div>

<div class="d-flex justify-content-center flex-nowrap">
    <form action="" method="post">
        <h3>Ajouter une catégorie</h3>

        <div class="item">
            <label for="name">Nom de la catégorie : </label>
            <input type="text" name="name" id="name" class="form-control">
        </div>
        <div class="item">
            <label for="description">Description de la catégorie : </label>
            <input type="text" name="description" id="description" class="form-control">
        </div>
            <button type="submit" class="btn btn-primary m-2">Ajouter la catégorie</button>
    </form>
</div>
</div>

</body>
</html>
