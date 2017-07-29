<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrapv336.min.css">
    <link rel="stylesheet" type="text/css" href="resources\css\custom.css">

	<title>Alteração Usuário</title>
</head>
<body>

<%@ include file="../include/header.jsp" %> 
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4 well">

			<form action="alteraUsuario" method="POST">
				<fieldset>
					<legend>Alterar Usuário - ${usuario.id_user }</legend>
					<input type="hidden" name="id_user" value="${usuario.id_user }"/>
					    <div class="form-group">
					      <label for="nome">Nome</label>
					      <input type="text" name="nome" value="${usuario.nome}" class="form-control"/>
					      <span class='text-danger'></span>
					    </div>
					    <div class="form-group">
					      <label for="nick">Apelido</label>
					      <input type="text" name="nick" value="${usuario.nick}" class="form-control"/>
					      <span class='text-danger'></span>
					    </div>
					    <div class="form-group">
					      <label for="email">E-mail</label>
					      <input type="text" name="email" value="${usuario.email}" class="form-control">
					      <span class='text-danger'></span>
					    </div>
		 			    <div class="form-group">
					      <label for="senha">Senha</label>
					      <input type="password" name="senha" value="${usuario.senha}" class="form-control" >
					      <span class='text-danger'></span>
					    </div>
					    <div class="form-group">
					      <label for="dtNasc">Data de Nascimento</label>
					      <input type="text" class="form-control" name="dtNasc" value="<fmt:formatDate value="${usuario.dtNasc.time}" pattern="dd/MM/yyyy" />"/>
					      <span class='text-danger'></span>
					    </div>
 
					    <div class="form-group">
					    	<input type="submit" value="Alterar" class="btn btn-primary" />
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