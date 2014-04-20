
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
                <li><g:link class="deconnection" controller="utilisateur" action="logout"><g:message code="Deconnexion" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-livre" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<fieldset class="form">
			    <g:form action="list" method="GET">
			        <div class="fieldcontain">
			            <label for="query">Search :</label>
			            <g:textField name="query" value="${params.query}"/>
			            <g:select name="typeSearch" from="${['Titre', 'Auteur', 'TypeDoc']}" />
			        </div>
			    </g:form>
			</fieldset>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="titre" title="${message(code: 'livre.titre.label', default: 'Titre')}" />
					
						<g:sortableColumn property="nombreExemplairesDisponible" title="${message(code: 'livre.nombreExemplairesDisponible.label', default: 'Nombre Exemplaires Disponible')}" />
					
						<g:sortableColumn property="auteur" title="${message(code: 'auteur.nom.label', default: 'Auteur')}" />
												
						<g:sortableColumn property="typeDoc" title="${message(code: 'livre.typedocument.label', default: 'Type')}" />
						
					</tr>
				</thead>
				<tbody>
			
				<g:each in="${livreInstanceList}" status="i" var="livreInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${livreInstance.id}">${fieldValue(bean: livreInstance, field: "titre")}</g:link></td>
					
						<td>${fieldValue(bean: livreInstance, field: "nombreExemplairesDisponible")}</td>
					
						<g:each in="${livreInstance.auteurs}" var="auteur">
								<td>${fieldValue(bean: auteur, field: "nom")}</td>
						</g:each>
                        <g:each in="${livreInstance.typedocument}" var="typedocument">
                            <td>${fieldValue(bean: typedocument, field: "intitule")}</td>
                        </g:each>
						
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${livreInstanceTotal}" />
			</div>
		</div>
		<div class="affichePanier">
		<table>
				<thead>
					<tr>	
						<g:sortableColumn property="titre" title="${message(code: 'livre.titre.label', default: 'Titre')}" />
						
					</tr>
				</thead>
				<tbody>
			
				<g:each in="${panierInstance.livres}" status="j" var="livre">
					<tr class="${(j % 2) == 0 ? 'even' : 'odd'}">
					
					<td>${fieldValue(bean: livre, field: "titre")}</td>
						
						
					</tr>
				</g:each>
				</tbody>
			</table>
		</div>
		<g:form>
				<fieldset class="buttons">
					 <g:link class="commandePanier" action="commanderPanier" ><g:message code="default.button.commanderPanier.label" default="CommanderPanier" /></g:link>
				</fieldset>
		</g:form>
	</body>
</html>
