package bibliotheque

class Reservation {

	int code
	String dateReservation
	
	static belongsTo = Livre
	static hasMany = [livres:Livre]
	
    static constraints = {
		code blank:false, unique:true
		dateReservation blank:false
    }
}
