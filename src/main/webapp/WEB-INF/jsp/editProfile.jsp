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
<div class="page">

    <h1>Edit Profile</h1>
    <div class="form">

        <form method="post" action="/${fn:toLowerCase(user.personType)}/updateProfile">
            <div class="item">
                <label for="firstname">Prénom</label>
                <input name="firstname" class="form-control" id="firstname" type="text" value="${user.firstname}">
            </div>
            <div class="item">
                <label for="lastname">Nom</label>
                <input name="lastname" class="form-control" type="text" id="lastname" value="${user.lastname}">
            </div>
            <div class="item">
                <label for="mail">Mail</label>
                <input name="mail" class="form-control" id="mail" type="text" value="${user.mail}">
            </div>

            <button type="submit" class="btn btn-primary m-2">Modifier</button>
        </form>


    </div>

</div>


</body>
</html>
