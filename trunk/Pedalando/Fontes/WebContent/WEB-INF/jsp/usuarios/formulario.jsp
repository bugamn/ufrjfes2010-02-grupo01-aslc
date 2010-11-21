
  <form id="usuariosForm" action="adiciona">
    <fieldset>
      <legend>Adicionar Usuário</legend>
      
      <label for="nome">Nome:</label>
      <input id="nome" type="text" name="usuario.nome"/>
      
      <label for="cpf">CPF:</label>
      <input id="cpf" type="text" name="usuario.cpf"/>
      
      <label for="endereço">Endereço:</label>
      <input id="endereço" type="text" name="usuario.endereco"/>
      
      <label for="permissao">Permissão:</label>
      <select id="permissao" name="permissao">
      <option value=1>Administrador</option>
      <option value=2>Operador</option>
      <option value=3>Usuário</option>
      </select>
            
      <button type="submit">Salvar</button>
    </fieldset>
  </form>
