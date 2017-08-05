<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
   	<meta content="width=device-width, initial-scale=1.0" name="viewport" charset="utf-8">
    <title>SMB - Sistema Movimento Bancário</title>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrapv336.min.css">
    <link rel="stylesheet" href="resources/css/estilo.css">
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="resources/jquery/jquery.min.js"></script>
</head>
<body>  

	<c:import url="../include/header.jsp" />

<div class="container">   
	<div class="col-md-3"></div>
	<div class="panel panel-primary col-md-6 boxazul" >
		<div class="panel-heading">
			<div class="row">
				<div class="col-sm-4"><h4>Lista SubCategoria</h4></div>
				<div class="col-sm-4"></div>
				<div class="col-sm-" align="right">
				<a href="novaSub">
					<button type="button" class="btn btn-primary btn-xs">
						<h6><span class="glyphicon glyphicon-plus-sign"></span> Nova Sub</h6>
					</button>
				</a>
				<a href="novaSub">
					<button type="button" class="btn btn-primary btn-xs">
						<h6><span class="glyphicon glyphicon-share"></span></h6>
					</button>
				</a>
				<a href="novaSub">
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
                        <th><font size="2">Descrição</font></th>
                        <th><font size="2">Categoria</font></th>
                        <th><font size="2">ID_User</font></th>
                        <th><font size="2">Ação</font></th>
                    </tr>
                   	<tbody>
						<!-- percorre categoria montando linhas da tabela -->
		                   	<c:forEach var="sub" items="${sub}" varStatus="id">
		                        <tr bgcolor="#${id.count % 2 == 0 ? 'ffffff' : 'F8F8F8'  }">
		                            <td><font size="2">${sub.idSub }</font></td>
		                            <td><font size="2">${sub.dsSub }</font></td>
		                            <td><font size="2">
		                            	<c:forEach items="${cat}" var="cat">
			                            	<c:if test="${cat.idCategoria == sub.idCategoria }">
				                            	<c:out value="${cat}"></c:out>
			                            	</c:if>
		                            	</c:forEach>
		                            	</font>
		                            </td>
		                            <td><font size="2">${sub.idUser }</font></td>
		                            	
		                            <td class="actions">
		                            <a href="#">
		                            	<span class="glyphicon glyphicon-eye-open"></span>
									</a>
		                            <a href="mostraSub?idSub=${sub.idSub}">
										<span class="glyphicon glyphicon-pencil" id="mostraSub" style="color:orange"></span>
									</a>
		                            <a href="excluiSub?idSub=${sub.idSub}">
		                            	<span class="glyphicon glyphicon-remove" style="color:red"></span>
		                            </a>
		                    	    </td>
		                      	</tr>

	                      	</c:forEach>
                    </tbody>
                </table>
                </div>
                <div class='box-paginacao' align="center">
                    <a class='box_navegacao' href="#"  title="Primeira Página"> .. </a>
                    <a class='box_navegacao' href="#"  title="Página Anterior"> . </a>
                    <a class='box-numero' href="#" > </a>

                    <a class='box_navegacao'  href="#"  title="Próxima Página"> . </a>
                    <a class='box_navegacao'  href="#"  title="Última Página"> .. </a>
                </div>
            </div>
 		</div> 
   	<div class="col-md-3"></div>
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


