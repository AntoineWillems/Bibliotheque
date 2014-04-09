import bibliotheque.Livre

class BootStrap {

    def init = { servletContext ->
		Livre l1 = new Livre(titre:"test")
		l1.save();
    }
    def destroy = {
    }
}
