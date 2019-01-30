import geb.Browser
import pages.GebHomePage
import pages.TheBookOfGebPage

Browser.drive {
    to GebHomePage

    manualsMenu.open()

    manualsMenu.links[0].click()

    at TheBookOfGebPage


}