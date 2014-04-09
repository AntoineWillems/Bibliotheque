<%@ page import="bibliotheque.Panier" %>



<div class="fieldcontain ${hasErrors(bean: panierInstance, field: 'livres', 'error')} ">
	<label for="livres">
		<g:message code="panier.livres.label" default="Livres" />
		
	</label>
	<g:select name="livres" from="${bibliotheque.Livre.list()}" multiple="multiple" optionKey="id" size="5" value="${panierInstance?.livres*.id}" class="many-to-many"/>
</div>

