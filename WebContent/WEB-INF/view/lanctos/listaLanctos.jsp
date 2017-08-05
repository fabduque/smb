<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>SMB - Sistema Movimento Bancário</title>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrapv336.min.css">
    <link rel="stylesheet" href="resources/css/estilo.css">
</head>
<body>

	<c:import url="../include/header.jsp" /> 
	
<div class="container">    
	<div class="panel panel-primary col-md-12 boxazul" >
		<div class="panel-heading">
			<div class="row">
				<div class="col-sm-4"><h4>Lista Lançamentos</h4></div>
				<div class="col-sm-4"></div>
				<div class="col-sm-" align="right">
				<a href="novoLancto">
					<button type="button" class="btn btn-primary btn-xs">
						<h6><span class="glyphicon glyphicon-plus-sign"></span> Novo Lancamento</h6>
					</button>
				</a>
				<a href="novoLancto">
					<button type="button" class="btn btn-primary btn-xs">
						<h6><span class="glyphicon glyphicon-share"></span></h6>
					</button>
				</a>
				<a href="novoLancto">
					<button type="button" class="btn btn-primary btn-xs">
						<h6><span class="glyphicon glyphicon-print"></span></h6>
					</button>
					&nbsp
				</a>
				</div>
	        </div>     
        </div>     
	        <div class="panel">
				<div class="table-responsive">
					<table class="table-condensed">
						<tr>
	                        <th><font size="2">#</font></th>
	                        <th><font size="2">Conta</font></th>
	                        <th><font size="2">Categoria</font></th>
	                        <th><font size="2">Sub-Categoria</font></th>
	                        <th><font size="2">Forma Pagto</font></th>
	                        <th><font size="2">Tipo Conta</font></th>
<!-- 	                        <th><font size="2">Data Lancto</font></th> -->
	                        <th><font size="2">Descrição</font></th>
	                        <th><font size="2">Status</font></th>
	                        <th><font size="2">Movimento</font></th>
	                        <th><font size="2">Valor</font></th>
	                        <th><font size="2">Conta Fixa</font></th>
	                        <th><font size="2">Mês Fatura Cartão</font></th>
	                        <th align="center"><font size="2">Ação</font></th>
	                    </tr>
	                   	<tbody>
		                   	<!-- percorre usuarios montando linhas da tabela -->
		                   	<c:forEach var="lancto" items="${lanctos}" varStatus="id">
		                        <tr bgcolor="#${id.count % 2 == 0 ? 'ffffff' : 'F8F8F8'  }">
		                            <td><font size="2">${lancto.idLancamento }</font></td>
		                            <td><font size="2">${lancto.idConta }</font></td>
		                            <td><font size="2">${lancto.idCategoria}</font></td>
		                            <td><font size="2">${lancto.idSubCategoria}</font></td>
		                            <td><font size="2">${lancto.idForma}</font></td>
		                            <td><font size="2">${lancto.tpConta}</font></td>
<!-- 		                            <td align="center"> -->
<!-- 		                            	<font size="2">	 -->
<%-- 		                            		<fmt:formatDate value="${lancto.dtLancamento.time}" pattern="dd/MM/yyyy" /> --%>
<!-- 		                            	</font> -->
<!-- 		                            </td> -->
		                            <td><font size="2">${lancto.dsLancamento}</font></td>
		                            <td><font size="2">${lancto.sgStatus}</font></td>
 		                            <td><font size="2">${lancto.sgMovimento}</font></td>
 		                            <td><font size="2">${lancto.idCategoria}</font></td>
 		                            <td><font size="2">${lancto.icContaFixa}</font></td>
 		                            <td><font size="2">${lancto.dsFaturaCartao}</font></td>
 		                            <td class="actions">
			                            <a href="#">
			                            	<span class="glyphicon glyphicon-eye-open"></span>
										</a>
			                            <a href="mostraLancto?idLancamento=${lancto.idLancamento}">
											<span class="glyphicon glyphicon-pencil" style="color:orange"></span>
										</a>
			                            <a href="excluiLancto?idLancamento=${lancto.idLancamento}">
			                            	<span class="glyphicon glyphicon-remove" style="color:red"></span>
			                            </a>
		                    	    </td>
		                      	</tr>

	                      	</c:forEach>
	                    </tbody>
	                </table>
	                <div class='box-paginacao' align="center">
	                    <a class='box_navegacao' href="#"  title="Primeira Página"> .. </a>
	                    <a class='box_navegacao' href="#"  title="Página Anterior"> . </a>
	                    <a class='box-numero' href="#" > </a>
	
	                    <a class='box_navegacao'  href="#"  title="Próxima Página"> . </a>
	                    <a class='box_navegacao'  href="#"  title="Última Página"> .. </a>
	                </div>
	            </div>
			</div> 
	   	</div>
</div>
<div class="container">
	<div class="row">
	    <div class="col-md-3"></div>	
		<div class="panel col-md-6" >
	     	<a href="abertura" class="btn btn-primary btn-xs">Voltar</a>
		</div>
		<div class="col-md-3"></div>
	</div>
</div>

<c:import url="../include/footer.jsp" />

</body>
</html>