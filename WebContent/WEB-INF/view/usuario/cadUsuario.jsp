<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" charset="utf-8">
	<title>Faça seu login</title>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrapv336.min.css">
    <link rel="stylesheet" type="text/css" href="resources\css\custom.css">
</head>
<body>

	<%@ include file="../include/header.jsp" %> 

<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4 well">
		
			<form action="adicionaUsuario" method="POST">	
				<fieldset>
					<legend>Cadastro de Usuários</legend>
					    <div class="form-group">
					       <label for="nome">Nome</label>
							<input type="text" name="nome" placeholder="Infome o seu Nome completo" required class="form-control"/>
					      <span class='text-danger'></span>
					    </div>
					    <div class="form-group">
					      <label for="nick">Apelido</label>
					      <input type="text" name="nick" placeholder="Infome o seu Apelido" required class="form-control"/>
					      <span class='text-danger'></span>
					    </div>
					    <div class="form-group">
					      <label for="email">E-mail</label>
					      <input type="email" name="email" placeholder="email@exemplo.com" required class="form-control">
					      <span class='text-danger'></span>
					    </div>
		 			    <div class="form-group">
					      <label for="senha">Senha</label>
					      <input type="password" name="senha" placeholder="Senha" required class="form-control" >
					      <span class='text-danger'></span>
					    </div>
					    <div class="form-group">
					      <label for="dtNasc">Data de Nascimento</label>
					      <input type="date" data-format="dd/mm/yyyy" class="form-control" id="dtNasc" maxlength="10" name="dtNasc" required>
					      <span class='text-danger'></span>
					    </div>
 
					    <div class="form-group">
					    	<input type="submit" value="Adicionar" class="btn btn-primary" />
					     </div>

				   </fieldset>
				</form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-4 text-center">    
        Já registrado? <a href="view\login.jsp">Entre Login</a>
        </div>
        <div class="col-md-4 col-md-offset-4 text-center">    
        CCusto <a href="view\ccusto.jsp">CCusto</a>
        </div>
    </div>
</div>

	<%@ include file="../include/footer.jsp" %>

	<script src="resources/jquery/jquery.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
