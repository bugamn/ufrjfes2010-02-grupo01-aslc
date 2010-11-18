<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form id="estacoesForm" action="adiciona">"
    <fieldset>
      <legend>Adicionar Produto</legend>
      
      <label for="nome">Nome:</label>
      <input id="nome" type="text" name="estacao.nome"/>
      
      <label for="descricao">Capacidade</label>
      <input id="capacidade" type="text" name="estacao.capacidade"/>
      
      <button type="submit">Enviar</button>
    </fieldset>
  </form>
</body>
</html>