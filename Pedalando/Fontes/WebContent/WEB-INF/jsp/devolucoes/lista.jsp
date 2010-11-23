	<table>
		<thead>
			<tr>
				<th>Bicicleta</th>
				<th>Origem</th>
				<th>Destino Planejado</th>
				<th>Destino Real</th>
				<th>Usuário</th>
				<th>Partida</th>
				<th>Chegada</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ devolucaoList }" var="devolucao">
				<tr>
					<td>${ devolucao.locacao.bicicleta.placa }</td>
					<td>${ devolucao.locacao.estacao.nome }</td>
					<td>${ devolucao.estacao.nome }</td>
					<td>${ devolucao.locacao.destino.nome }</td>
					<td>${ devolucao.locacao.usuario.nome }</td>
					<td>${ devolucao.locacao.data }</td>
					<td>${ devolucao.data }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>