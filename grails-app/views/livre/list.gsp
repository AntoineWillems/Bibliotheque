
<%@ page import="bibliotheque.Livre" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'livre.label', default: 'Livre')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-livre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-livre" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="titre" title="${message(code: 'livre.titre.label', default: 'Titre')}" />
					
						<g:sortableColumn property="nombreExemplairesDisponible" title="${message(code: 'livre.nombreExemplairesDisponible.label', default: 'Nombre Exemplaires Disponible')}" />
					
						<g:sortableColumn property="nombreExemplaires" title="${message(code: 'livre.nombreExemplaires.label', default: 'Nombre Exemplaires')}" />
					
					</tr>
				</thead>
				<tbody>
				Recherche <INPUT type=text name="recherche"> 
				<SELECT name="fonction">
					<OPTION VALUE="titre">${message(code: 'livre.titre.label', default: 'Titre')}</OPTION>
					<OPTION VALUE="titre1">${message(code: 'livre.titre.label', default: 'Titre')}</OPTION>
				</SELECT>
				
				
				<g:each in="${livreInstanceList}" status="i" var="livreInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${livreInstance.id}">${fieldValue(bean: livreInstance, field: "titre")}</g:link></td>
					
						<td>${fieldValue(bean: livreInstance, field: "nombreExemplairesDisponible")}</td>
					
						<td>${fieldValue(bean: livreInstance, field: "nombreExemplaires")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${livreInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
