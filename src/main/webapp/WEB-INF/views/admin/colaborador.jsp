<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Colaborador</title>

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

		<h3>Cadastro de Colaborador</h3>
		<p>Informações pessoais:</p>
		<hr />
<br>
		<div class="row">
			<div class="col-md-10 offset-md-1">

				<form id="formcolaborador" method="post" action="cadcolaborador">

					<div class="row text-start mb-2">
						<div class="col-md-4">
							<label>Nome Colaborador:</label> <input type="text" name="colaborador"
								placeholder="Nome" class="form-control" />
						</div>

						<div class="col-md-2">
							<label>Cpf:</label> <input type="text" name="cpf_colaborador" id="cpf_colaborador"
								placeholder="CPF" class="form-control" />
						</div>

						<div class="col-md-2">
							<label>Email:</label> <input type="text"
								name="email_colaborador" placeholder="Email" class="form-control" />
						</div>

						<div class="col-md-2">
							<label>Dt nas.:</label> <input type="text" id="dt_nas_colaborador"
								name="dt_nas_colaborador" id="dt_nas_colaborador" placeholder="Data" class="form-control" />
						</div>

						<div class="col-md-2">
							<label>Registro profissional:</label> <input type="text" name="id_profissional"
								id="id_profissional" placeholder="Registro" class="form-control" />
						</div>

					</div>

					<div class="row text-start mb-2">
						<div class="col-md-2">
							<label>Profissão:</label> <input type="text" name="profissao"
								id="profissao" placeholder="profissão" class="form-control" />
						</div>

						<div class="col-md-2">
							<label>Especialidade:</label> <input type="text"
								name="especialidade" id="especialidade" placeholder="especialidade" class="form-control" />
						</div>

						<div class="col-md-3">
							<label>Disponibilidade:</label> <input type="text" name="disponibilidade"
								placeholder="Disponibilidade" class="form-control" />
						</div>

						<div class="col-md-2">
							<label>Escolaridade:</label> <input type="text"
								name="escolaridade" placeholder="escolaridade" class="form-control" />
						</div>

						<div class="col-md-3">
							<label>Tel. colaborador:</label> <input type="text" id="tel_colaborador"
								name="tel_colaborador" placeholder="tel_colaborador"
								class="form-control" />
						</div>


					</div>

					<div class="row text-start mb-2">
						<div class="col-md-4">
							<label>Endereço:</label> <input type="text"
								name="end_colaborador" id="end_colaborador"
								placeholder="Endereço" class="form-control" />
						</div>

						<div class="col-md-2">
							<label>Cidade:</label> <input type="text" name="cidade_colaborador"
								placeholder="Cidade" class="form-control" />
						</div>

						<div class="col-md-3">
							<label>Cep:</label> <input type="text" name="cep_colaborador"
								placeholder="CEP" class="form-control" />
						</div>

						<div class="col-md-3">
							<label>Data de cadastro:</label> <input type="text" name="dtcadcolab" id="dtcadcolab"
								placeholder="Data" class="form-control" />
						</div>


					</div>

					<div class="row text-start mb-2">
						<label>Anotações:</label> <input type="text" name="notacolaborador"
							placeholder="Anotações" class="form-control" />
					</div>
					<br>
					<br>

					<div class="text-start mb-2"></div>

					<div class="d-grid- mb-2">
						<input type="submit" value="Cadastrar Colaborador"
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
			$("#formcolaborador").validate({
				rules : {
					"colaborador" : {
						required : true
					},
					
					"cpf_colaborador" : {
						required : true
					}
				}

			});
			//aplicar as máscaras dos campos
			$("#tel_colaborador").mask("(99) 99999-9999");
			$("#dt_nas_colaborador").mask("99/99/9999");
			$("#dtcadcolab").mask("99/99/9999");
			$("#cpf_colaborador").mask("999.999.999-99");
		});
	</script>


</body>
</html>