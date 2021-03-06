<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Liste des ench�res</title>
</head>
<body>
	<header> <%@include file="EnTete.jsp"%>

	</header>

	<div class="container p-3 mt-5">
		<div class="text-center">
			<h1>Liste des ench�res</h1>
		</div>
		<form class="row">
			<div class="col-12 col-lg-6">
				<label>Filtres :</label>
				<div class="row w-100">
					<div class="col-12 order-3 order-md-1">
						<div class="form-group">
							<input type="text"
								class="form-control" name="filtres"
								placeholder="Le nom de l'article contient" />
						</div>
					</div>
					<div class="col-12 order-2 order-md-2">
						<div class="row">
							<div class="col-4">
								<label class="my-1 mr-2" for="categorie">Cat�gorie</label> 
							</div>
							<div class="col-8">
								<select class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref" name="categorie">
									<option selected value="0">Toutes</option>
									<c:forEach items="${categories}" var="categorie">
										<option value="${categorie.idCategorie}">${categorie.libelle}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
		
		
					<!-- 		afficher le menu uniquement si l'utilisateur est connect�
		 -->
		 			<div class="col-12 order-1 order-md-3">
						<c:if test="${sessionScope.idUtilisateur != null}">
							<div class="row">
								<div class="col-12 col-md-6">
									<div class="form-check">
										<input class="form-check-input" type="radio" name="choixAchatVente"
											id="achats" value="achats" checked> <label
											class="form-check-label" for="achats"> Achats </label>
									</div>
									<div class="pl-4">
										<div class="form-check">
											<input class="form-check-input" type="checkbox" value=""
												id="encheresOuvertes"> <label class="form-check-label"
												for="encheresOuvertes"> ench�res ouvertes </label>
										</div>
										<div class="form-check">
											<input class="form-check-input" type="checkbox" value=""
												id="encheresEnCours"> <label class="form-check-label"
												for="encheresEnCours"> mes ench�res en cours </label>
										</div>
										<div class="form-check">
											<input class="form-check-input" type="checkbox" value=""
												id="encheresRemport�es"> <label class="form-check-label"
												for="encheresRemport�es"> mes ench�res remport�es </label>
										</div>
									</div>
								</div>
								<div class="col-12 col-md-6">
									<div class="form-check">
										<input class="form-check-input" type="radio" name="choixAchatVente"
											id="mesVentes" value="mesVentes"> <label
											class="form-check-label" for="mesVentes"> Mes ventes </label>
									</div>
									<div class="pl-4">
										<div class="form-check">
											<input class="form-check-input" type="checkbox" value=""
												id="ventesEnCours"> <label class="form-check-label"
												for="ventesEnCours"> mes ventes en cours </label>
										</div>
										<div class="form-check">
											<input class="form-check-input" type="checkbox" value=""
												id="ventesNonDebutees"> <label class="form-check-label"
												for="ventesNonDebutees">ventes non d�but�es </label>
										</div>
										<div class="form-check">
											<input class="form-check-input" type="checkbox" value=""
												id="ventesTerminees"> <label class="form-check-label"
												for="ventesTerminees"> ventes termin�es </label>
										</div>
									</div>
								</div>
							</div>
						</c:if>
					</div>
				</div>
			</div>
			<div class="col-12 col-lg-6 d-flex align-items-center justify-content-center p-5">
				<button class="btn btn-success btn-lg w-100 h-100" type="submit"><div class="display-4">Rechercher</div></button> 
			</div>
		</form>
		<div class="row">
			<div class="col-12 col-md-6 mt-3">
				<div class="card bg-info text-white">
					<div class="card-body">
						<div class="row">
							<div class="col-4">
								<img class="img-fluid" 
								src="https://media.flixcar.com/f360cdn/Samsung-1918702440-fr-washer-ww70j5556-ww70j5556fx-ef-dynamicmineralashblack-61600115-zoom.png" 
								alt="Image de l'article">
							</div>
							<div class="col-8">
								<h5 class="card-title"><a class="card-link text-white" href="#">PC Gamer pour travailler</a></h5>
								<p>Prix: 210 points</p>
								<p>Fin de l'ench�re: 10/08/2018</p>
								<p class="card-text">
								<c:choose>
									<c:when test="${sessionScope.idUtilisateur != null}">
										<a href="#"><small class="text-muted">jojo44</small></a>
									</c:when>
									<c:otherwise>
										<small class="text-muted">jojo44</small>
									</c:otherwise>
								</c:choose>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-12 col-md-6 mt-3">
				<div class="card bg-info text-white">
					<div class="card-body">
						<div class="row">
							<div class="col-4">
								<img class="img-fluid" 
								src="https://media.flixcar.com/f360cdn/Samsung-1918702440-fr-washer-ww70j5556-ww70j5556fx-ef-dynamicmineralashblack-61600115-zoom.png" 
								alt="Image de l'article">
							</div>
							<div class="col-8">
								<h5 class="card-title"><a class="card-link text-white" href="#">PC Gamer pour travailler</a></h5>
								<p>Prix: 210 points</p>
								<p>Fin de l'ench�re: 10/08/2018</p>
								<p class="card-text"><a href="#"><small class="text-muted">jojo44</small></a></p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-12 col-md-6 mt-3">
				<div class="card bg-info text-white">
					<div class="card-body">
						<div class="row">
							<div class="col-4">
								<img class="img-fluid" 
								src="https://media.flixcar.com/f360cdn/Samsung-1918702440-fr-washer-ww70j5556-ww70j5556fx-ef-dynamicmineralashblack-61600115-zoom.png" 
								alt="Image de l'article">
							</div>
							<div class="col-8">
								<h5 class="card-title"><a class="card-link text-white" href="#">PC Gamer pour travailler</a></h5>
								<p>Prix: 210 points</p>
								<p>Fin de l'ench�re: 10/08/2018</p>
								<p class="card-text"><a href="#"><small class="text-muted">jojo44</small></a></p>
							</div>
						</div>
					</div>
				</div>
			</div>
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