import bibliotheque.Auteur
import bibliotheque.Livre
import bibliotheque.TypeDocument

class BootStrap {

    def init = { servletContext ->
		Livre livre
		Auteur auteur
		TypeDocument type
		def listAuteur = []
		File f =new File("C://Users/Willems/Documents/Cours/JEE/Bibliotheque/bdd.csv")
		
		f.toCsvReader(['separatorChar':'	']).eachLine { tokens ->
			
			type = new TypeDocument(intitule:tokens[1]).save()
			//livre = new Livre(titre:tokens[3], nombreExemplaires:1, nombreExemplairesDisponible:1).save()
			//livre = new Livre(titre:tokens[3], nombreExemplaires:1, nombreExemplairesDisponible:1).addToAuteur(new Auteur(nom:"Will", prenom:"Ant")).save()
			/*
			listAuteur.each{ auteur1 ->
				if(auteur1.getNom()==tokens[4]){
					auteur1.addToLivres(new Livre(titre:tokens[3], nombreExemplaires:1, nombreExemplairesDisponible:1))
				}
			}
			*/
			
			
			
			auteur = new Auteur(nom:tokens[4], prenom:tokens[5]).addToLivres(new Livre(titre:tokens[3], nombreExemplaires:1, nombreExemplairesDisponible:1)).save()
			//listAuteur.add(auteur)
		}
    }
    def destroy = {
    }
}
