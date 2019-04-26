<nav
	class="navbar navbar-expand-lg navbar-dark bg-dark justify-content-between">
	<a class="navbar-brand" href="#">Enchères</a> 
	
	<p>${Idutilisateur.pseudo} est connecté</p>
	
		
<!-- 	à afficher si déconnecté -->
	<a href="<%=request.getContextPath()%>/connexion">S'inscrire - Se
		connecter</a>
		
	<!-- 	à afficher si connecté -->
		<a href="<%=request.getContextPath()%>/deconnexion">Se déconnecter</a>
		<a href="<%=request.getContextPath()%>/monProfil">Mon profil</a>
		
		
		
		
		
		
</nav>