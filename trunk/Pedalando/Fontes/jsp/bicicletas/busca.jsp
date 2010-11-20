
<form id="buscaForm" action="lista">
    <fieldset>
      <legend>Buscar Bicicletas</legend>
      
      <label for="placa">Placa:</label>
      <input id="placa" type="text" name="placaBusca"/>
      <label for="tipo">Tipo:</label>
      <input id="tipo" type="text" name="tipoBusca"/>
      <label for="estacao">Estacao:</label>
      <select id="estacao" name="estacaoBusca">
      <option value=".*"></option>
      <c:forEach items="${ estacaoList }" var="estacao">
      <option value="${ estacao.nome }">${ estacao.nome }</option>
      </c:forEach>
      </select>
      
      <button type="submit">Buscar</button>
    </fieldset>
  </form>
