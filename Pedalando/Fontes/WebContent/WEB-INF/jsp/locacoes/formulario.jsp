
  <form id="usuariosForm" action="adiciona">
    <fieldset>
      <legend>Adicionar Loca��o</legend>
      
      <label for="destino">Destino:</label>
      <select id="destino" name="destino">
      <c:forEach items="${ estacaoList }" var="estacao">
      <option value="${ estacao.id }">${ estacao.nome }</option>
      </c:forEach>
      </select><br>
      
      <label for="cpf">CPF:</label>
      <input id="cpf" type="text" name="cpf"/>
      
      <label for="placa">Placa:</label>
      <input id="placa" type="text" name="placa"/>
            
      <button type="submit">Salvar</button>
    </fieldset>
  </form>
