import bibliotheque.Auteur
import bibliotheque.Livre
import bibliotheque.Panier
import bibliotheque.Reservation
import bibliotheque.TypeDocument
import bibliotheque.Utilisateur

class BootStrap {

    def init = { servletContext ->
        /*
		 Livre livre
        Auteur auteur
        def listAuteur = []
        def listTypeDoc = []
        File f =new File("./bdd.csv")
		
        f.toCsvReader(['separatorChar':'	',"charset":"iso-8859-1", 'skipLines':1]).eachLine { tokens ->
			def nbLivres = (int) (Math.random()*5)
            livre = new Livre(titre:tokens[3], nombreExemplaires:nbLivres, nombreExemplairesDisponible:nbLivres)

            def auteurExist = false
            listAuteur.each{ auteur1 ->
                if(auteur1.getNom()==tokens[4]){
                    auteurExist = true
                    livre.addToAuteurs(auteur1)
                }
            }

            def typeDocExist = false
            listTypeDoc.each{ typeDoc1 ->
                if(typeDoc1.getIntitule()==tokens[1]){
                    typeDocExist = true
                    livre.addToTypedocument(typeDoc1)

                }
            }

            if(typeDocExist==false){
                def typeDoc1 = new TypeDocument(intitule:tokens[1])
                livre.addToTypedocument(typeDoc1)
                listTypeDoc.add(typeDoc1)
            }
            if(auteurExist==false){
                def auteur1 = new Auteur(nom:tokens[4], prenom:tokens[5])
                livre.addToAuteurs(auteur1)
                listAuteur.add(auteur1)
            }

            livre.save()
        }
        */
        
    }
    def destroy = {
    }
}
