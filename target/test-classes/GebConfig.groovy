import geb.driver.SauceLabsDriverFactory
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.safari.SafariDriver
import geb.download.helper.SelfSignedCertificateHelper
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.Capabilities
import org.openqa.selenium.remote.DesiredCapabilities

// default driver...
System.setProperty('webdriver.chrome.driver', "../resources/chromedriver")
driver = {new ChromeDriver()}

environments {
    // specify environment via -Dgeb.env=ie
    "ie" {
        def ieDriver = new File('src/test/resources/IEDriverServer.exe')
        System.setProperty('webdriver.ie.driver', ieDriver.absolutePath)
        driver = { new InternetExplorerDriver() }
    }

    "chrome" {


        def chromeDriver = new File('src/test/resources/chromedriver') // add .exe for Windows...
        System.setProperty('webdriver.chrome.driver', chromeDriver.absolutePath)
        DesiredCapabilities capabilities = DesiredCapabilities.chrome()
        ChromeOptions options = new ChromeOptions()
        options.addArguments("test-type","ignore-certificate-errors","start-maximized")
        capabilities.setCapability("chrome.binary","<<your chrome path>>")
        capabilities.setCapability(ChromeOptions.CAPABILITY, options)
        //capabilities.setCapability(ChromeOptions.CAPABILITY.ACCEPT_SSL,options)
        //capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true)
        driver = { new ChromeDriver(capabilities) }



    }

    'ff' {
        driver = { new FirefoxDriver() }
        driver.manage().window().maximize()
    }

    'safari' {
        driver = { new SafariDriver() }
    }

    'sauce' {
        driver = {
            // sauce.config: <browser>:<os>:<ver> eg. iphone:OSX10.9:7
            def sauceBrowser = System.properties.getProperty('sauce.config')
            def username = System.properties.getProperty('sauce.user')
            def accessKey = System.properties.getProperty('sauce.key')
            new SauceLabsDriverFactory().create(sauceBrowser, username, accessKey)
        }
    }
}

waiting {
    timeout = 15
    retryInterval = 0.5
    slow { timeout = 12 }
    reallySlow { timeout = 24 }
}

reportsDir = "target/geb-reports"

