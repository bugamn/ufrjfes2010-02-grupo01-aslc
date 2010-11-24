<script type="text/javascript">
	function validaCampos() {
		var nome = document.getElementById("nome");
		var endereco = document.getElementById("endereco");
		var msg = "";
		
		if(nome.value == null || nome.value == "")
			msg += "O campo NOME � obrigat�rio.\n";
		
		if(endereco.value == null || endereco.value == "")
			msg += "O campo ENDERE�O � obrigat�rio.";
		
		if(msg != "") {
			alert(msg);
			return false;
		}
		
		return true;
	}
</script>

<form action="altera" onSubmit="javascript:return validaCampos();">
	<fieldset>
		<legend>Editar Usu�rio</legend>
		<input type="hidden" name="usuario.cpf" value="${usuario.cpf}" />
		
		<label for="nome">Nome:</label>
		<input id="nome" type="text" name="usuario.nome" value="${usuario.nome}"/>
		
		<label for="endereco">Endere�o:</label>
		<input id="endereco" type="text" name="usuario.endereco" value="${usuario.endereco}" />
		
		<label for="permissao">Permiss�o:</label>
		<select id="permissao" name="permissao">
			<option value=1>Administrador</option>
			<option value=2>Operador</option>
			<option value=3>Usu�rio</option>
		</select>
		
		<button type="submit">Salvar</button>
	</fieldset>
</form>