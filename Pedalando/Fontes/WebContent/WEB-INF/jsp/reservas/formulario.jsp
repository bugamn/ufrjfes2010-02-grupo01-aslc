
  <form id="usuariosForm" action="adiciona">
    <fieldset>
      <legend>Adicionar Reserva</legend>
      
      <label for="origem">Origem:</label>
      <select id="origem" name="origem">
      <c:forEach items="${ estacaoList }" var="estacao">
      <option value="${ estacao.id }">${ estacao.nome }</option>
      </c:forEach>
      </select>
      
      <label for="destino">Destino:</label>
      <select id="destino" name="destino">
      <c:forEach items="${ estacaoList }" var="estacao">
      <option value="${ estacao.id }">${ estacao.nome }</option>
      </c:forEach>
      </select>
      
      <label for="cpf">CPF:</label>
      <input id="cpf" type="text" name="cpf"/>
      
      <label for="depois">Data:</label>
      <input id="depois" type="text" name="dia" maxlength="2" size="2"/>
      /<input type="text" name="mes" maxlength="2" size="2"/>
      /<input type="text" name="ano" maxlength="4" size="4"/>
      -<input type="text" name="hora" maxlength="2" size="2"/>
      :<input type="text" name="minuto" maxlength="2" size="2"/>
                  
      <button type="submit">Salvar</button>
    </fieldset>
  </form>
