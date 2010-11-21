	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>CPF</th>
				<th>Endereço</th>
				<th>Permissão</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ reservaList }" var="reserva">
				<tr>
					<td>${ reserva.nome }</td>
					<td>${ reserva.cpf }</td>
					<td>${ reserva.endereco }</td>
					<td>${ reserva.permissao }</td>
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