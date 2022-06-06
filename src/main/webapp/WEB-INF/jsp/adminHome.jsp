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

<div class="d-flex justify-content-center flex-nowrap">
    <form action="/adminHome" method="post" class="shadow rounded p-3 m-3">
        <h1>Page pour l'admin</h1>
            <div class="shadow rounded p-5 m-2 border border-secondary">
                <c:forEach items="${annonces}" var="a">
                    ${a.title}<br>
                    ${a.description}<br>
                    ${a.adresse}<br>
                    <c:forEach items="${a.categories}" var="c">
                        ${c.title}<br>
                        ${c.description}<br>
                        <br>
                    </c:forEach>
                    <br><br>
                </c:forEach>
        </div>
    </form>
</div>

</body>
</html>