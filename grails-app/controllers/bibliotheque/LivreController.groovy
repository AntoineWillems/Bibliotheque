package bibliotheque

import org.hibernate.Criteria
import org.springframework.dao.DataIntegrityViolationException

class LivreController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
    def index() {
        redirect(action: "list", params: params)
    }


    def list(Integer max) {
        params.max = Math.min(max ?: 5, 100)
	
		def livreList = Livre.createCriteria().list(params){
			
			if ( params.query && params.checkBoxTitre=="on") {
				ilike("titre", "%${params.query}%")
			}
			if ( params.query && params.checkBoxAuteur=="on") {
				auteurs{
					ilike("nom", "%${params.query}%")
				}
			}
			if ( params.query && params.checkBoxTypeDoc=="on") {
				System.out.println("test")
				typedocument{
					ilike("intitule", "%${params.query}%")
				}
			}
		}
		Utilisateur user = Utilisateur.find(session.user)
		Panier p = user.getPanier()
		
		[livreInstanceList: livreList, livreInstanceTotal: livreList.totalCount, panierInstance: p]
		
    }

    def create() {
        [livreInstance: new Livre(params)]
    }

    def save() {
        def livreInstance = new Livre(params)
        if (!livreInstance.save(flush: true)) {
            render(view: "create", model: [livreInstance: livreInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'livre.label', default: 'Livre'), livreInstance.id])
        redirect(action: "show", id: livreInstance.id)
    }

    def show(Long id) {
        def livreInstance = Livre.get(id)
        if (!livreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'livre.label', default: 'Livre'), id])
            redirect(action: "list")
            return
        }

		Utilisateur user = Utilisateur.find(session.user)
		Panier p = user.getPanier()
		
        [livreInstance: livreInstance,  panierInstance: p]
    }




	def commander(Long id){
		def livreInstance = Livre.get(id)
		if (!livreInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'livre.label', default: 'Livre'), id])
			redirect(action: "list")
			return
		}		
		
		Utilisateur user = Utilisateur.find(session.user)
		Panier p = user.getPanier()
		p.addToLivres(livreInstance)
		
		flash.message = message(code: 'default.commander.message', args: [message(code: 'livre.label', default: 'Livre'), id])
		redirect(action: "list")
	}
	
	def commanderPanier(){
		Utilisateur user = Utilisateur.find(session.user)
		Panier p = user.getPanier()
		redirect(controller: "panier", action:"show", id:p.id)
	}
}
