<form action="altera">
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