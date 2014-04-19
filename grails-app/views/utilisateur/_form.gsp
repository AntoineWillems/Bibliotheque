<%@ page import="bibliotheque.Utilisateur" %>


<div class="fieldcontain ${hasErrors(bean: utilisateurInstance, field: 'login', 'error')} ">
	<label for="login">
		<g:message code="utilisateur.login.label" default="Login" />
		
	</label>
	<g:textField name="login" value="${utilisateurInstance?.login}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: utilisateurInstance, field: 'mail', 'error')} ">
	<label for="mail">
		<g:message code="utilisateur.mail.label" default="Mail" />
		
	</label>
	<g:textField name="mail" value="${utilisateurInstance?.mail}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: utilisateurInstance, field: 'panier', 'error')} required">
	<label for="panier">
		<g:message code="utilisateur.panier.label" default="Panier" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="panier" name="panier.id" from="${bibliotheque.Panier.list()}" optionKey="id" required="" value="${utilisateurInstance?.panier?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: utilisateurInstance, field: 'password', 'error')} ">
	<label for="password">
		<g:message code="utilisateur.password.label" default="Password" />
		
	</label>
   <input type="password" name="password" value="${utilisateurInstance?.password}">
</div>


