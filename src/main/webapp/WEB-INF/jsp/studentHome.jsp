<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Annonces</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css" />
    <jsp:include page="header.jsp"/>
</head>

<body>
<div class="page2">
    <div class="filtres">
        <h2>Filtres</h2>
        <%--<form action="/student/search/result" method="get" class="shadow rounded p-3 m-3">
            <h1>Recherche avancée d'annonces</h1>
            <div class="form-group p-2">
                <label for="title">Titre de la demande</label>
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
            <div class="form-group p-2 d-flex justify-content-center">
                <button type="submit" class="btn btn-primary m-2">Rechercher</button>
            </div>
        </form>--%>
    </div>
    <div class="right">
        <div class="searchBar">
            <h3>Rechercher une annonce</h3>
        </div>
        <c:forEach items="${annonces}" var="a">
            <div class="annonce">
                <div class="part1">
                    <div>
                        <h3>Yvette</h3>
                        <h3>85 ans</h3>
                        <h3>${a.city.name}</h3>
                    </div>
                </div>
                <div class="part2">
                    <div>
                        <h3>Besoin</h3>
                        <p>${a.description}</p>
                    </div>
                    <div class="horizontal_alignment">
                        <div>
                            <h3>Disponibilités</h3>
                            <p>Tous les jours entre 10h et 18h.</p>
                        </div>
                        <div>
                            <h3>Prix</h3>
                            <p>20€</p>
                        </div>
                    </div>
                    <div>
                        <button>Candidater</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>