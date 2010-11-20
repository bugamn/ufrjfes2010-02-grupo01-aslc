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