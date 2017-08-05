<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" charset="utf-8">
	<title>Faça seu login</title>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrapv336.min.css">
</head>
<body>

<%@ include file="../include/header.jsp" %> 

<div class="container">
	<div class="row">
		<div class="col-md-6 well">
		
			<form action="adicionaLanctos" method="POST">	
				<fieldset>
					<legend>Lançamentos</legend>
				    	<div class="form-group">
				    		<div class="row">
								<div class="btn-group col-md-8" role="group" aria-label="...">
									<button type="button" class="btn btn-default" name="sgMovimento" value="D" autofocus><font size="2">Despesa</font></button>
									<button type="button" class="btn btn-default" name="sgMovimento" value="R"><font size="2">Receita</font></button>
									<button type="button" class="btn btn-default" name="sgMovimento" value="T"><font size="2">Transferência</font></button>
								</div>
								<div class="col-md-4">
									<input type="radio" name="tpConta" value="1"><font size="2"> Conta</font>
									<input type="radio" name="tpConta" value="2"><font size="2"> Cartão</font>
								</div>
							</div>
						</div>
					    <div class="form-group row">
					    	<label for="vllancto" class="col-sm-2 col-form-label">Valor</label>
					    	<div class="col-sm-8">
								<input type="number" name="vlLancamento" placeholder="Valor (R$)" class="form-control">
							</div>
							<button type="button" class="btn btn-default">
								<span class="glyphicon glyphicon-ok-circle"></span>
							</button>
							<button type="button" class="btn btn-default">
								<span class="glyphicon glyphicon-ban-circle"></span>
							</button>
					    </div>

					    <div class="form-group row">
					    	<label for="dslancto" class="col-sm-2 col-form-label">Descrição</label>
					    	<div class="col-sm-10">
								<input type="text" name="dsLancamento" placeholder="Descrição Lançamento" class="form-control">
							</div>
					    </div>
					    <div class="form-group row">
					    	<label for="dtlancto" class="col-sm-2 col-form-label">Data</label>
					    	<div class="col-sm-10">
								<input type="date" name="dtLancamento" placeholder="Data (dd/mm/yyyy)" class="form-control">
							</div>
					    </div>
					    <div class="form-group row">
					    	<label for="Categoria" class="col-sm-2 col-form-label">Categoria</label>
					    	<div class="col-sm-10">
								<input type="text" name="idCategoria" placeholder="Categoria" class="form-control">
							</div>
					    </div>
					    <div class="form-group row">
					    	<label for="Sub" class="col-sm-2 col-form-label">Sub-Categoria</label>
					    	<div class="col-sm-10">
								<input type="text" name="idSubCategoria" placeholder="Sub-Categoria" class="form-control">
							</div>
					    </div>
					    <div class="form-group row">
					    	<label for="conta" class="col-sm-2 col-form-label">Conta / Cartão</label>
					    	<div class="col-sm-10">
								<input type="text" name="idConta" placeholder="Conta / Cartão" class="form-control">
							</div>
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
