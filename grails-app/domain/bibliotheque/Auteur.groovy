package bibliotheque

class Auteur {
	
	String nom
	String prenom
<<<<<<< HEAD

=======
	
	//static belongsTo = Livre
>>>>>>> 20ac82190121daa35b0fa44e2010537c7007b325
	static hasMany = [livres:Livre]
	
    static constraints = {
		nom blank:true
		prenom blank:true
    }
	
}
