/**
 * Responsavel por inciar funcoes ao iniciar a pagina
 */

$(document).ready(function() {
	$('.collapsible').collapsible();

	$('.modal').modal();
	$('.chips .input').mask('(00) 9.0000-0000');

	$('.telChips').material_chip();
	$('.emaChips').material_chip();
});
