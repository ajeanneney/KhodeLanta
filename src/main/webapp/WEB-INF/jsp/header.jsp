<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Host Dog</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css"/>
</head>

<<<<<<< Updated upstream
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
=======
<nav class="menu">
    <a href="/"><h2>Khode Lanta</h2></a>
    <c:choose>
        <c:when test="${sessionScope.userId == null}">
            <a href="/signup"><h2>Connexion/Inscription</h2></a>
        </c:when>
        <c:when test="${sessionScope.userType == STUDENT}">
            <a href="/"><h2>Accueil</h2></a>
            <a href="/student/search"><h2>Annonces</h2></a>
            <a href="/old/profile"><h2>Profil</h2></a>
            <a href="/disconnect"><h2>Se déconnecter</h2></a>
        </c:when>
        <c:otherwise>
            <a href="/"><h2>Accueil</h2></a>
            <a href="/old/newannonce"><h2>Publier une annonce</h2></a>
            <a href="/old/profile"><h2>Profil</h2></a>
            <a href="/disconnect"><h2>Se déconnecter</h2></a>
        </c:otherwise>
    </c:choose>
>>>>>>> Stashed changes
</nav>

</html>

