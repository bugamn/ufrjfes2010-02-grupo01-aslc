
<form id="buscaForm" action="lista">
    <fieldset>
      <legend>Buscar Usu�rios</legend>
      
      <label for="nome">Nome:</label>
      <input id="nome" type="text" name="nomeBusca"/>
      
      <label for="cpf">CPF:</label>
      <input id="cpf" type="text" name="cpfBusca"/>
      
      <label for="endere�o">Endere�o:</label>
      <input id="endere�o" type="text" name="enderecoBusca"/>
      
      <label for="permissao">Permiss�o:</label>
      <select id="permissao">
      <option value=0>Qualquer</option>
      <option value=1>Administrador</option>
      <option value=2>Operador</option>
      <option value=3>Usu�rio</option>
      </select>
            
      <button type="submit">Enviar</button>
    </fieldset>
  </form>
