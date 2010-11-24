<form id="locacaoComReservaForm" action="salvaLocacaoComReserva">
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