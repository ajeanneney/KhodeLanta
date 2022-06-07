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
    <div class="form">
        <form action="/signup" method="post">
            <h1>S'inscrire</h1>
            <div class="item">
                <label for="firstname">Prénom</label>
                <input type="text" class="form-control" id="firstname" name="firstname" placeholder="Entrez votre prénom" required>
            </div>
            <div class="item">
                <label for="lastname">Nom</label>
                <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Entrez votre nom" required>
            </div>
            <div class="item">
                <label for="mail">Adresse mail</label>
                <input type="email" class="form-control" id="mail" name="mail" aria-describedby="emailHelp" placeholder="Entrez votre mail" required>
            </div>
            <div class="item">
                <label for="password">Mot de passe</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Mot de passe" required>
            </div>
                <div class="item">
                    <select name="persontype" id="persontype" class="form-select">
                        <option value="" selected disabled>Choisisez un type d'utilisateur</option>
                        <option value="ADMIN">Administrateur</option>
                        <option value="STUDENT">Etudiant</option>
                        <option value="OLD">Personne aggée</option>
                    </select>
                </div>
                <div class="connexion_buttons">
                    <button type="submit" class="btn btn-primary m-2">S'inscrire</button>
                    <button type="button" class="btn btn-secondary m-2"><a href="/connexion">S'identifier</a></button>
                </div>
        </form>
    </div>
</div>

</body>
</html>