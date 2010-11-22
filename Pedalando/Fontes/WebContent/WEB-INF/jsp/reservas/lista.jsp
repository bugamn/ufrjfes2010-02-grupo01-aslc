	<table>
		<thead>
			<tr>
				<th>Origem</th>
				<th>Destino</th>
				<th>CPF</th>
				<th>Data</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ reservaList }" var="reserva">
				<tr>
					<td>${ reserva.estacao.nome }</td>
					<td>${ reserva.destino.nome }</td>
					<td>${ reserva.usuario.cpf }</td>
					<td>${ reserva.data }</td>
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