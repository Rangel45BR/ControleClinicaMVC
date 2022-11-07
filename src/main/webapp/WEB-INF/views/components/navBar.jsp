<!-- menu do sistema -->

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container-fluid">
	
		<a class="navbar-brand" href="#">VeronaTech</a>
				
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
				
				
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/controle_clinica/admin/pagina-inicial">Página
						inicial &nbsp;</a></li>
						
						
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Gerenciar
						cadastros </a>
					
					<ul class="dropdown-menu" >
						<li><a class="dropdown-item"
							href="/controle_clinica/admin/cadcliente">Cadastrar
								Clientes</a></li>
						<li><a class="dropdown-item"
							href="/controle_clinica/admin/cadcolaborador">Cadastrar
								Colaborador</a></li>					
					</ul></li>
					
					<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Consultas</a>
					
					<ul class="dropdown-menu" >
						<li><a class="dropdown-item"
							href="/controle_clinica/admin/consultar-clientes">Consultar
								Clientes</a></li>
						<li><a class="dropdown-item"
							href="/controle_clinica/admin/consultar-colaborador">Consultar
								Colaborador</a></li>					
					</ul></li>
					
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Acesso/Sistema </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item"
							href="/controle_clinica/admin/alterar-senha">Alterar senha de
								acesso</a></li>
					</ul></li>
			</ul>



			<div class="d-flex">
				<div class="text-white">
					<strong>${usuario_auth.nome}</strong> (${usuario_auth.email})
					&nbsp;&nbsp;&nbsp; <a href="/controle_clinica/logout"
						class="btn btn-outline-light btn-sm"
						onclick="return confirm('Deseja realmente encerrar sua sessão?');">
						Sair da Agenda </a>
				</div>
			</div>

		</div>
	</div>
</nav>


