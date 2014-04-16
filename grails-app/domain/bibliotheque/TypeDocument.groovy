package bibliotheque

class TypeDocument {

    def Livre livre1
    static belongsTo = [Livre]
    String intitule

    static constraints = {
    }
}
