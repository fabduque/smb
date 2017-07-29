				<!--  MOdal -->
				<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Modal Header</h4>
					</div>
					<div class="modal-body">
			<form action="alteraCategoria" method="POST">
				<fieldset>
					<legend>Alterar Categoria - ${categoria.dsCategoria }</legend>
					<input type="hidden" name="idCategoria" value="${categoria.idCategoria }"/>
					    <div class="form-group">
					       <label for="desc">Descrição</label>
							<input type="text" name="dsCategoria" value="${categoria.dsCategoria }" class="form-control"/>
					      <span class='text-danger'></span>
					    </div>
					    <div class="radio">
					      <label><input type="radio" name="icDebCred" value="D"> Débito</label>
					    </div>
					    <div class="radio">
					      <label><input type="radio" name="icDebCred" value="C"> Crédito</label>
					     </div>
					    <div class="form-group">
					    	<input type="submit" value="Alterar" class="btn btn-primary" />
					     </div>

				   </fieldset>
				</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
				</div>
				</div>