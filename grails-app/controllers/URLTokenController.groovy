import org.apache.commons.lang.RandomStringUtils

class URLTokenController {

    def index(String shortURL) {
        if (shortURL) {
            def token = URLToken.findByShortenURL(shortURL)
            if (token) {
                redirect(url: token.fullURL)
            } else {
                [message: "Sorry, but Full URL to be shorten ($shortURL) not found."]
            }
        } else {
            [message: "Please, specify URL to be shorten: 'shortURL' param."]
        }

    }

    def shortenURL(String urlToShort) {
        if (urlToShort) {

            def token = new URLToken(fullURL: urlToShort)
            def shortenURL = RandomStringUtils.randomAlphabetic(5)
            while (URLToken.countByShortenURL(shortenURL) > 0) {
                shortenURL = RandomStringUtils.randomAlphabetic(5)
            }
            token.shortenURL = shortenURL
            if (token.save(flush: true)) {

                render createLink(controller: 'URLToken', params: [shortURL: token.shortenURL], absolute: true)
            } else {
                render("Provided URL $urlToShort is not in correct URL format. Correct format: http://www.cnn.com")
            }
        } else {
            render("URL to be shorten not specified.")
        }
    }
}
