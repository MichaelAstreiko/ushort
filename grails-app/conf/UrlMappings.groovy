class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }

        "/$shortURL?"(controller: "URLToken")
        "/api"(controller: "URLToken", action: 'shortenURL')

        "500"(view: '/error')
    }
}
