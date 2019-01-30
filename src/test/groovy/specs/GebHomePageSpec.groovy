package specs

import geb.spock.GebSpec
import pages.GebHomePage
import pages.TheBookOfGebPage

class GebHomePageSpec extends GebSpec {

    def "can access the book of Geb via homepage"() {
        given:
        to GebHomePage

        when:
        manualsMenu.open()
        manualsMenu.links[0].click()

        then:
        at TheBookOfGebPage
    }
}
