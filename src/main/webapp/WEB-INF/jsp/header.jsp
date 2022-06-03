<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Host Dog</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
</head>

<nav class="header">
    <div class="menu">
        <a href="/"><h2>Khode Lanta</h2></a>
        <c:choose>
            <c:when test="${sessionScope.userId == null}">
            </c:when>
            <c:otherwise>
                <a href="/"><h2>Accueil</h2></a>
                <a href="/newannonce"><h2>Publier une annonce</h2></a>
                <a href="/disconnect"><h2>Profil</h2></a>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${sessionScope.userId == null}">
                <a href="/signup"><h2>Connexion/Inscription</h2></a>
            </c:when>
            <c:otherwise>
            <a href="/disconnect"><h2>Se déconnecter</h2></a>
            </c:otherwise>
        </c:choose>
    </div>
</nav>

</html>

