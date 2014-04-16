<<<<<<< HEAD
package bibliotheque

/**
 * Created by Gassama on 16/04/2014.
 */
class Utilisateur {
    String nom
    String prenom
    String adress
    String mail
    String login
    String password

    static belongsTo = [
            panier : Panier
    ]
    static constraints = {

=======
package bibliotheque

class Utilisateur {

	String nom
	String prenom
	
	//static hasOne = [panier:Panier]
	
    static constraints = {
>>>>>>> remotes/origin/dev/antoine
    }
}
