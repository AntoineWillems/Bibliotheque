package bibliotheque

class Panier {
	static hasMany = [livres:Livre]

	static mapping = {
		livres fecth:"join"
	}
    static constraints = {
        livres nullable: true
    }
}
