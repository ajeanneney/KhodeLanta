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

<a href="/">Retour home</a>

<div class="d-flex justify-content-center flex-nowrap">
        <form action="" method="post" class="shadow rounded p-3 m-3">
        <h1>Créer une annonce</h1>
        <div class="form-group p-2">
            <label for="title">Titre de l'annonce</label><input type="text" name="title" id="title" class="form-control" required>
        </div>
        <div class="form-group p-2">
            <label for="description">Description de l'annonce</label><textarea name="description" id="description" placeholder="Description de votre annonce" class="form-control" required></textarea>
        </div>
        <div class="form-group p-2">
            <label for="date"> Date de l'annonce</label><input type="date" name="date" id="date"  class="form-control" required>
        </div>
        <div class="form-group p-2">
            <label for="adresse">Adresse</label><input type="text" name="adresse" id="adresse" class="form-control" required>
        </div>
            <c:forEach items="${categories}" var="c">
                <input class="form-check-input" type="checkbox" name="categories" value="${c.id}">
                <label>${c.name} : ${c.description}</label><br>
            </c:forEach>
        <div class="form-group p-2 d-flex justify-content-center">
            <button type="submit" class="btn btn-primary m-2">Publier</button>
        </div>
    </form>
</div>

</body>
</html>
