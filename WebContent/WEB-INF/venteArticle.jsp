<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" async></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" async></script>
	<meta charset="UTF-8">
	<style>
		fieldset.scheduler-border {
		    border: 1px groove #ddd !important;
		    padding: 0 1.4em 1.4em 1.4em !important;
		    margin: 0 0 1.5em 0 !important;
		    -webkit-box-shadow:  0px 0px 0px 0px #000;
		            box-shadow:  0px 0px 0px 0px #000;
		}
	
	    legend.scheduler-border {
	        font-size: 1.2em !important;
	        font-weight: bold !important;
	        text-align: left !important;
	        width:auto;
	        padding:0 10px;
	        border-bottom:none;
	    }
	</style>
	<title>Vendre un article</title>
</head>
<body>
	<header><%@include file="EnTete.jsp" %></header>
		
	<div class="container mt-5">
		<div class="text-center">
			<h2>Nouvelle vente</h2>
		</div>
		<form method="post">
			<div class="row">
				<div class="col-12 col-md-4 order-2 order-md-1">
					<img class="img-fluid" src="https://media.flixcar.com/f360cdn/Samsung-1918702440-fr-washer-ww70j5556-ww70j5556fx-ef-dynamicmineralashblack-61600115-zoom.png" alt="Image de l'article">
				</div>
				<div class="col-12 col-md-6 order-1 order-md-2">
					<div class="form-group">
						<label for="nomArticle">Article</label>
						<input class="form-control" type="text" name="nomArticle" id="nomArticle" placeholder="Nom de l'article" maxlength="30">
					</div>
					<div class="form-group">
						<label for="descriptionArticle">Description</label>
						<textarea class="form-control" name="descriptionArticle" id="descriptionArticle" maxlength="300">
						</textarea>
					</div>
					<div class="form-group">
						<label for="categorieArticle">Catégorie</label>
						<select class="form-control" name="categorieArticle" id="categorieArticle">
							<c:forEach items="${categorieArticle}" var="categorie">
								<option value="${categorie.idCategorie}">${categorie.libelle}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="imgArticle">Photo de l'article</label>
						<div class="custom-file">
							<input class="custom-file-input" type="file" name="imgArticle" id="imgArticle">
							<label class="custom-file-label" for="imgArticle">UPLOADER</label>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6 offset-md-4 order-3">
					<div class="form-group">
						<label for="prixDepart">Mise à prix</label>
						<input class="form-control w-25" type="number" 
							name="prixDepart" id="prixDepart" placeholder="Prix">
					</div>
					<div class="form-group">
						<label for="debutEnchere">Début de l'enchère</label>
						<input class="form-control" type="date" name="debutEnchere" id="debutEnchere" placeholder="Début de l'enchère">
					</div>
					<div class="form-group">
						<label for="finEnchere">Fin de l'enchère</label>
						<input class="form-control" type="date" name="finEnchere" id="finEnchere" placeholder="Fin de l'enchère">
					</div>
					<fieldset class="scheduler-border">
						<legend class="scheduler-border">Retrait</legend>
						<div class="form-group">
							<label for="nomRue">Rue</label>
							<input class="form-control" type="text" name="nomRue" id="nomRue" placeholder="Nom de la rue" maxlength="30" value="${utilisateur.rue}">
						</div>
						<div class="form-group">
							<label for="codePostal">Code postal</label>
							<input class="form-control" type="number" name="codePostal" id="codePostal" placeholder="Code Postal" maxlength="5" value="${utilisateur.codePostal}">
						</div>
						<div class="form-group">
							<label for="ville">Ville</label>
							<input class="form-control" type="text" name="ville" id="ville" placeholder="Ville" maxlength="30" value="${utilisateur.ville}">
						</div>
					</fieldset>
					<div class="form-group">
						<input class="btn btn-lg btn-success mr-2" type="submit" value="Enregistrer">
						<input class="btn btn-lg btn-danger ml-2" type="reset" value="Annuler">
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>