
  <form id="usuariosForm" action="adiciona">
    <fieldset>
      <legend>Adicionar Usu�rio</legend>
      
      <label for="nome">Nome:</label>
      <input id="nome" type="text" name="usuario.nome"/>
      
      <label for="cpf">CPF:</label>
      <input id="cpf" type="text" name="usuario.cpf"/>
      
      <label for="endere�o">Endere�o:</label>
      <input id="endere�o" type="text" name="usuario.endereco"/>
      
      <label for="permissao">Permiss�o:</label>
      <select id="permissao" name="permissao">
      <option value=1>Administrador</option>
      <option value=2>Operador</option>
      <option value=3>Usu�rio</option>
      </select>
            
      <button type="submit">Salvar</button>
    </fieldset>
  </form>
