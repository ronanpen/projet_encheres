<nav
	class="navbar navbar-expand-lg navbar-dark bg-dark justify-content-between">
	<a class="navbar-brand" href="#">Ench�res</a> 
	
	<p>${Idutilisateur.pseudo} est connect�</p>
	
		
<!-- 	� afficher si d�connect� -->
	<a href="<%=request.getContextPath()%>/connexion">S'inscrire - Se
		connecter</a>
		
	<!-- 	� afficher si connect� -->
		<a href="<%=request.getContextPath()%>/deconnexion">Se d�connecter</a>
		<a href="<%=request.getContextPath()%>/monProfil">Mon profil</a>
		
		
		
		
		
		
</nav>