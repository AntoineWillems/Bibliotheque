package bibliotheque

import org.springframework.dao.DataIntegrityViolationException

class PanierController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
		if (!session.user) {
			redirect(controller: "utilisateur", action: "login")
		} else {
	        params.max = Math.min(max ?: 10, 100)
	        [panierInstanceList: Panier.list(params), panierInstanceTotal: Panier.count()]
		}
    }

    def create() {
        [panierInstance: new Panier(params)]
    }

    def save() {
        def panierInstance = new Panier(params)
        if (!panierInstance.save(flush: true)) {
            render(view: "create", model: [panierInstance: panierInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'panier.label', default: 'Panier'), panierInstance.id])
        redirect(action: "show", id: panierInstance.id)
    }

    def show(Long id) {
		if (!session.user) {
			redirect(controller: "utilisateur", action: "login")
		} else {
	        def panierInstance = Panier.get(id)
			
			if(params.erreur){
				flash.message = params.erreur
			}
	        if (!panierInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'panier.label', default: 'Panier'), id])
	            redirect(action: "list")
	            return
	        }
	
	        [panierInstance: panierInstance]
		}
    }

    def edit(Long id) {
        def panierInstance = Panier.get(id)
        if (!panierInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'panier.label', default: 'Panier'), id])
            redirect(action: "list")
            return
        }

        [panierInstance: panierInstance]
    }

    def update(Long id, Long version) {
        def panierInstance = Panier.get(id)
        if (!panierInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'panier.label', default: 'Panier'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (panierInstance.version > version) {
                panierInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'panier.label', default: 'Panier')] as Object[],
                          "Another user has updated this Panier while you were editing")
                render(view: "edit", model: [panierInstance: panierInstance])
                return
            }
        }

        panierInstance.properties = params

        if (!panierInstance.save(flush: true)) {
            render(view: "edit", model: [panierInstance: panierInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'panier.label', default: 'Panier'), panierInstance.id])
        redirect(action: "show", id: panierInstance.id)
    }

    def delete(Long id) {
        def panierInstance = Panier.get(id)
        if (!panierInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'panier.label', default: 'Panier'), id])
            redirect(action: "list")
            return
        }

        try {
            panierInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'panier.label', default: 'Panier'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'panier.label', default: 'Panier'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def commanderPanier(Long id){
		def panierInstance = Panier.get(id)
		def livreList = panierInstance.getLivres()
		def dateCourante = new Date().next()
        def cod = dateCourante.format('dd/MM/yy')+""+panierInstance.getId()
        def reserv = new Reservation(code: cod.encodeAsMD5(), dateReservation:dateCourante.format('dd/MM/yy')).save()
		
		def newListLivre = []
		
		
		livreList.each { livre ->
			if(livre.getNombreExemplairesDisponible()!=0){
				livre.nombreExemplairesDisponible=livre.nombreExemplairesDisponible-1
				newListLivre.add(livre)
				
			}
			reserv.addToLivres(livre)
		}
		
		if(newListLivre.size() != livreList.size()){
			panierInstance.livres = newListLivre
			def livreList1 = panierInstance.getLivres()
			livreList1.each { livre ->
					livre.nombreExemplairesDisponible=livre.nombreExemplairesDisponible+1
					
			}
			redirect(action:"show", id:panierInstance.id, params:[erreur:"Des livres n'etaient plus disponible, ils ont ete supprime"])
			return
		}
		
		panierInstance.setLivres(null)
		Utilisateur user = Utilisateur.find(session.user)
		user.addToReservations(reserv)
		
		redirect(controller: "livre", action:"list", params:[commandeValide:"Votre livre sera disponible le "+ new Date().next().format('dd/MM/yy')+" Le code la réservation est :"+reserv.code])
	}
	
}

