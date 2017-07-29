<!DOCTYPE html>
<html>
<head>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" charset="utf-8">
    <title>Login</title>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrapv336.min.css">
	<script src="resources/jquery/jquery.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="resources\css\custom.css">
    <style type="text/css">
    #login-alert{
        display: none;
    }

    .margin-top-pq{
        margin-top: 10px;
    }

    .margin-top-md{
        margin-top: 25px;
    }

    .margin-bottom-md{
        margin-bottom: 25px;
    }

    .padding-top-md{
        padding-top: 30px;
    }
    </style>
</head>
<body>

<%@ include file="include/headerLogin.jsp" %> 

<div class="container">    
    <div id="loginbox" class="mainbox col-md-4 col-md-offset-4" >                  
        <div class="panel panel-primary" >
            <div class="panel-heading">
                <div class="panel-title">Login</div>
            </div>     

            <div class="panel-body padding-top-md" >
                <div id="login-alert" class="alert alert-danger col-sm-12">
                    <span class="glyphicon glyphicon-exclamation-sign"></span>
                    <span id="mensagem"></span>
                </div>    

                <form id="login-form" class="form-horizontal" role="form" action="efetuaLogin" method="post">             
                    <div class="input-group margin-bottom-md">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input type="text" class="form-control" id="email" name="login" placeholder="Informe seu Apelido">
                    </div>

                    <div class="input-group margin-bottom-md">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input type="password" class="form-control" id="senha" name="senha" placeholder="Informe sua Senha">
                    </div>           
                    <div class="form-group margin-top-pq">
                        <div class="col-sm-12 controls">
                            <button type="submit" class="btn btn-primary" name="btn-login" id="btn-login">
                              Entrar
                            </button>
                        </div>
                    </div>    
                </form>  

				<script>
					$(document).ready(function(){
						$("#myModal").modal();
					})
				</script>

               <!--  <a data-toggle="modal" href="#myModal">
                   <span class="glyphicon glyphicon-eye-open"></span>
				</a> -->
                
			<%@ include file="modal.jsp" %>
	
            </div>  
        </div>  
    </div>
 </div>

	<%@ include file="include/footer.jsp" %>

	
</body>
</html>
