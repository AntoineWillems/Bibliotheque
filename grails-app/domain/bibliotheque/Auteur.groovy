package bibliotheque

class Auteur {
	
	String nom
	String prenom

	static hasMany = [livres:Livre]
	
    static constraints = {
		nom blank:false
		prenom blank:false
    }
}
