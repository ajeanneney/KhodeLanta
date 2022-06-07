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
<h1>Résultat de votre recherche</h1>
</div>

<c:forEach items="${annonces}" var="a">
    <div class="shadow rounded p-5 m-2 border border-secondary">
            ${a.title}<br>
            ${a.description}<br>
            ${a.adresse}<br>
            ${a.date}<br>
        <c:forEach items="${a.categories}" var="c">
            ${c.name}<br>
            ${c.description}<br>
            <br>
        </c:forEach>
        <br>
    </div>
</c:forEach>

</body>
</html>


</body>
</html>
