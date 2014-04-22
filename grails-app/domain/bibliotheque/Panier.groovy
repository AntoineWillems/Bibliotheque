package bibliotheque

class Panier {
	
	static belongsTo = Livre
	static hasMany = [livres:Livre]
	
	static mapping = {
		livres fecth:"join"
	}
    static constraints = {
        livres nullable: true
    }
	
	static transactional = true
    String toString(){
        id
    }
}
