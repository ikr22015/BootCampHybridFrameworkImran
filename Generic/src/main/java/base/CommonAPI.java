package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonAPI {
    public static WebDriver driver = null;

    private String saucelabs_username = "";
    private String saucelabs_accesskey = "";
    private String browserstack_username = "imrankabir1";
    private String browserstack_accesskey = "BkCEKxRfMHZWNyex8jEE";

    @Parameters({"useCloudEnv","cloudEnvName","operating_system","os_version","browser_name","browserVersion","URL"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloudEnv, @Optional("Browserstack")String cloudEnvName,
                      @Optional("OS X") String os,@Optional("10") String os_version, @Optional("firefox") String browserName, @Optional("34")
                              String browserVersion, @Optional("http://www.amazon.com") String url)throws IOException {
        if(useCloudEnv==true){
            if(cloudEnvName.equalsIgnoreCase("browserstack")) {
                getCloudDriver(cloudEnvName,browserstack_username,browserstack_accesskey,os,os_version, browserName, browserVersion);
            }else if (cloudEnvName.equalsIgnoreCase("saucelabs")){
                getCloudDriver(cloudEnvName,saucelabs_username, saucelabs_accesskey,os,os_version, browserName, browserVersion);
            }
        }else{
            getLocalDriver(browserName, os);
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(35,TimeUnit.SECONDS);
    }

    public WebDriver getLocalDriver(String browserName, String os){
        if (browserName.equalsIgnoreCase("chrome")){
            if (os.equalsIgnoreCase("windows")){
                System.setProperty("webdriver.chrome.driver","../Generic/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            }else if (os.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.chrome.driver","../Generic/drivers/chromedriver");
                driver = new ChromeDriver();
            }
        }else if (browserName.equalsIgnoreCase("Firefox")){
            if (os.equalsIgnoreCase("windows")){
                System.setProperty("webdriver.gecko.driver","../Generic/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            }else if (os.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.gecko.driver","../Generic/drivers/geckodriver");
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }

    public WebDriver getLocalGridDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "../Generic/driver/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "../Generic/driver/geckodriver");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "../Generic/browser-driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        return driver;
    }

    public WebDriver getCloudDriver(String envName,String envUsername, String envAccessKey,String os, String os_version,String browserName,
                                    String browserVersion)throws IOException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browser_name",browserName);
        cap.setCapability("browser_version",browserVersion);
        cap.setCapability("os", os);
        cap.setCapability("os_version", os_version);
        if(envName.equalsIgnoreCase("Saucelabs")){
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://"+envUsername+":"+envAccessKey+
                    "@ondemand.saucelabs.com:80/wd/hub"), cap);
        }else if(envName.equalsIgnoreCase("Browserstack")) {
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
                    "@hub-cloud.browserstack.com/wd/hub"), cap);
        }
        return driver;
    }

    @AfterMethod
    public static void cleanUp(){
        driver.close();
    }
}
