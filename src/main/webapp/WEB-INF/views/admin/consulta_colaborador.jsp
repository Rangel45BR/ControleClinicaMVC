<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta Colaborador</title>

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

		<h3>Consulta de Colaborador</h3>
		<p>Informações cadastrais:</p>
		<hr />
		
	<!-- inserindo o componente messages -->
	<jsp:include page="/WEB-INF/views/components/messages.jsp"></jsp:include>	
<br>
	<br>
		<table id="tbl_colaborador" class="table table-sm">
			<thead>
				<tr>
					<th>Nome do Colaborador</th>
					<th>Cpf</th>
					<th>N.Carteira</th>
					<th>Data cadastro</th>
					<th>Telefone</th>
					<th>Profissão</th>
					<th>Disponibilidade</th>
					<th>Especialidade</th>
					<th>Operações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista_colaborador}" var="colaborador">
					<tr>
						<td>${colaborador.colaborador}</td> <!-- 1 -->
						<td>${colaborador.cpf_colaborador}</td> <!-- 2 -->
						<td>${colaborador.id_profissional}</td> <!-- 3 -->
						<td><fmt:formatDate value="${colaborador.dtcadcolab}"
								pattern="dd/MM/yyyy" /></td> <!-- 4 -->
						<td>${colaborador.tel_colaborador}</td> <!-- 5 -->
						<td>${colaborador.profissao}</td> <!-- 6 -->
						<td>${colaborador.disponibilidade}</td> <!-- 7 -->
						<td>${colaborador.escolaridade}</td> <!-- 8 -->
						<td><a href="/controle_clinica/admin/editar-colaborador?id=${colaborador.idcolaborador}" class="btn btn-sm btn-primary">Editar</a> 
							<a href="/controle_clinica/admin/excluir-colaborador?id=${colaborador.idcolaborador}" 
							onclick="return confirm('DESEJA REALMENTE EXCLUIR O CLIENTE ${colaborador.colaborador}?');" 
							class="btn btn-sm btn-danger">Excluir</a>
						</td> <!-- 9 -->
					</tr>


				</c:forEach>

			</tbody>
			<tfoot>
				<tr>
					<td colspan="8">Quantidade de colaborador: ${lista_colaborador.size()}</td>
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
			$('#tbl_colaborador').DataTable({
				language: {
	    			url : "//cdn.datatables.net/plug-ins/1.12.1/i18n/pt-BR.json"
	    		}
			});
		});
	</script>



</body>
</html>