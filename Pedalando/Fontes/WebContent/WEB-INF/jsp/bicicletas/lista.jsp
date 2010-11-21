	<table>
		<thead>
			<tr>
				<th>Placa</th>
				<th>Tipo</th>
				<th>Estação</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ bicicletaList }" var="bicicleta">
				<tr>
					<td>${ bicicleta.placa }</td>
					<td>${ bicicleta.tipo }</td>
					<td>${ bicicleta.estacao.nome }</td>
					<td><a href="edita?placa=${bicicleta.placa}">Editar</a></td>
					<td><a href="remove?placa=${bicicleta.placa}">Remover</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>