/**
 *
 */
$(document).ready(function() {

	validaEmail();
});

function atualiza() {
	// Old value
	let contato = $(".contato.active");
	let id = contato.find("#idPessoa").text();
	let oldName = contato.find("#nomeTxt");
	let oldLastName = contato.find("#last_name");
	let oldTelList = contato.find("#telefoneTxt");
	let oldEmaList = contato.find("#emailTxt");

	// modal atualiza
let up = $('#up');
let onde = up.find("#idPessoa").text(id);
let setNome = up.find("#first_name").val(oldName.text());

//Parece simples mas deu uma dorsinha de cabeça
let setTel = up.find(".telChips");
inserirChipsParaAtualizar(setTel,oldTelList);

let setEma = up.find('.emaChips');
inserirChipsParaAtualizar(setEma,oldEmaList);

} // Fim da function Atualiza




// Deleta AJAX
function deleta(id, nome) {
	$.get('contato/remover', {
		idPessoa : id,
		nome : nome
	}, function(result) {
		console.log(nome + " Removido");
		$(".contato.active").addClass('hide');
		showModal(result);
	});

}

// Novo Contato ajax
function contato(condicao) {
	console.log(condicao);
	// tem que ser igual alguma coisa entre o servler e o id do modal
	let c = $("#"+condicao);
	let gugu = c.find("#idPessoa").text();
	let nome = c.find('#first_name').val() + ' ' + $('#last_name').val();
	let telList = c.find('.telChips').material_chip('data').map(function(item) {
		return item.tag;
	});
	let telStr = telList.toString();

	let emaList = c.find('.emaChips').material_chip('data').map(function(item) {
		return item.tag;
	});
	let emaStr = emaList.toString();

	// AJAX
	let servlet = condicao +"/contato";
$.get(servlet, {

		idPessoa : gugu,
		nome : nome,
		telefone : telStr,
		email : emaStr

	}, function(result) {
		console.log(result);
		if (result == 'true') {
			$('#add').modal('close');
			showModal(nome + " salvo na agenda!");
			 updadeList();
		} else {
			showModal("Erro ao salvar!");
		}
	});

}
// valida Contato
function validaEmail() {
	$('.emaChips').on('chip.add', function(e, chip) {

		$.get("validaEmail", {
			// json
			email : chip.tag
		}, function(result) {
			// Destaca em vermelho o email existente
			if (result == 'true') {
				let teste = $(e.target).find("div").last();
				teste.addClass('red white-text invalid');
				$("#novoContatao").addClass('disabled');
			}else{
				$("#novoContatao").removeClass('disabled');
			}
		})

	});
}
// atualiza pagina
function updadeList() {
	 location.reload();
}
// limpa os inputs
function inputClear() {
	console.log("inputClear");
	Materialize.updateTextFields();
	$(':input').val('');
}
function showModal(result) {
	Materialize.toast(result, 4000);
}

/*
É responsavel de pegar uma lista de valores e inserir chips no input
 1 ---> referencia do pai dos Chips iniciado para add Chips
 2 ---> referencia de uma lista onde ira pegar os txt e transforma em chips
 # passar parametros em String que a funcao converte para obj jquery
*/
function inserirChipsParaAtualizar(classeChip,arrayId) {
	// percorre todos elementos e passa para um array
	values = [];
	arrayId.each(function(index, el) {
		values.push({tag: $(el).text()});
	});
	$(classeChip).material_chip({data: values});
}
