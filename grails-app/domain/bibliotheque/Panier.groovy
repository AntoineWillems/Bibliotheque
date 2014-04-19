package bibliotheque

class Panier {
	static hasMany = [livres:Livre]

    static constraints = {
        livres nullable: true
    }
    String toString(){
        id
    }
}
