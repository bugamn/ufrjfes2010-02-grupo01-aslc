
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
