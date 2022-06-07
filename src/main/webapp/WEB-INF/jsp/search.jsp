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
    <form action="/student/search/result" method="get" class="shadow rounded p-3 m-3">
        <h1>Recherche avancée d'annonces</h1>
        <div class="form-group p-2">
            <label for="title">Titre de la demande recherchée</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="Titre de la demande">
        </div>
        <div class="form-group p-2">
        <select name="city" id="city" class="form-select">
            <option value="" selected disabled>Choisisez une ville</option>
            <c:forEach items="${cities}" var="c">
                <option value="${c}">${c.name}</option>
            </c:forEach>
        </select>
        </div>
        <div class="form-group p-2">
            <label for="date">Date : </label><input type="date" name="date" id="date" class="form-control">
        </div>
        <div class="form-group p-2">
            <c:forEach items="${categories}" var="c">
                <input class="form-check-input" type="checkbox" name="categories" value="${c.id}">
                <label>${c.name} : ${c.description}</label><br>
            </c:forEach>
        </div>
        <div class="form-group p-2 d-flex justify-content-center">
            <button type="submit" class="btn btn-primary m-2">Rechercher</button>
        </div>
    </form>
</div>

</body>
</html>


</body>
</html>
