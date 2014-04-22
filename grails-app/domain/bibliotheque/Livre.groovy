package bibliotheque

class Livre {

    String titre
    int nombreExemplaires
    int nombreExemplairesDisponible
    static hasMany = [auteurs     : Auteur,
                      typedocument:TypeDocument
    ]

	static transactional = true
	
    static constraints = {
        typedocument maxSize: 1
        titre blank: true
        nombreExemplairesDisponible min: 0, blank: true
        nombreExemplaires min: 0, blank: true

    }

}
