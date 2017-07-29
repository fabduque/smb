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
		
			<form action="adicionaCategoria" method="POST">	
				<fieldset>
					<legend>Cadastro de Categorias</legend>
					    <div class="form-group">
					       <label for="desc">Descrição</label>
							<input type="text" name="dsCategoria" placeholder="Descrição Categoria" required class="form-control"/>
					      <span class='text-danger'></span>
					    </div>
					    <div class="radio">
					      <label><input type="radio" name="icDebCred" value="D"> Débito</label>
					    </div>
					    <div class="radio">
					      <label><input type="radio" name="icDebCred" value="C"> Crédito</label>
					     </div>
					    <div class="form-group">
					    	<input type="submit" value="Adicionar" class="btn btn-primary" />
					     </div>

				   </fieldset>
				</form>
        </div>
    </div>
</div>

	<%@ include file="../include/footer.jsp" %>

	<script src="resources/jquery/jquery.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
