<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Mon Profil</title>
</head>
<body>
	<header> <%@include file="EnTete.jsp"%>
	</header>

	<div class="container mt-5">
		<table class="table">
			<tr>
				<td>Pseudo :</td>
				<td>${utilisateur.pseudo}</td>
			</tr>
			<tr>
				<td>nom :</td>
				<td>${utilisateur.nom}</td>
			</tr>
			<tr>
				<td>Prénom :</td>
				<td>${utilisateur.prenom}</td>
			</tr>
			<tr>
				<td>Email :</td>
				<td>${utilisateur.email}</td>
			</tr>
			<tr>
				<td>Téléphone :</td>
				<td>${utilisateur.telephone}</td>
			</tr>
			<tr>
				<td>Rue :</td>
				<td>${utilisateur.rue}</td>
			</tr>
			<tr>
				<td>Code postal :</td>
				<td>${utilisateur.codePostal}</td>
			</tr>
			<tr>
				<td>Ville :</td>
				<td>${utilisateur.ville}</td>
		</table>
		<div class="text-center">
			<button type="submit" class="btn btn-warning btn-lg">Modifier</button>
		</div>
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