<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrapv336.min.css">
    <link rel="stylesheet" type="text/css" href="resources\css\custom.css">

	<title>SMB - Sistema Movimento Bancárioo</title>
</head>
<body>

<%@ include file="../include/header.jsp" %> 
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4 well">

			<form action="alteraSub" method="POST">
				<fieldset>
					<legend>Alterar SubCategoria - ${sub.dsSub }</legend>
					<input type="hidden" name="idSub" value="${sub.idSub }"/>
					    <div class="form-group">
					       <label for="desc">Descrição</label>
							<input type="text" name="dsSub" value="${sub.dsSub}" class="form-control"/>
					      <span class='text-danger'></span>
					    </div>
							<select class="form-control" name="idCategoria">
								<c:forEach var="categoria" items="${cat}" varStatus="id">
									<c:if test="${categoria.idCategoria == sub.idCategoria }">
										<option value="${categoria.idCategoria }" selected >${categoria.dsCategoria }</option>
									</c:if>
									<c:if test="${categoria.idCategoria != sub.idCategoria }">
										<option value="${categoria.idCategoria }">${categoria.dsCategoria }</option>
									</c:if>
		                      	</c:forEach>
							</select>
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