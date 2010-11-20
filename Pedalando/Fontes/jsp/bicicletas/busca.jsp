<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="buscaForm" action="lista">"
    <fieldset>
      <legend>Adicionar Produto</legend>
      
      <label for="placa">Placa:</label>
      <input id="placa" type="text" name="placaBusca"/>
      <label for="tipo">Tipo:</label>
      <input id="tipo" type="text" name="tipoBusca"/>
      <label for="estacao">Tipo:</label>
      <input id="estacao" type="text" name="estacaoBusca"/>
      
      <button type="submit">Enviar</button>
    </fieldset>
  </form>
</body>
</html>