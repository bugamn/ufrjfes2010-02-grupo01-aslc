<!-- Consertamos a valida��o, n�o � mais necess�rio -->
<script type="text/javascript">
function validaCampos() {
	var placa = document.getElementById("placa");
	var tipo = document.getElementById("tipo");
	var estacao = document.getElementById("estacao");
	var msg = "";
	
	if(placa.value == null || placa.value == "")
		msg += "O campo PLACA � obrigat�rio.\n";
	
	if(tipo.value == null || tipo.value == "")
		msg += "O campo TIPO � obrigat�rio.\n";
	
	if(estacao.length == 0)
		msg += "O campo ESTA��O � obrigat�rio.";
	
	if(msg != "") {
		alert(msg);
		return false;
	}
	
	return true;
	
}
</script>


<form id="estacoesForm" action="adiciona" onSubmit="javascript:return validaCampos();">
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
    
    <button type="submit">Salvar</button>
  </fieldset>
</form>
