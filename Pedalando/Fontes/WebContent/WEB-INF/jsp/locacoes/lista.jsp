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
					<!-- <td><a href="<c:url value="/produtos/${ produto.id }"/>">Editar</a></td>
					<td>
						<form action="<c:url value="/produtos/${ produto.id }"/>" method="POST">
							<button class="link" name="_method" value="DELETE">Remover</button>
						</form>
					</td> -->
				</tr>
			</c:forEach>
		</tbody>
	</table>