<%@ page import="bibliotheque.UtilisateurController; bibliotheque.Livre" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'livre.label', default: 'Livre')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
<a href="#show-livre" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="show-livre" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list livre">
        <g:if test="${livreInstance?.titre}">
            <li class="fieldcontain">
                <span id="titre-label" class="property-label"><g:message code="livre.titre.label" default="Titre" /></span>

                <span class="property-value" aria-labelledby="titre-label"><g:fieldValue bean="${livreInstance}" field="titre"/></span>

            </li>
        </g:if>

        <g:if test="${livreInstance?.nombreExemplairesDisponible}">
            <li class="fieldcontain">
                <span id="nombreExemplairesDisponible-label" class="property-label"><g:message code="livre.nombreExemplairesDisponible.label" default="Nombre Exemplaires Disponible" /></span>

                <span class="property-value" aria-labelledby="nombreExemplairesDisponible-label"><g:fieldValue bean="${livreInstance}" field="nombreExemplairesDisponible"/></span>

            </li>
        </g:if>

        <g:if test="${livreInstance?.nombreExemplaires}">
            <li class="fieldcontain">
                <span id="nombreExemplaires-label" class="property-label"><g:message code="livre.nombreExemplaires.label" default="Nombre Exemplaires" /></span>

                <span class="property-value" aria-labelledby="nombreExemplaires-label"><g:fieldValue bean="${livreInstance}" field="nombreExemplaires"/></span>

            </li>
        </g:if>

        <g:if test="${livreInstance?.auteurs}">
            <li class="fieldcontain">
                <span id="auteurs-label" class="property-label"><g:message code="livre.auteurs.label" default="Auteurs" /></span>

                <g:each in="${livreInstance.auteurs}" var="a">
                    <span class="property-value" aria-labelledby="auteurs-label"><g:link controller="auteur" action="show" id="${a.id}">${a.nom} ${a.prenom}</g:link></span>
                </g:each>

            </li>
        </g:if>


    </ol>
    <g:form>
        <fieldset class="buttons">
            <g:hiddenField name="id" value="${livreInstance?.id}" />
            <g:link class="commande" action="commander" id="${livreInstance?.id}"><g:message code="default.button.commander.label" default="Commander" /></g:link>
        </fieldset>
    </g:form>
</div>
<g:if test="${panierInstance?.livres}">
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
                    <td style="width: 20px"><fieldset class="buttons">
                        <g:hiddenField name="id" value="${livre?.id}" />
                        <g:link class="supprimerLivre" action="supprimerLivreduPanier" id="${livre?.id}"><g:message code="default.button.supprimerLivre.label" default="supprimer" /></g:link>
                    </fieldset></td>
                </tr>
            </g:each>
            </tbody>
        </table>
        <g:form>
            <fieldset class="buttons">
                <g:link class="commandePanier" action="commanderPanier" ><g:message code="default.button.commanderPanier.label" default="Voir son panier" /></g:link>
            </fieldset>
        </g:form>

    </div>
</g:if>
</body>
</html>
