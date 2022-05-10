<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Connexion</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css" />
    <jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<h1>Home</h1>
<a href="disconnect">Deconnexion</a>
<br><br>

<div class="d-flex justify-content-around">

    <div class="shadow rounded p-5 m-2 border border-secondary">
        Prenom : ${user.firstname}<br>
        Nom : ${user.lastname}<br>
        Mail : ${user.mail}<br>
    </div>

    <div class="shadow rounded p-5 m-2 border border-secondary">
    Maisons : <br>
    <table class="table">
        <tr>
            <th>title</th>
            <th>description</th>
        </tr>
        <c:forEach items="${houses}" var="t">
            <tr>
                <td>${t.title}</td>
                <td>${t.description}</td>
            </tr>
        </c:forEach>
    </table>
    </div>

    <div class="shadow rounded p-5 m-2 border border-secondary">
    Reservations : <br>
    <table class="table">
        <tr>
            <th>maison</th>
            <th>date debut</th>
            <th>date fin</th>
            <th>validée?</th>
        </tr>
        <c:forEach items="${reservations}" var="r">
            <tr>
                <td>${r.house.getDescription()}</td>
                <td>${r.startDate}</td>
                <td>${r.endDate}</td>
                <td>${r.validated}</td>
            </tr>
        </c:forEach>
    </table>
    </div>

</div>

</body>
</html>
