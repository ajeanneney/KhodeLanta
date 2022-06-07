<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Liste des Utilisateurs</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
    <jsp:include page="header.jsp"/>
</head>
<body>

<div class="page">
    <h1>Liste des Utilisateurs</h1>
    <p>${messageConfirmed}${bannirMessage}${debannirMessage}</p>
    <div class="shadow rounded p-5 m-2 border border-secondary">
        <table>
            <thead>
            <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Email</th>
                <th>Modifier le profil</th>
                <th>Supprimer un profil</th>
                <th>Bannir/Debannir</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <c:if test="${user.personType != 'ADMIN'}">
                    <tr>
                        <td>${user.lastname}</td>
                        <td>${user.firstname}</td>
                        <td>${user.mail}</td>
                        <td><a href="/admin/user/${user.id}/edit">Modifier</a></td>
                        <td><a href="/admin/user/${user.id}/delete">Supprimer</a></td>
                        <td>
                            <c:choose>
                                <c:when test="${user.status == 1}">
                                    <a href="/admin/user/${user.id}/ban">Bannir</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/admin/user/${user.id}/deban">Debannir</a>
                                </c:otherwise>
                            </c:choose>

                        </td>
                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>
        <c:forEach items="${users}" var="user">

        </c:forEach>
    </div>
</div>

</body>
</html>