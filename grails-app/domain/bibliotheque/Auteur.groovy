package bibliotheque

class Auteur {
	
	String nom
	String prenom
    String adress
	
	static hasMany = [livres:Livre]
	
    static constraints = {
		nom blank:false
		prenom blank:false
    }
}
