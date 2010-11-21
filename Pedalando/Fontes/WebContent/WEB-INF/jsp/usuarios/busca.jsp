
<form id="buscaForm" action="lista">
    <fieldset>
      <legend>Buscar Usuários</legend>
      
      <label for="nome">Nome:</label>
      <input id="nome" type="text" name="nomeBusca"/>
      
      <label for="cpf">CPF:</label>
      <input id="cpf" type="text" name="cpfBusca"/>
      
      <label for="endereço">Endereço:</label>
      <input id="endereço" type="text" name="enderecoBusca"/>
      
      <label for="permissao">Permissão:</label>
      <select id="permissao">
      <option value=0>Qualquer</option>
      <option value=1>Administrador</option>
      <option value=2>Operador</option>
      <option value=3>Usuário</option>
      </select>
            
      <button type="submit">Enviar</button>
    </fieldset>
  </form>
