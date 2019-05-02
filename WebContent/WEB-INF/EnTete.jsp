<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<nav class="navbar navbar-expand-lg navbar-dark bg-info">
    <div class="d-flex flex-grow-1">
        <a class="navbar-brand" href="accueil">Enchères</a>
        <div class="w-100 text-right">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
        </div>
    </div>
    <div class="collapse navbar-collapse flex-grow-1 text-lg-right" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto flex-nowrap">
            <c:choose>
				<c:when test="${sessionScope.idUtilisateur == null}">
			
					<li class="nav-item"><a class="nav-link pl-2 pr-2" href="<%=request.getContextPath()%>/connexion">S'inscrire - Se
						connecter</a></li>
				</c:when>
			
				<c:otherwise>
					<li class="nav-item"><a class="nav-link pl-2 pr-2" href="<%=request.getContextPath()%>/vente">Vendre un article</a></li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle pl-2 pr-2" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						  <i class="far fa-user"></i>
						</a>
						<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
						  <a class="dropdown-item" href="<%=request.getContextPath()%>/profil">Mon Profil</a>
						  <div class="dropdown-divider"></div>
						  <a class="dropdown-item" href="<%=request.getContextPath()%>/deconnexion">Déconnexion</a>
						</div>
					</li>
				
				</c:otherwise>
			</c:choose>
        </ul>
    </div>
</nav>