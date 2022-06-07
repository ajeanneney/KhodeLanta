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
<div class="page2">
    <div class="filtres">
        <h2>Filtres</h2>
    </div>
    <div class="right">
        <div class="searchBar">
            <h3>Rechercher une annonce</h3>
        </div>
        <c:forEach items="${annonces}" var="a">
            <div class="annonce">
                <div class="part1">
                    <img src="/images/yvette.jpg" class="photo">
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

</div>

</body>
</html>
