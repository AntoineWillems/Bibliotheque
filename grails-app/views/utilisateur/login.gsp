<%--
  Created by IntelliJ IDEA.
  User: Gassama
  Date: 17/04/2014
  Time: 22:30
--%>


<%@ page import="bibliotheque.Livre" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'livre.label', default: 'Livre')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<g:form action="" style="padding-left:200px">
    <div style="width: 220px">
        <fieldset>
            <label for="pseudo" class="float">Pseudo :</label> <input type="text" name="pseudo" id="pseudo" size="30" /> <br />
            <label for="mdp" class="float">Mot de passe :</label> <input type="password" name="mdp" id="mdp" size="30" /><br />
            <div class="center"><input type="submit" value="Login" /></div>
        </fieldset>
    </div>
</g:form>
</body>
</html>