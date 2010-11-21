<script type="text/javascript">
function validaCampos() {	
	var tipo = document.getElementById("tipo");
	var estacao = document.getElementById("estacao");
	var msg = "";
		
	if(tipo.value == null || tipo.value == "")
		msg += "O campo TIPO é obrigatório.\n";
	
	if(estacao.length == 0)
		msg += "O campo ESTAÇÃO é obrigatório.";
	
	if(msg != "") {
		alert(msg);
		return false;
	}
	
	return true;
	
}
</script>


<form action="altera" onSubmit="javascript:return validaCampos();">
	<fieldset>
		<legend>Editar Bicicleta</legend>
		<input type="hidden" name="bicicleta.placa" value="${bicicletaVO.placa}" />
		<label for="tipo">Tipo:</label>
		<input id="tipo" type="text" name="bicicleta.tipo" value="${bicicletaVO.tipo}"/>
		<label for="estacao">Estacao:</label>
		<select id="estacao" name="id" >
		      <c:forEach items="${ bicicletaVO.estacoes }" var="estacao">
		      	<c:choose>
		      		<c:when test="${bicicletaVO.estacao.id == estacao.id}">
		      			<option value="${ estacao.id }" selected>${ estacao.nome }</option>
		      		</c:when>	      	
		      		<c:otherwise>
		      			<option value="${ estacao.id }">${ estacao.nome }</option>
		      		</c:otherwise>
		      	</c:choose>
		      </c:forEach>
		</select>
		<button type="submit">Salvar</button>
	</fieldset>
</form>