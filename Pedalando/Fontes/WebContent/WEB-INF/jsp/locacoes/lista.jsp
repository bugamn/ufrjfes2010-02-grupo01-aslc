	<table>
		<thead>
			<tr>
				<th>Bicicleta</th>
				<th>Origem</th>
				<th>Destino</th>
				<th>Usuário</th>
				<th>Partida</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ locacaoList }" var="locacao">
				<tr>
					<td>${ locacao.bicicleta.placa }</td>
					<td>${ locacao.estacao.nome }</td>
					<td>${ locacao.destino.nome }</td>
					<td>${ locacao.usuario.nome }</td>
					<td>${ locacao.data }</td>
					<c:if test="${locacao.working == true}">
						<td><a href="/Pedalando/devolucoes/formulario?id=${ locacao.id }">Devolução</a></td>
					</c:if>
					<!-- <td><a href="edita?id=${locacao.id}">Editar</a></td> -->
					<!-- <td><a href="remove?id=${locacao.id}">Remover</a></td> -->
				</tr>
			</c:forEach>
		</tbody>
	</table>