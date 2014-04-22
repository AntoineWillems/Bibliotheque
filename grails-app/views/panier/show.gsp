
<%@ page import="bibliotheque.Panier" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'panier.label', default: 'Panier')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-panier" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-panier" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list panier">
			
				<g:if test="${panierInstance?.livres}">
				<li class="fieldcontain">
					<span id="livres-label" class="property-label"><g:message code="panier.livres.label" default="Livres" /></span>
					
						<g:each in="${panierInstance.livres}" var="l">
						<span class="property-value" aria-labelledby="livres-label"><g:link controller="livre" action="show" id="${l.id}">${l?.titre}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			</ol>
			<input type="text" id="endDate" value="${formatDate(format:'dd/MM/yyyy')}" />
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${panierInstance?.id}" />
					<g:link class="commandePanier" action="commanderPanier" id="${panierInstance?.id}"><g:message code="default.button.commanderPanier.label" default="Reserver livres" /></g:link>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
