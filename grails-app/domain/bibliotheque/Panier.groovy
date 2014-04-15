package bibliotheque

class Panier {
	int id
	static hasMany = [livres:Livre]
	
    static constraints = {
    }
}
