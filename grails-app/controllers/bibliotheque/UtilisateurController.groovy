package bibliotheque

import org.springframework.dao.DataIntegrityViolationException

class UtilisateurController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [utilisateurInstanceList: Utilisateur.list(params), utilisateurInstanceTotal: Utilisateur.count()]
    }

    def create() {
        [utilisateurInstance: new Utilisateur(params)]
    }

    def save() {
        def utilisateurInstance = new Utilisateur(params)
        Panier panier = new Panier().save()
        utilisateurInstance.setPanier(panier)
        if (!utilisateurInstance.save(flush: true)) {
            render(view: "create", model: [utilisateurInstance: utilisateurInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'utilisateur.label', default: 'Utilisateur'), utilisateurInstance.id])
        redirect(controller:"livre", action:"list",login:utilisateurInstance.login,password:utilisateurInstance.password)
    }

    def show(Long id) {
        def utilisateurInstance = Utilisateur.get(id)
        if (!utilisateurInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'utilisateur.label', default: 'Utilisateur'), id])
            redirect(action: "list")
            return
        }

        [utilisateurInstance: utilisateurInstance]
    }

    def edit(Long id) {
        def utilisateurInstance = Utilisateur.get(id)
        if (!utilisateurInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'utilisateur.label', default: 'Utilisateur'), id])
            redirect(action: "list")
            return
        }

        [utilisateurInstance: utilisateurInstance]
    }

    def update(Long id, Long version) {
        def utilisateurInstance = Utilisateur.get(id)
        if (!utilisateurInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'utilisateur.label', default: 'Utilisateur'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (utilisateurInstance.version > version) {
                utilisateurInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'utilisateur.label', default: 'Utilisateur')] as Object[],
                        "Another user has updated this Utilisateur while you were editing")
                render(view: "edit", model: [utilisateurInstance: utilisateurInstance])
                return
            }
        }

        utilisateurInstance.properties = params

        if (!utilisateurInstance.save(flush: true)) {
            render(view: "edit", model: [utilisateurInstance: utilisateurInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'utilisateur.label', default: 'Utilisateur'), utilisateurInstance.id])
        redirect(action: "show", id: utilisateurInstance.id)
    }

    def delete(Long id) {
        def utilisateurInstance = Utilisateur.get(id)
        if (!utilisateurInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'utilisateur.label', default: 'Utilisateur'), id])
            redirect(action: "list")
            return
        }

        try {
            utilisateurInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'utilisateur.label', default: 'Utilisateur'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'utilisateur.label', default: 'Utilisateur'), id])
            redirect(action: "show", id: id)
        }
    }

    def login() {
        def utilisateurInstance = new Utilisateur(params)
        if(session.user){
            redirect(controller: "livre", action: "list")
        }
        else {
            if (!utilisateurInstance) {
                redirect(action: "login")
                return
            }
        }
    }

    def authenticate = {
        def user = Utilisateur.findByLoginAndPassword(params.login, params.password)
        if(user){
            session.user = user
            flash.message = "Hello ${user.login}!"
            redirect(controller:"livre", action:"list")
        }else{
            flash.message = "Sorry, ${params.login}. Please try again."
            redirect(controller: "utilisateur",action:"login")
        }
    }

    def logout = {
        flash.message = "Goodbye ${session.user.login}"
        session.user = null
        redirect(controller:"utilisateur", action:"login")
    }
}
