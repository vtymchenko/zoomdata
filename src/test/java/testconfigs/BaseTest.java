package testconfigs;

import com.zoomdata.demo.core.ConciseAPI;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class BaseTest {

    private static String OS = System.getProperty("os.name").toLowerCase();

    @BeforeMethod
    public void openUrl() {
        ConciseAPI.getWebDriver().get("https://demo.zoomdata.com:8443");
        ConciseAPI.getWebDriver().manage().window().maximize();
    }

    @BeforeClass
    @Parameters({"browser"})
    public void setup(@Optional("firefox") String browser) {
        try {
            if (browser.equalsIgnoreCase("firefox")) {
                ConciseAPI.setWebDriver(new FirefoxDriver());

            } else if (browser.equalsIgnoreCase("chrome") && isLinux()) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                ConciseAPI.setWebDriver(new ChromeDriver());

            } else if (browser.equalsIgnoreCase("chrome") && !isLinux()) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                ConciseAPI.setWebDriver(new ChromeDriver());
            }

        } catch (WebDriverException e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterMethod
    public void closeWebDriver() {
        ConciseAPI.getWebDriver().close();
    }

    @AfterClass
    public void tearDown() {
        ConciseAPI.getWebDriver().quit();
    }

    public static boolean isLinux() {
        return (OS.indexOf("linux") >= 0);
    }

}
