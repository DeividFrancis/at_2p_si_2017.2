<div id="add" class="modal">
	<div class="modal-content">
		<form class="col s12">
			<div class="row">
				<div class="input-field col s6">
					<input id="idPessoa" type="hidden" name="id" value="null"> <input
						id="first_name" type="text" name="nome" class="validate"
						required="required"> <label for="first_name">Nome</label>
				</div>
				<div class="input-field col s6">
					<input id="last_name" type="text" class="validate"> <label
						for="last_name">Sobrenome</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12">
					<div id="telefone" class="validate telChips"></div>
					<label for="telefone">Telefone</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12">
					<div id="email" class="validate emaChips"></div>
					<label for="email" data-error="Email j� cadastrado">Email</label>
				</div>
			</div>
		</form>
	</div>
	<div class="modal-footer">
		<a href="#limpa"
			class="modal-action modal-close waves-effect waves-green btn-flat red-text "><b>Cancelar</b></a>
	<a id="novoContatao" onclick="contato('add')"
			class="btn waves-effect waves-light disabled">Salvar <i
			class="material-icons right">send</i>
		</a>
	</div>
</div>