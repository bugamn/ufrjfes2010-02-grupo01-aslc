<script type="text/javascript">
	function validaCampos() {
		var nome = document.getElementById("nome");
		var cpf = document.getElementById("cpf");
		var endereco = document.getElementById("endereco");
		var msg = "";
		
		if(nome.value == null || nome.value == "")
			msg += "O campo NOME é obrigatório.\n";
		
		if(cpf.value == null || cpf.value == "")
			msg += "O campo CPF é obrigatório.\n";
		
		if(endereco.value == null || endereco.value == "")
			msg += "O campo ENDEREÇO é obrigatório.";
		
		if(msg != "") {
			alert(msg);
			return false;
		}
		
		return true;
	}
</script>

<form id="usuariosForm" action="adiciona" onSubmit="javascript:return validaCampos();">
  <fieldset>
    <legend>Adicionar Usuário</legend>
    
    <label for="nome">Nome:</label>
    <input id="nome" type="text" name="usuario.nome"/>
    
    <label for="cpf">CPF:</label>
    <input id="cpf" type="text" name="usuario.cpf"/>
    
    <label for="endereco">Endereço:</label>
    <input id="endereco" type="text" name="usuario.endereco"/>
    
    <label for="permissao">Permissão:</label>
    <select id="permissao" name="permissao">
    <option value=1>Administrador</option>
    <option value=2>Operador</option>
    <option value=3>Usuário</option>
    </select>
          
    <button type="submit">Salvar</button>
  </fieldset>
</form>
