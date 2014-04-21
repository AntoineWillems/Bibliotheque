package bibliotheque

/**
 * Created by Gassama on 16/04/2014.
 */
class Utilisateur {

    String mail
    String login
    String password

    static belongsTo = [
            panier: Panier
    ]
	
	static hasMany = [reservations: Reservation]
	
	static mapping = {
		panier fecth:"join"
	}
	
    static constraints = {
	    login unique: true, nullable: false
	    password password: true
	    panier nullable: true
		reservations nullable: true
    }
    String toString(){
        login
    }
}
