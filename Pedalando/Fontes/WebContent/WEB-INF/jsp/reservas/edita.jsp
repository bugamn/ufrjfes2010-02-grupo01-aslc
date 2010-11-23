<form action="altera">
	<fieldset>
		<legend>Editar Reserva</legend>
		
		<label for="origem">Origem:</label>
		<select id="origem" name="origem">
			<c:forEach items="${reservaVO.estacoes}" var="estacao">
				<c:choose>
					<c:when test="${reservaVO.estacao.id == estacao.id}">
						<option value="${estacao.id}" selected>${estacao.nome}</option>
					</c:when>
					<c:otherwise>
						<option value="${estacao.id}">${estacao.nome}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		
		<label for="destino">Destino:</label>
		<select id="destino" name="destino">
			<c:forEach items="${reservaVO.estacoes}" var="estacao">
				<c:choose>
					<c:when test="${reservaVO.destino.id == estacao.id}">
						<option value="${estacao.id}" selected>${estacao.nome}</option>
					</c:when>
					<c:otherwise>
						<option value="${estacao.id}">${estacao.nome}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		
		<label for="cpf">CPF:</label>
		<input type="text" id="cpf" name="cpf" value="${reservaVO.usuario.cpf}"/>
		
		<label for="depois">Data:</label>
		<input id="depois" type="text" name="dia" maxlength="2" size="2" value="${reservaVO.dia}"/>
		/<input type="text" name="mes" maxlength="2" size="2" value="${reservaVO.mes}"/>
		/<input type="text" name="ano" maxlength="4" size="4"/ value="${reservaVO.ano}">
		-<input type="text" name="hora" maxlength="2" size="2"/ value="${reservaVO.hora}">
		:<input type="text" name="minuto" maxlength="2" size="2" value="${reservaVO.minuto}"/>
		
		<button type="submit">Salvar</button>
	</fieldset>
</form>