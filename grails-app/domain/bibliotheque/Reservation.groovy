package bibliotheque

class Reservation {

	int code
	String dateReservation
	
	//static belongsTo = Livre
	static hasMany = [livres:Livre]
	
	static mapping = {
		livres fecth:"join"
	}
	
	static transactional = true
    static constraints = {
		//livres nullable:true
		code blank:true, nullable:true
		dateReservation blank:true, nullable:true
    }
}
