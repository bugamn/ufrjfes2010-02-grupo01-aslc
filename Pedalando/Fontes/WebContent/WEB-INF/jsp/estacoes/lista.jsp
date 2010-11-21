
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Capacidade</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ estacaoList }" var="estacao">
				<tr>
					<td>${ estacao.nome }</td>
					<td>${ estacao.capacidade }</td>
					<td><a href="edita?id=${estacao.id}">Editar</a></td>
					<td><a href="remove?id=${estacao.id}">Remover</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
