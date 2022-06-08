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

<div class="page">
    <div class="form">
        <form action="/connexion" method="post">
            <h1>Se connecter</h1>
            <div class="item">
                <label for="mail">Adresse mail</label>
                <input type="email" class="form-control" id="mail" name="mail" aria-describedby="emailHelp" placeholder="Entrez votre mail" required>
            </div>
            <div class="item">
                <label for="password">Mot de passe</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Mot de passe" required>
            </div>
            <div class="connexion_buttons">
                <button type="submit" class="btn btn-primary m-2">Connexion</button>
                <a href="/signup"><button type="button" class="btn btn-secondary m-2">Créer un compte</button></a>
            </div>
        </form>
    </div>
</div>

</body>
</html>