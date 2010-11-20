
  <form id="estacoesForm" action="adiciona">
    <fieldset>
      <legend>Adicionar Bicicleta</legend>
      
      <label for="placa">Placa:</label>
      <input id="placa" type="text" name="bicicleta.placa"/>
      
      <label for="tipo">Tipo:</label>
      <input id="tipo" type="text" name="bicicleta.tipo"/>
      
      <label for="estacao">Estacao:</label>
      <select id="estacao" name="id">
      <c:forEach items="${ estacaoList }" var="estacao">
      <option value="${ estacao.id }">${ estacao.nome }</option>
      </c:forEach>
      </select>
      
      <button type="submit">Enviar</button>
    </fieldset>
  </form>
