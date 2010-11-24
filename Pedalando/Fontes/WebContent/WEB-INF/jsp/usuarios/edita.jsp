<script type="text/javascript">
	function validaCampos() {
		var nome = document.getElementById("nome");
		var endereco = document.getElementById("endereco");
		var msg = "";
		
		if(nome.value == null || nome.value == "")
			msg += "O campo NOME é obrigatório.\n";
		
		if(endereco.value == null || endereco.value == "")
			msg += "O campo ENDEREÇO é obrigatório.";
		
		if(msg != "") {
			alert(msg);
			return false;
		}
		
		return true;
	}
</script>

<form action="altera" onSubmit="javascript:return validaCampos();">
	<fieldset>
		<legend>Editar Usuário</legend>
		<input type="hidden" name="usuario.cpf" value="${usuario.cpf}" />
		
		<label for="nome">Nome:</label>
		<input id="nome" type="text" name="usuario.nome" value="${usuario.nome}"/>
		
		<label for="endereco">Endereço:</label>
		<input id="endereco" type="text" name="usuario.endereco" value="${usuario.endereco}" />
		
		<label for="permissao">Permissão:</label>
		<select id="permissao" name="permissao">
			<option value=1>Administrador</option>
			<option value=2>Operador</option>
			<option value=3>Usuário</option>
		</select>
		
		<button type="submit">Salvar</button>
	</fieldset>
</form>