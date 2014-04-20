package bibliotheque

class Livre {

    String titre
    int nombreExemplaires
    int nombreExemplairesDisponible
    static hasMany = [auteurs     : Auteur,
                      reservations: Reservation,
                      typedocument:TypeDocument
    ]

    static constraints = {
        typedocument maxSize: 1
		reservations maxSize: 1
        titre blank: true
        nombreExemplairesDisponible min: 0, blank: true
        nombreExemplaires min: 0, blank: true

    }

}
