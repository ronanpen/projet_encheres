<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification</title>
</head>
<body>
	<header> <%@include file="EnTete.jsp"%>
	</header>

<h1> Mon Profil</h1>
<h2> Modification de mon profil</h2>

<div class="container p-5 w-md-50">
			<form method="POST">
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="pseudo">Pseudo* :</label> <input class="form-control"
							type="text" name="pseudo" id="pseudo" value="${utilisateur.pseudo}"
							size="30" maxlength="30" autofocus="autofocus" required />
					</div>
					<div class="form-group col-md-6">
						<label for="nom">Nom* :</label> <input class="form-control"
							type="text" name="nom" id="nom" autofocus="autofocus"
							value="${utilisateur.nom}" size="30" maxlength="30"
							autofocus="autofocus" required />
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="prenom">Prénom* :</label> <input class="form-control"
							type="text" name="prenom" id="prenom" value="${utilisateur.prenom}"
							size="30" maxlength="30" autofocus="autofocus" required />
					</div>
					<div class="form-group col-md-6">
						<label for="email">Email* :</label> <input class="form-control"
							type="email" name="email" id="email" value="${utilisateur.email}"
							size="30" maxlength="20" autofocus="autofocus" required />
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="telephone">Téléphone :</label> <input
							class="form-control" type="text" name="telephone" id="telephone"
							value="${utilisateur.telephone}" size="30" maxlength="15"
							autofocus="autofocus" />
					</div>
					<div class="form-group col-md-6">
						<label for="rue">Rue* :</label> <input class="form-control"
							type="text" name="rue" id="rue" size="30" value="${utilisateur.rue}"
							size="30" maxlength="30" autofocus="autofocus" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="codePostal">Code postal* :</label> <input
							class="form-control" type="text" name="codePostal"
							id="codePostal" value="${utilisateur.codePostal}" size="30"
							maxlength="10" autofocus="autofocus" required />
					</div>
					<div class="form-group col-md-6">
						<label for="ville">Ville* :</label> <input class="form-control"
							type="text" name="ville" id="ville" size="30"
							value="${utilisateur.ville}" size="30" maxlength="30"
							autofocus="autofocus" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="motDePasse">Mot de passe* :</label> <input
							class="form-control" type="password" name="motDePasse"
							id="motDePasse" size="30" maxlength="60" autofocus="autofocus"
							placeholder="votre mot de passe" required />
					</div>
					<div class="form-group col-md-6">
						<label for="confirmation">Confirmation* :</label> <input
							class="form-control" type="password" name="confirmation"
							id="confirmation" size="30" maxlength="60" autofocus="autofocus"
							placeholder="confirmez votre mot de passe" required />
					</div>
				</div>

				<div class="text-center">
					<button type="submit" class="btn btn-success btn-lg">Enregistrer</button>

					<!-- 	Bouton "Supprimer mon compte" renvoie vers l'accueil -->
					<%-- <a class="btn btn-danger btn-lg"
						href="<%=request.getContextPath()%>/accueil">Supprimer mon compte</a> --%>
				</div>
			</form>
		</div>






<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

</body>
</html>