
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Capacidade</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ estacaoVOList }" var="estacaoVO">
				<tr>
					<td>${ estacaoVO.estacao.nome }</td>
					<td>${ estacaoVO.estacao.capacidade }</td>
				</tr>
				<tr>
					<table>
						<thead>
							<tr>
								<th>Placa</th>
								<th>Tipo</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ estacaoVO.bicicletas }" var="bicicleta">
								<tr>
									<td>${ bicicleta.placa }</td>
									<td>${ bicicleta.tipo }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</tr>
			</c:forEach>
		</tbody>
	</table>
