
<form id="buscaForm" action="lista">
    <fieldset>
      <legend>Buscar Locações</legend>
      
      <label for="origem">Origem:</label>
      <select id="origem" name="origem">
      <option value=".*"></option>
      <c:forEach items="${ estacaoList }" var="estacao">
      <option value="${ estacao.id }">${ estacao.nome }</option>
      </c:forEach>
      </select>
      
      <label for="destino">Destino:</label>
      <select id="destino" name="origem">
      <option value=".*"></option>
      <c:forEach items="${ estacaoList }" var="estacao">
      <option value="${ estacao.id }">${ estacao.nome }</option>
      </c:forEach>
      </select>
      
      <label for="cpf">CPF:</label>
      <input id="cpf" type="text" name="cpf"/>
      
      <label for="placa">Placa:</label>
      <input id="placa" type="text" name="placa"/>
            
      <button type="submit">Buscar</button>
    </fieldset>
  </form>
