/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/

import org.openqa.selenium.Platform
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.BrowserType
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

baseUrl = "http://www.gebish.org/"

// default driver...
//System.setProperty('webdriver.chrome.driver', "../resources/chromedriver")
/*driver = {new ChromeDriver()}*/

driver = {
    def capabilities = new DesiredCapabilities()
    capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME)
    capabilities.setCapability(CapabilityType.PLATFORM, Platform.LINUX)

    def remoteWebDriverUrl = new URL("http://localhost:4444/wd/hub")
    new RemoteWebDriver(remoteWebDriverUrl, capabilities)
}

environments {
    // specify environment via -Dgeb.env=ie
    "ie" {
        def ieDriver = new File('src/test/resources/IEDriverServer.exe')
        System.setProperty('webdriver.ie.driver', ieDriver.absolutePath)
        //driver = { new InternetExplorerDriver() }
    }

    "chrome" {
/*        def chromeDriver = new File('src/test/resources/chromedriver') // add .exe for Windows...
        System.setProperty('webdriver.chrome.driver', chromeDriver.absolutePath)
        driver = { new ChromeDriver() }*/
        def capabilities = new DesiredCapabilities()
        capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME)
        capabilities.setCapability(CapabilityType.PLATFORM, Platform.LINUX)

        def remoteWebDriverUrl = new URL("http://localhost:4444/wd/hub")
        new RemoteWebDriver(remoteWebDriverUrl, capabilities)
    }

    'ff' {
        driver = { new FirefoxDriver() }
        driver.manage().window().maximize()
    }

    'safari' {
        //driver = { new SafariDriver() }
    }

/*    'sauce' {
        driver = {
            // sauce.config: <browser>:<os>:<ver> eg. iphone:OSX10.9:7
            def sauceBrowser = System.properties.getProperty('sauce.config')
            def username = System.properties.getProperty('sauce.user')
            def accessKey = System.properties.getProperty('sauce.key')
            new SauceLabsDriverFactory().create(sauceBrowser, username, accessKey)
        }
    }*/
}

waiting {
    timeout = 10
    retryInterval = 0.5
    slow { timeout = 12 }
    reallySlow { timeout = 24 }
    includeCauseInMessage = true
    atCheckWaiting = true
    baseNavigatorWaiting = true
}


reportsDir = "target/geb-reports"
