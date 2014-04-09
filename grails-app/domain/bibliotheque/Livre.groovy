package bibliotheque

class Livre {
	
	String titre
	int nombreExemplaires
	int nombreExemplairesDisponible
	
	static belongsTo = [Auteur, Reservation]
	static hasMany = [auteurs:Auteur,
						reservations:Reservation]
	
	public void commandeLivre(){
		nombreExemplairesDisponible--;
	}
	
	
    static constraints = {
		titre unique:true, blank:false 
		nombreExemplairesDisponible min:0, blank:false
		nombreExemplaires min:0 , blank:false
		
    }
}
