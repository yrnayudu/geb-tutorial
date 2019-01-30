package modules

import geb.Module

class ManualsMenuModule extends Module{

    static content = {
        toggle { $("a.manuals.item")}
        linksContainer { $("#manuals-menu") }
        links { linksContainer.find("a")}
    }

    void open() {
        toggle.click()
        waitFor { !linksContainer.hasClass("animating")}
    }
}
