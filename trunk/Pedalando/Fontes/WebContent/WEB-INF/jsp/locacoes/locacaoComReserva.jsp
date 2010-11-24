<script type="text/javascript">
	function validaCampos() {
		var bicicletas = document.getElementById("placa");
		
		if(bicicletas.length == 0) {
			alert("Não existem bicicletas disponíveis!");
			return false;
		}
		
		return true;
	}
</script>

<form id="locacaoComReservaForm" action="salvaLocacaoComReserva" onSubmit="javascript:return validaCampos();">
	<fieldset>
		<legend>Selecione a Bicicleta:</legend>
		<input type="hidden" name="id" value="${bicicletaVO.reserva}"/>
		
		<label for="placa">Bicicletas:</label>
		<select id="placa" name="placa">
			<c:forEach items="${bicicletaVO.bicicletas}" var="bicicleta">
				<option value="${bicicleta.placa}">${bicicleta.placa}</option>			
			</c:forEach>
		</select>
		
		<button type="submit">Enviar</button>
	</fieldset>
</form>