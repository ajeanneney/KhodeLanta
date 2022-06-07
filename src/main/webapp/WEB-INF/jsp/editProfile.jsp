<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Connexion</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css" />
    <jsp:include page="header.jsp"/>
</head>
<body>
<h1>Edit Profile</h1>
<div class="d-flex justify-content-around">

    <div class="shadow rounded p-5 m-2 border border-secondary">
        <form method="post" action="/${fn:toLowerCase(user.personType)}/updateProfile">
            Prenom : <input name="firstname" type="text" value="${user.firstname}"><br>
            Nom : <input name="lastname" type="text" value="${user.lastname}"><br>
            Mail : <input name="mail" type="text" value="${user.mail}"><br>

            <input type="submit" value="Edit">
        </form>

    </div>
</div>

</body>
</html>
