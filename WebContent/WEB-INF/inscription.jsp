<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, user-scalable=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscription</title>
</head>
<body>
	<header> <nav
		class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
		class="navbar-brand" href="#">Enchères</a> </nav> </header>

	<div class="container p-5">
		<h1>Mon Profil</h1>
		<h2>Inscription</h2>
		<form method="POST">

			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="pseudo">Pseudo* :</label> 
					<input class="form-control"
						type="text" name="pseudo" id="pseudo" placeholder="votre pseudo"
						size="30" maxlength="30" autofocus="autofocus" required />
				</div>
				<div class="form-group col-md-6">
					<label for="nom">Nom* :</label> 
					<input class="form-control"
						type="text" name="nom" id="nom" autofocus="autofocus"
						placeholder="votre nom" size="30" maxlength="30"
						autofocus="autofocus" required />
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="prenom">Prénom* :</label> 
					<input class="form-control"
						type="text" name="prenom" id="prenom" placeholder="votre prénom"
						size="30" maxlength="30" autofocus="autofocus" required />
				</div>
				<div class="form-group col-md-6">
					<label for="email">Email* :</label> <input class="form-control"
						type="email" name="email" id="email" placeholder="votre email"
						size="30" maxlength="20" autofocus="autofocus" required />
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="telephone">Téléphone :</label> <input
						class="form-control" type="text" name="telephone" id="telephone"
						placeholder="votre téléphone" size="30" maxlength="15"
						autofocus="autofocus" />
				</div>
				<div class="form-group col-md-6">
					<label for="rue">Rue* :</label> <input class="form-control"
						type="text" name="rue" id="rue" size="30" placeholder="votre rue"
						size="30" maxlength="30" autofocus="autofocus" required>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="codePostal">Code postal* :</label> <input
						class="form-control" type="text" name="codePostal" id="codePostal"
						placeholder="votre code postal" size="30" maxlength="10"
						autofocus="autofocus" required />
				</div>
				<div class="form-group col-md-6">
					<label for="ville">Ville* :</label> <input class="form-control"
						type="text" name="ville" id="ville" size="30"
						placeholder="votre ville" size="30" maxlength="30"
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
				<button type="submit" class="btn btn-success btn-lg">Créer</button>
				<button type="reset" class="btn btn-danger btn-lg">Annuler</button>
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