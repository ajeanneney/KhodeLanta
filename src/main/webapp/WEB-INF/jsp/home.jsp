<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Connexion</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
    <jsp:include page="header.jsp"/>
</head>
<body>
<<<<<<< Updated upstream:src/main/webapp/WEB-INF/jsp/home.jsp
<h1>Home</h1>
<a href="/newannonce">nouvelle annonce</a>
<div class="d-flex justify-content-around">
=======
>>>>>>> Stashed changes:src/main/webapp/WEB-INF/jsp/oldHome.jsp

<div class="page">
    <h1>Bienvenue</h1>
    <div class="shadow rounded p-5 m-2 border border-secondary">
        Prenom : ${user.firstname}<br>
        Nom : ${user.lastname}<br>
        Mail : ${user.mail}<br>
    </div>

<%--    <div class="shadow rounded p-5 m-2 border border-secondary">--%>
<%--        <c:forEach items="${annonces}" var="a">--%>
<%--            ${a.title}<br>--%>
<%--            ${a.description}<br>--%>
<%--            ${a.adresse}<br>--%>
<%--            <c:forEach items="${a.categories}" var="c">--%>
<%--                ${c.title}<br>--%>
<%--                ${c.description}<br>--%>
<%--                <br>--%>
<%--            </c:forEach>--%>
<%--            <br><br>--%>
<%--        </c:forEach>--%>
<%--    </div>--%>

</div>

</body>
</html>
