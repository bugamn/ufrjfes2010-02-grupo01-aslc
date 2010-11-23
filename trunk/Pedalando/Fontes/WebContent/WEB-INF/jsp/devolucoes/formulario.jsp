
<form id="estacoesForm" action="adiciona">
  <fieldset>
    <legend>Devolver Bicicleta</legend>
    
    <input id="idLocacao" type="hidden" value="${ devolucaoVO.locacao.id }"> 
    
    <label for="placa">Placa:</label>
    <input id="placa" type="text" disabled="disabled" value="${ devolucaoVO.locacao.bicicleta.placa }"/>
    
    <label for="placa">Usuário:</label>
    <input id="placa" type="text" disabled="disabled" value="${ devolucaoVO.locacao.usuario.nome }"/>
    
    <label for="estacao">Estacao:</label>
    <select id="estacao" name="idEstacao">
    <c:forEach items="${ devolucaoVO.estacaos }" var="estacao">
    <option value="${ estacao.id }">${ estacao.nome }</option>
    </c:forEach>
    </select>
    
    <button type="submit">Salvar</button>
  </fieldset>
</form>
