class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		//"/"(view:"/index")
       
		"/"(controller:"utilisateur", action:"login")
		"500"(view:'/error')
	}
}
