package pages

import geb.Page
import modules.ManualsMenuModule

class GebHomePage extends Page{

    static url = "http://gebish.org"

    static at = { title == "Geb - Very Groovy Browser Automation"}
    static content = {
        manualsMenu { module(ManualsMenuModule)}
    }

}
