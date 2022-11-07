<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de cliente</title>

<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
label.error {
	color: #d9534f;
}

input.error {
	border: 2px solid #d9544f;
}
</style>

</head>

<body>
		<!-- inserindo o componente navbar -->
	<jsp:include page="/WEB-INF/views/components/navBar.jsp"></jsp:include> 
	
	<br>
	<br>
	
	<div class="text-center">

		<h3>Cadastro de Cliente</h3>
		<p>Informações pessoais:</p>
		<hr />
<br>
		<div class="row">
			<div class="col-md-10 offset-md-1">

				<form id="formcliente" method="post" action="cadcliente">

					<div class="row text-start mb-2">
						<div class="col-md-4">
							<label>Nome Cliente:</label> <input type="text" name="cliente"
								placeholder="Nome" class="form-control" />
						</div>

						<div class="col-md-2">
							<label>Convênio:</label> <input type="text" name="convenio"
								placeholder="Convênio" class="form-control" />
						</div>

						<div class="col-md-2">
							<label>Número da Carteira:</label> <input type="text"
								name="n_carteira" placeholder="Número" class="form-control" />
						</div>

						<div class="col-md-2">
							<label>Data de Inclusão:</label> <input type="text"
								name="dtcadcliente" id="dtcadcliente" placeholder="Data" class="form-control" />
						</div>

						<div class="col-md-2">
							<label>Tel. Cliente:</label> <input type="tel" name="tel_cliente"
								id="tel_cliente" placeholder="Tel.cliente" class="form-control" />
						</div>

					</div>

					<div class="row text-start mb-2">
						<div class="col-md-2">
							<label>CPF:</label> <input type="text" name="cpf_cliente"
								id="cpf_cliente" placeholder="CPF" class="form-control" />
						</div>

						<div class="col-md-2">
							<label>Data de Nascimento:</label> <input type="text"
								name="dt_nas_cliente" id="dt_nas_cliente" placeholder="Data" class="form-control" />
						</div>

						<div class="col-md-1">
							<label>Idade:</label> <input type="number" name="idadecliente"
								placeholder="Idade" class="form-control" />
						</div>

						<div class="col-md-4">
							<label>Email do Cliente:</label> <input type="text"
								name="email_cliente" placeholder="Email" class="form-control" />
						</div>

						<div class="col-md-3">
							<label>Responsável:</label> <input type="text"
								name="resp_cliente" placeholder="Responsável"
								class="form-control" />
						</div>


					</div>

					<div class="row text-start mb-2">
						<div class="col-md-2">
							<label>Telefone do Responsável:</label> <input type="tel"
								name="tel_resp_cliente" id="tel_resp_cliente"
								placeholder="Tel. Responsável" class="form-control" />
						</div>

						<div class="col-md-4">
							<label>Endereço:</label> <input type="text" name="end_cliente"
								placeholder="Endereço" class="form-control" />
						</div>

						<div class="col-md-3">
							<label>Cidade:</label> <input type="text" name="cidade_cliente"
								placeholder="Cidade" class="form-control" />
						</div>

						<div class="col-md-3">
							<label>Cep:</label> <input type="number" name="cep_cliente"
								placeholder="Cep" class="form-control" />
						</div>


					</div>

					<div class="row text-start mb-2">
						<label>Anotações:</label> <input type="text" name="notacliente"
							placeholder="Anotações" class="form-control" />
					</div>
					<br>
					<br>

					<div class="text-start mb-2"></div>

					<div class="d-grid- mb-2">
						<input type="submit" value="Cadastrar cliente"
							class="btn btn-primary" />
					</div>

					<div>
						<a href="/controle_clinica/admin/pagina-inicial">Voltar</a>
					</div>

				</form>

			</div>

		</div>
<hr/>

		<div class="text-sucess text-center">
			<strong>${mensagem_sucesso}</strong>
		</div>
		<div class="text-danger text-center">
			<strong>${mensagem_erro}</strong>
		</div>
	</div>
	<!-- inserindo o componente messages -->
	<jsp:include page="/WEB-INF/views/components/messages.jsp"></jsp:include>


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
			$("#formcliente").validate({
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
			//aplicar as máscaras dos campos
			$("#tel_cliente").mask("(99) 99999-9999");
			$("#tel_resp_cliente").mask("(99) 99999-9999");
			$("#dtcadcliente").mask("99/99/9999");
			$("#dt_nas_cliente").mask("99/99/9999");
			$("#cpf_cliente").mask("999.999.999-99");
		});
	</script>


</body>
</html>