<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edi??o de cliente</title>

<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">

	
<style>
	label.error { color: #d9534f; }
	input.error { border: 2px solid #d9534f; }
</style>

</head>
<body >

	<!-- inserindo o componente navbar -->
	<jsp:include page="/WEB-INF/views/components/navBar.jsp"></jsp:include>

	<div class="container mt-4">
		<h5>Edi??o de cliente</h5>
		<p>Utilize o formul?rio para alterar os dados do cliente.</p>
	</div>
		  <hr />
		  
		  <div class="row">
			<div class="col-md-10 offset-md-1">
         
				<form id="formupcliente" method="post" action="editar-cliente">
					
					<input type="hidden" name="id_cliente" value="${id_cliente}"/>

					<div class="row text-start mb-2">
						<div class="col-md-4">
							<label>Nome Cliente:</label> <input type="text" name="cliente"
								placeholder="Nome" class="form-control" value="${cliente}"/>
						</div>

						<div class="col-md-2">
							<label>Conv?nio:</label> <input type="text" name="convenio"
								placeholder="Conv?nio" class="form-control" value="${convenio}" />
						</div>

						<div class="col-md-2">
							<label>N?mero da Carteira:</label> <input type="text"
								name="n_carteira" placeholder="N?mero" class="form-control" value="${n_carteira}" />
						</div>

						<div class="col-md-2">
							<label>Data de Inclus?o:</label> <input type="text"
								name="dtcadcliente" id="dtcadcliente" placeholder="Data" class="form-control" value="${dtcadcliente}"/>
						</div>

						<div class="col-md-2">
							<label>Tel. Cliente:</label> <input type="tel" name="tel_cliente"
								id="tel_cliente" placeholder="Tel.cliente" class="form-control" value="${tel_cliente}" />
						</div>

					</div>

					<div class="row text-start mb-2">
						<div class="col-md-2">
							<label>CPF:</label> <input type="text" name="cpf_cliente"
								id="cpf_cliente" placeholder="CPF" class="form-control" value="${cpf_cliente}" />
						</div>

						<div class="col-md-2">
							<label>Data de Nascimento:</label> <input type="text"
								name="dt_nas_cliente" id="dt_nas_cliente" placeholder="Data" class="form-control" value="${dt_nas_cliente}" />
						</div>

						<div class="col-md-1">
							<label>Idade:</label> <input type="number" name="idadecliente"
								placeholder="Idade" class="form-control" value="${idadecliente}" />
						</div>

						<div class="col-md-4">
							<label>Email do Cliente:</label> <input type="text"
								name="email_cliente" placeholder="Email" class="form-control" value="${email_cliente}" />
						</div>

						<div class="col-md-3">
							<label>Respons?vel:</label> <input type="text"
								name="resp_cliente" placeholder="Respons?vel"
								class="form-control" value="${resp_cliente}"/>
						</div>
					</div>


					<div class="row text-start mb-2">
						<div class="col-md-2">
							<label>Telefone do Respons?vel:</label> <input type="tel"
								name="tel_resp_cliente" id="tel_resp_cliente"
								placeholder="Tel. Respons?vel" class="form-control" value="${tel_resp_cliente}" />
						</div>

						<div class="col-md-4">
							<label>Endere?o:</label> <input type="text" name="end_cliente"
								placeholder="Endere?o" class="form-control" value="${end_cliente}" />
						</div>

						<div class="col-md-3">
							<label>Cidade:</label> <input type="text" name="cidade_cliente"
								placeholder="Cidade" class="form-control" value="${cidade_cliente}"/>
						</div>

						<div class="col-md-3">
							<label>Cep:</label> <input type="number" name="cep_cliente"
								placeholder="Cep" class="form-control" value="${cep_cliente}" />
						</div>


					</div>

					<div class="row text-start mb-2">
						<label>Anota??es:</label> <input type="text" name="notacliente"
							placeholder="Anota??es" class="form-control" value="${notacliente}" />
					</div>

					<div class="text-start mb-2"></div>

					
					<div class="d-grid- mb-2">
						<input type="submit" value="Atualizar cliente" class="btn btn-primary" />
						<a href="/controle_clinica/admin/consultar-clientes" class="btn btn-secondary">Voltar para a consulta</a>
					</div>
					<!-- inserindo o componente messages -->
					<jsp:include page="/WEB-INF/views/components/messages.jsp"></jsp:include>
		
					
				</form>

			</div>

		</div>


	
			
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

	<!-- JQuery -->
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>

	<!-- JQuery validate -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/additional-methods.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/localization/messages_pt_BR.min.js"></script>

	<!-- JQuery masked input -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.min.js"></script>

	<script>
		$(document).ready(function() {
			$("#formupcliente").validate({
				rules : {
					"cliente" : {
						required : true
					},
					"convenio" : {
						required : true
					},
					"cpf_cliente" : {
						required : true
					}
				}

			});
			//aplicar as m?scaras dos campos
			$("#tel_cliente").mask("(99) 99999-9999");
			$("#tel_resp_cliente").mask("(99) 99999-9999");
			$("#dtcadcliente").mask("99/99/9999");
			$("#dt_nas_cliente").mask("99/99/9999");
			$("#cpf_cliente").mask("999.999.999-99");
		});
	</script>
	
</body>
</html>


