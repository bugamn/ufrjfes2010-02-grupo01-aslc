
<form id="buscaForm" action="lista">
    <fieldset>
      <legend>Buscar Locações</legend>
      
      <label for="origem">Origem:</label>
      <input id="origem" type="text" name="estacaoBusca"/>
      
      <label for="destino">Destino:</label>
      <input id="destino" type="text" name="destinoBusca"/>
      <!-- 
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
       -->
      
      <label for="cpf">CPF:</label>
      <input id="cpf" type="text" name="cpfBusca"/>
      
      <label for="placa">Placa:</label>
      <input id="placa" type="text" name="placaBusca"/>
      
      <label for="antes">Data mínima:</label>
      <input id="antes" type="text" name="diaAntes" maxlength="2" size="2"/>
      /<input type="text" name="mesAntes" maxlength="2" size="2"/>
      /<input type="text" name="anoAntes" maxlength="4" size="4"/>
      
      <label for="depois">Data máxima:</label>
      <input id="depois" type="text" name="diaDepois" maxlength="2" size="2"/>
      /<input type="text" name="mesDepois" maxlength="2" size="2"/>
      /<input type="text" name="anoDepois" maxlength="4" size="4"/>
            
      <button type="submit">Buscar</button>
    </fieldset>
  </form>
