import org.apache.commons.lang.RandomStringUtils

/**
 * @author Michael Astreiko
 */
class URLToken {
    String fullURL
    String shortenURL

    Date dateCreated // autoupdated by GORM

    static constraints = {
        shortenURL(unique: true)
        fullURL(url: true)
    }
}
