<% String pageName = "Home"; %>

<%@include file="WEB-INF/organismo/head.jsp"%>
<%@include file="WEB-INF/moleculas/nav/menuTop.jsp"%>
<h1 id="ajaxRetorno">Seila</h1>
<a href="decide?pagina=ListaContatoServlet">lista</a>
<form>
<input type="text" name="testeAjax">
</form>
<a>Teste fora do form</a>
<%@include file="WEB-INF/organismo/footer.jsp"%>