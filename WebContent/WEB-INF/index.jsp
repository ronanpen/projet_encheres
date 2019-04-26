<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Liste des enchères</title>
</head>
<body>
	<header> 
	<%@include file="EnTete.jsp" %>
	
	</header>
	<h1>Liste des enchères</h1>


	<form>

		<div class="form-group">
			<label for="identifiant">Filtres :</label> <input type="text"
				class="form-control" name="filtres"
				placeholder="Le nom de l'article contient" />
		</div>
		<label class="my-1 mr-2" for="categorie">Catégorie</label> <select
			class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">
			<option selected>Toutes</option>
			<option value="1">Trucs</option>
			<option value="2">Machins</option>
			<option value="3">Choses</option>
		</select>
		
	<h2> ${sessionScope.idUtilisateur} est connecté </h2>
		
<!--  TODO: a mettre en conditionnel -->
		
<!-- 	<input class="form-check-input" type="radio" name="choixAchatVente"
				id="achats" value="achats" checked> <label
				class="form-check-label" for="achats"> Achats </label>
		</div>
		<div class="form-check">
			<input class="form-check-input" type="checkbox" value=""
				id="encheresOuvertes"> <label class="form-check-label"
				for="encheresOuvertes"> enchères ouvertes </label>
		</div>
		<div class="form-check">
			<input class="form-check-input" type="checkbox" value=""
				id="encheresEnCours"> <label class="form-check-label"
				for="encheresEnCours"> mes enchères en cours </label>
		</div>
		<div class="form-check">
			<input class="form-check-input" type="checkbox" value=""
				id="encheresRemportées"> <label class="form-check-label"
				for="encheresRemportées"> mes enchères remportées </label>
		</div>

		<div class="form-check">
			<input class="form-check-input" type="radio" name="choixAchatVente"
				id="mesVentes" value="mesVentes"> <label
				class="form-check-label" for="mesVentes"> Mes ventes </label>

		</div>
		<div class="form-check">
			<input class="form-check-input" type="checkbox" value=""
				id="ventesEnCours"> <label class="form-check-label"
				for="ventesEnCours"> mes ventes en cours </label>
		</div>
		<div class="form-check">
			<input class="form-check-input" type="checkbox" value=""
				id="ventesNonDebutees"> <label class="form-check-label"
				for="ventesNonDebutees">ventes non débutées </label>
		</div>
		<div class="form-check">
			<input class="form-check-input" type="checkbox" value=""
				id="ventesTerminees"> <label class="form-check-label"
				for="ventesTerminees"> ventes terminées </label>
		</div> 
-->


	</form>



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