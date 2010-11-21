<form action="altera">
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