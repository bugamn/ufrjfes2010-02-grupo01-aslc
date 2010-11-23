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
					<td><a href="remove?id=${reserva.id}">Remover</a></td>
					<td><a href="edita?id=${reserva.id}">Editar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>