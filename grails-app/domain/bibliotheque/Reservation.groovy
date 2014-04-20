package bibliotheque

class Reservation {

	int code
	String dateReservation
	
	static belongsTo = Livre
	static hasMany = [livres:Livre]
	
	static mapping = {
		livres fecth:"join"
	}
	
    static constraints = {
		livres nullable:true
		code blank:false, unique:true
		dateReservation blank:false
    }
}
