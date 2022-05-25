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

<%--<ul>--%>
<%--    <li><a href="#">Khode Lanta</a></li>--%>
<%--    <c:choose>--%>
<%--        <c:when test="${cookie['userId'] == null || cookie['userId'] == ''}">--%>
<%--            <li style="float:right"><a href="#logIn">Log In / Sign Up</a></li>--%>
<%--        </c:when>--%>
<%--        <c:otherwise>--%>
<%--            <li style="float:right"><a href="/disconnect">Disconnect</a></li>--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>
<%--</ul>--%>

<nav class="navbar bg-secondary">
    <div class="container-fluid">
        <span class="navbar-brand mb-0 h1 text-light">Khode Lanta</span>
        <c:choose>
            <c:when test="${sessionScope.userId == null}">
                <span class="navbar-brand mb-0 h1 text-light"><a href="/signup">Connexion/Inscription</a></span>
            </c:when>
            <c:otherwise>
            <span class="navbar-brand mb-0 h1 text-light"><a href="/disconnect">Se déconnecter</a><span>
            </c:otherwise>
        </c:choose>
    </div>
</nav>

</html>

