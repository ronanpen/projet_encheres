<nav
	class="navbar navbar-expand-lg navbar-dark bg-dark justify-content-between">
	<a class="navbar-brand" href="accueil">Ench�res</a>

	
<c:choose>
	<c:when test="${sessionScope.idUtilisateur == null}">

		<a href="<%=request.getContextPath()%>/connexion">S'inscrire - Se
			connecter</a>
	</c:when>

	<c:otherwise>
		<a href="<%=request.getContextPath()%>/accueil">Ench�res</a>
		<a href="<%=request.getContextPath()%>#####">Vendre un article</a>
		<a href="<%=request.getContextPath()%>/monProfil">Mon profil</a>
		<a href="<%=request.getContextPath()%>/deconnexion">Se d�connecter</a>
	
	</c:otherwise>
</c:choose>




</nav>