package bibliotheque

class Livre {
	
	String titre
	int nombreExemplaires
	int nombreExemplairesDisponible
	//static belongsTo = [Auteur, Reservation]
	static hasMany = [auteurs:Auteur,
						reservations:Reservation]
	
	
    static constraints = {
		titre blank:true 
		nombreExemplairesDisponible min:0, blank:true
		nombreExemplaires min:0 , blank:true
		
    }
	
}
