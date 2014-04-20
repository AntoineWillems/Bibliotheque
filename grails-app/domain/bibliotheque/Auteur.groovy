package bibliotheque

class Auteur {
	
	String nom
	String prenom
	
	static belongsTo = Livre
	static hasMany = [livres:Livre]
	
	static mapping = {
		livres fecth:"join"
	}
	
    static constraints = {
		nom blank:true
		prenom blank:true
    }
}

