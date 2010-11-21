	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>CPF</th>
				<th>Endere�o</th>
				<th>Permiss�o</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ usuarioList }" var="usuario">
				<tr>
					<td>${ usuario.nome }</td>
					<td>${ usuario.cpf }</td>
					<td>${ usuario.endereco }</td>
					<td>${ usuario.permissao }</td>
					<td><a href="edita?cpf=${usuario.cpf}">Editar</a></td>
					<td><a href="remove?cpf=${usuario.cpf}">Remover</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>