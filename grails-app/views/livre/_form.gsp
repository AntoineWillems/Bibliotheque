<%@ page import="bibliotheque.Livre" %>



<div class="fieldcontain ${hasErrors(bean: livreInstance, field: 'titre', 'error')} required">
	<label for="titre">
		<g:message code="livre.titre.label" default="Titre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titre" required="" value="${livreInstance?.titre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: livreInstance, field: 'nombreExemplairesDisponible', 'error')} required">
	<label for="nombreExemplairesDisponible">
		<g:message code="livre.nombreExemplairesDisponible.label" default="Nombre Exemplaires Disponible" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="nombreExemplairesDisponible" type="number" min="0" value="${livreInstance.nombreExemplairesDisponible}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: livreInstance, field: 'nombreExemplaires', 'error')} required">
	<label for="nombreExemplaires">
		<g:message code="livre.nombreExemplaires.label" default="Nombre Exemplaires" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="nombreExemplaires" type="number" min="0" value="${livreInstance.nombreExemplaires}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: livreInstance, field: 'auteurs', 'error')} ">
	<label for="auteurs">
		<g:message code="livre.auteurs.label" default="Auteurs" />
		
	</label>
	
</div>

<div class="fieldcontain ${hasErrors(bean: livreInstance, field: 'reservations', 'error')} ">
	<label for="reservations">
		<g:message code="livre.reservations.label" default="Reservations" />
		
	</label>
	
</div>

