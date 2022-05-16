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


<body>

<ul>
    <li style="padding-left: 20px"><img src="<%=request.getContextPath()%>/images/logo.png" height="60" width="60"/></li>
    <li style="padding-left: 50px"><a href="/connexion">Louer un bien</a></li>
    <li><a href="/newhome">Mettre en location</a></li>
    <li><a href="/home">Mes locations</a></li>

    <c:choose>
        <c:when test="${cookie['userId'] == null || cookie['userId'] == ''}">
            <li style="float:right; padding-right: 50px"><a href="/signup">Connexion/Inscription</a></li>
        </c:when>
        <c:otherwise>
            <li style="float:right; padding-right: 50px "><a href="/disconnect">Se déconnecter</a></li>
        </c:otherwise>
    </c:choose>
</ul>

</body>
</html>

