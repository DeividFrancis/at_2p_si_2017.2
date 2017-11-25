
<%@include file="../organismo/head.jsp"%>
<div class="tela-celular">
	<header>
		<%@include file="../moleculas/nav/menuTop.jsp"%></header>
	<div class="">
		<div class="ag-wd">
			<ul class="collapsible popout" data-collapsible="accordion">
				<c:forEach var="contato" items="${contatos}">
					<li class="contato">
						<div class="collapsible-header">
							<img style="width: 50px; height: 50px" src="images/gugu.jpg"
								alt="" class="circle responsive-img cal s2">
							<h5>
							<span id="idPessoa" class="hide">${contato.pessoa.id}</span>
								<span id="nomeTxt">${contato.pessoa.nome }</span>
							</h5>
						</div>
						<div class="collapsible-body row">
							<div class="posicao-botao" style="position: relative">
								<a	onclick="atualiza()"
									class="myBtnEdit waves-effect waves-light modal-trigger btn-floating  waves-light"
									href="#up"><i class="material-icons">create</i></a> <a
									id="remover"
									class="myBtnDelete waves-effect waves-light btn-floating red waves-light"
									href="#delete"
									onclick="deleta(${contato.pessoa.id},'${contato.pessoa.nome}')"><i
									class="material-icons">close</i></a>
							</div>
							<ul class="collection with-header bold col s6">
								<li class="collection-header">Telefone</li>
								<c:forEach var="telefone" items="${contato.telefoneList}">
									<li id="telefoneTxt"
										class="collection-item blue-text text-darken-2">${telefone.numero}</li>
								</c:forEach>
							</ul>
							<ul class="collection with-header col s6">
								<li class="collection-header">Email</li>
								<c:forEach var="endereco" items="${contato.emailList}">
									<li id="emailTxt"
										class="collection-item blue-text text-darken-2">${endereco.email}</li>
								</c:forEach>
							</ul>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="fixed-action-btn ">
			<a onclick="inputClear()"
				class="waves-effect waves-light modal-trigger btn-floating btn-large waves-light red right"
				href="#add"><i class="material-icons">person_add</i></a>
		</div>

		<!-- Modal Structure add Contato -->

		<c:import url="../moleculas/form/addContato.jsp"></c:import>
		<c:import url="../moleculas/form/upContato.jsp"></c:import>
	</div>
	<%@include file="../organismo/footer.jsp"%>
</div>