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
    static constraints = {

    }
}
