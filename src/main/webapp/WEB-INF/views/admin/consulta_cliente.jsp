<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta de clientes</title>

<!-- CSS only -->
<link href="//cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	  rel="stylesheet">

	  
<link href="//cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css"
	  rel="stylesheet">
<link href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css"
	  rel="stylesheet" >


</head>

<body>

	<!-- inserindo o componente navbar -->
	<jsp:include page="/WEB-INF/views/components/navBar.jsp"></jsp:include>

	<br>	

	<div class="container mt-4 mb-5">

		<h3>Consulta de Clientes</h3>
		<p>Informações cadastrais:</p>
		<hr />
		
	<!-- inserindo o componente messages -->
	<jsp:include page="/WEB-INF/views/components/messages.jsp"></jsp:include>	
<br>
	<br>
		<table id="tbl_clientes" class="table table-sm">
			<thead>
				<tr>
					<th>Nome do Cliente</th>
					<th>Convênio</th>
					<th>N.Carteira</th>
					<th>Data cadastro</th>
					<th>Telefone</th>
					<th>Cpf</th>
					<th>Idade</th>
					<th>Responsável</th>
					<th>Operações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista_cliente}" var="cliente">
					<tr>
						<td>${cliente.cliente}</td> <!-- 1 -->
						<td>${cliente.convenio}</td> <!-- 2 -->
						<td>${cliente.n_carteira}</td> <!-- 3 -->
						<td><fmt:formatDate value="${cliente.dtcadcliente}"
								pattern="dd/MM/yyyy" /></td> <!-- 4 -->
						<td>${cliente.tel_cliente}</td> <!-- 5 -->
						<td>${cliente.cpf_cliente}</td> <!-- 6 -->
						<td>${cliente.idadecliente}</td> <!-- 7 -->
						<td>${cliente.resp_cliente}</td> <!-- 8 -->
						<td><a href="/controle_clinica/admin/editar-cliente?id=${cliente.id_cliente}" class="btn btn-sm btn-primary">Editar</a> 
							<a href="/controle_clinica/admin/excluir-cliente?id=${cliente.id_cliente}" 
							onclick="return confirm('DESEJA REALMENTE EXCLUIR O CLIENTE ${cliente.cliente}?');" 
							class="btn btn-sm btn-danger">Excluir</a>
						</td> <!-- 9 -->
					</tr>


				</c:forEach>

			</tbody>
			<tfoot>
				<tr>
					<td colspan="8">Quantidade de Cliente: ${lista_cliente.size()}</td>
				</tr>


			</tfoot>


		</table>


	</div>

	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

	<!-- JQuery -->
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>

	<!-- JQuery DataTables  -->
	<script src="//code.jquery.com/jquery-3.5.1.js"></script>
	<script src="//cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script src="//cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>

	<script>
		$(document).ready(function() {
			$('#tbl_clientes').DataTable({
				language: {
	    			url : "//cdn.datatables.net/plug-ins/1.12.1/i18n/pt-BR.json"
	    		}
			});
		});
	</script>



</body>
</html>