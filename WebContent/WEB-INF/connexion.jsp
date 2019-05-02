<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, user-scalable=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<style>
		.btn{
		  border-radius: 40px;
		}
	
	</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>
</head>

<body>
	<header> <%@include file="EnTete.jsp"%>
	</header>

	<div class="container p-5 w-md-50 mt-5">

		<c:if test="${message!= null}">
			<div class="alert alert-danger">${message}</div>
		</c:if>

		<form method="post">
			<div class="form-group">
				<label for="identifiant">Identifiant :</label> <input type="text"
					class="form-control" name="identifiant"
					aria-describedby="emailHelp" placeholder="Pseudo ou adresse email"
					required>
			</div>
			<div class="form-group">
				<label for="MotDePasse">Mot de passe :</label> <input
					type="password" class="form-control" name="MotDePasse"
					placeholder="Mot de passe" required>
			</div>
			<div class="d-flex mt-1 mb-1">
				<div class="col-12">
					<button type="submit" class="btn btn-lg btn-success w-100">Connexion</button>
				</div>
				
				
				<div class="col-12 col-md-8 d-flex align-items-center">
					<!--<input type="checkbox" id="Check1">
					<label class="SouvenirConnexion" for="Check1">Se souvenir de
						moi</label>-->
					<!-- 	<a href="###">Mot de passe oublié</a> -->
				</div>
			
			</div>
			<hr class="d-flex justify-content-center col-8">
			<div class="col-12">
				<a class="btn btn-lg btn-primary w-100"
				 	href="<%=request.getContextPath()%>/inscription">Créer un compte</a>
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