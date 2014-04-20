
<%@ page import="bibliotheque.Utilisateur" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'utilisateur.label', default: 'Utilisateur')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-utilisateur" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-utilisateur" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list utilisateur">
			
				<g:if test="${utilisateurInstance?.login}">
				<li class="fieldcontain">
					<span id="login-label" class="property-label"><g:message code="utilisateur.login.label" default="Login" /></span>
					
						<span class="property-value" aria-labelledby="login-label"><g:fieldValue bean="${utilisateurInstance}" field="login"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${utilisateurInstance?.mail}">
				<li class="fieldcontain">
					<span id="mail-label" class="property-label"><g:message code="utilisateur.mail.label" default="Mail" /></span>
					
						<span class="property-value" aria-labelledby="mail-label"><g:fieldValue bean="${utilisateurInstance}" field="mail"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${utilisateurInstance?.panier}">
				<li class="fieldcontain">
					<span id="panier-label" class="property-label"><g:message code="utilisateur.panier.label" default="Panier" /></span>
					
						<span class="property-value" aria-labelledby="panier-label"><g:link controller="panier" action="show" id="${utilisateurInstance?.panier?.id}">${utilisateurInstance?.panier?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${utilisateurInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="utilisateur.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${utilisateurInstance}" field="password"/></span>
					
				</li>
				</g:if>
				
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${utilisateurInstance?.id}" />
					<g:link class="edit" action="edit" id="${utilisateurInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
