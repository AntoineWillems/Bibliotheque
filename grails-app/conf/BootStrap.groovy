import bibliotheque.Auteur
import bibliotheque.Livre
import bibliotheque.TypeDocument

class BootStrap {

    def init = { servletContext ->
		Livre livre
		Auteur auteur
		def listAuteur = []
		File f =new File("./bdd.csv")
		
		f.toCsvReader(['separatorChar':'	']).eachLine { tokens ->
			
			
			//livre = new Livre(titre:tokens[3], nombreExemplaires:1, nombreExemplairesDisponible:1).save()
			//livre = new Livre(titre:tokens[3], nombreExemplaires:1, nombreExemplairesDisponible:1).addToAuteurs(new Auteur(nom:"Will", prenom:"Ant")).save()
			
			def auteurExist = false
			listAuteur.each{ auteur1 ->
				if(auteur1.getNom()==tokens[4]){
					livre = new Livre(titre:tokens[3], nombreExemplaires:1, nombreExemplairesDisponible:1).addToAuteurs(auteur1).save()
					auteurExist = true
				}
			}
			if(auteurExist==false){
				def auteur1 = new Auteur(nom:tokens[4], prenom:tokens[5])
				livre = new Livre(titre:tokens[3], nombreExemplaires:1, nombreExemplairesDisponible:1).addToAuteurs(auteur1).save()
                livre.addToTypedocument(new TypeDocument(intitule: "dd")).save()
				listAuteur.add(auteur1)
			}
			
			/*
			def auteurExist = false
			listAuteur.each{ auteur1 ->
				if(auteur1.getNom()==tokens[4]){
					auteur1.addToLivres(new Livre(titre:tokens[3], nombreExemplaires:1, nombreExemplairesDisponible:1))
					auteurExist = true
				}
			}
			if(auteurExist==false){
				auteur = new Auteur(nom:tokens[4], prenom:tokens[5]).addToLivres(new Livre(titre:tokens[3], nombreExemplaires:1, nombreExemplairesDisponible:1)).save()
				listAuteur.add(auteur)
			}
			*/
			
		}
    }
    def destroy = {
    }
}
