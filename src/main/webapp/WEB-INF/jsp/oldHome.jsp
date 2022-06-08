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
<div class="page">
    <a href="/old/newannonce"><h1>Nouvelle annonce</h1></a>
    <div class="annonce_list">
        <c:forEach items="${annonces}" var="a">
            <div class="annonce">
                <div class="vertical_alignment">
                    <div>
                        <h3>Titre de l'annonce</h3>
                            ${a.title}<br>
                    </div>
                    <div>
                        <h3>Adresse</h3>
                            ${a.adresse}<br>
                    </div>
                </div>
                <div>
                    <h3>Besoin</h3>
                        ${a.description}<br>
                </div>

                <div>
                    <h3>Catégorie</h3>
                    <c:forEach items="${a.categories}" var="c">
                        ${c.name}<br>
                        ${c.description}<br>
                        <br>
                    </c:forEach>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
