<nav
	class="navbar navbar-expand-lg navbar-dark bg-dark justify-content-between">
	<a class="navbar-brand" href="accueil">Enchères</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>	

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<c:choose>
				<c:when test="${sessionScope.idUtilisateur == null}">
			
					<li class="nav-item"><a class="nav-link pl-2 pr-2" href="<%=request.getContextPath()%>/connexion">S'inscrire - Se
						connecter</a></li>
				</c:when>
			
				<c:otherwise>
					<li class="nav-item"><a class="nav-link pl-2 pr-2" href="<%=request.getContextPath()%>/vente">Vendre un article</a></li>
					<li class="nav-item"><a class="nav-link pl-2 pr-2" href="<%=request.getContextPath()%>/monProfil">Mon profil</a></li>
					<li class="nav-item"><a class="nav-link pl-2 pr-2" href="<%=request.getContextPath()%>/deconnexion">Se déconnecter</a></li>
				
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</nav>