<script type="text/javascript">
	function validaCampos() {
		var nome = document.getElementById("nome");
		var capacidade = document.getElementById("capacidade");
		var msg = "";
		
		if(nome.value == null || nome.value == "")
			msg += "O campo NOME é obrigatório.\n";
		
		if(capacidade.value == null || capacidade.value == "")
			msg += "O campo CAPACIDADE é orbigatório.";
		
		if(msg != "") {
			alert(msg);
			return false;
		}
		
		return true;
	}
</script>

<form action="altera" onSubmit="javascript:return validaCampos();">
	<fieldset>
		<legend>Editar Estação</legend>
		<input type="hidden" name="estacao.id" value="${estacao.id }" />
		
		<label for="nome">Nome:</label>
		<input id="nome" type="text" name="estacao.nome" value="${estacao.nome }"/>
		
		<label for="capacidade">Capacidade:</label>
		<input id="capacidade" type="text" name="estacao.capacidade" value="${estacao.capacidade }"/>
		
		<button type="submit">Salvar</button>
	</fieldset>
</form>