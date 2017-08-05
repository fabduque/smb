<nav class="navbar navbar" style="background-color: #F8F8F8; border-color: #E7E7E7;">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">SMB Logo</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="abertura">Home</a> </li>
			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Cadastros <span class="caret"></span></a> 
				<ul class="dropdown-menu">
					<li><a href="listaConta">Conta</a></li>
					<li><a href="listaCategoria">Categoria</a></li>
					<li><a href="listaSub">Sub-Categoria</a></li>
					<li><a href="#">Forma de Pagto</a></li>
				</ul>
			</li>
			<li><a href="listaLanctos">Mov. Bancário</a></li>
			<li><a href="#">Controle Gastos</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Admin <span class="caret"></span></a> 
				<ul class="dropdown-menu">
					<li><a href="listaUsuarios">Usuários</a></li>
				</ul>
			</li>
			<li><a href="#"><span class="glyphicon glyphicon-user"></span> ${usuarioLogado.login}</a></li>
			<li><a href="logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
		</ul>
	</div>
</nav>