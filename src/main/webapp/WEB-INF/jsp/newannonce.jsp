<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Connexion</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
    <jsp:include page="header.jsp"/>
</head>
<body>


<div class="page">
<div class="create_annonce">
    <form action="/newannonce" method="post">
        <h1>Créer une annonce</h1>
        <div class="item">
            <label for="title">Titre de l'annonce</label>
            <input type="text" name="title" id="title" required>
        </div>
        <div class="item">
            <label for="description">Besoin</label>
            <textarea name="description" id="description" placeholder="Description de votre annonce" required></textarea>
        </div>
        <div class="item">
            <label for="adresse">Adresse</label>
            <input type="text" name="adresse" id="adresse" required>
        </div>
        <div class="item">
            <label for="prix">Prix</label>
            <input type="text" name="prix" id="prix" required>
        </div>

        <c:forEach items="${categories}" var="c">
        <div>
            <input class="form-check-input" type="checkbox" name="categories" value="${c.id}">
            <label>${c.name} : ${c.description}</label><br>
            </div>
        </c:forEach>

        <div class="form-group p-2 d-flex justify-content-center">
            <button type="submit" >Envoyer</button>
        </div>
    </form>
</div>
</div>

</body>
</html>
