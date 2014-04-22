import bibliotheque.Auteur
import bibliotheque.Livre
import bibliotheque.Panier
import bibliotheque.Reservation
import bibliotheque.TypeDocument
import bibliotheque.Utilisateur

class BootStrap {

    def init = { servletContext ->
        
		 Livre livre
        Auteur auteur
        def listAuteur = []
        def listTypeDoc = []
        File f =new File("./bdd.csv")
		
		def user = new Utilisateur(login:"Antoine", password:"password", mail:"willemsan.antoine@gmail.com")
		user.save()
		/*
        def panier = new Panier();
        panier.save(failOnError: true)
        def utilisateur  = new Utilisateur(version: "1",login: "admin",mail: "khadrygassama@gmail.com",panier:panier,password:"abdoul")
        utilisateur.save(failOnError: true)
     
	*/
        f.toCsvReader(['separatorChar':'	',"charset":"iso-8859-1", 'skipLines':1]).eachLine { tokens ->

            livre = new Livre(titre:tokens[3], nombreExemplaires:1, nombreExemplairesDisponible:1)

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
        
    }
    def destroy = {
    }
}
