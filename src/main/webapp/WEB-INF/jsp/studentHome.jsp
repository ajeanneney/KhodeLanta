<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Accueil</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
    <jsp:include page="header.jsp"/>
</head>
<body>

<div class="d-flex justify-content-center flex-nowrap">
    <h1>Page pour étudiants</h1>
    <a href="editProfile">Modifier mon profil</a>
    <a href="/student/search">Rechercher une annonce</a>
    <div class="shadow rounded p-5 m-2 border border-secondary">
                <c:forEach items="${annonces}" var="a">
                    ${a.title}<br>
                    ${a.description}<br>
                    ${a.city.name}<br>
                    ${a.date}<br>
                    <c:forEach items="${a.categories}" var="c">
                        ${c.name}<br>
                        ${c.description}<br>
                        <br>
                    </c:forEach>
                    <br><br>
                </c:forEach>
    </div>
</div>
</div>

</body>
</html>
