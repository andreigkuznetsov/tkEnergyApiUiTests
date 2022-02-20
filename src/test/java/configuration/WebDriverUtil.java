package configuration;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.open;

public class WebDriverUtil {

    ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
    private static final WebDriverConfig cfg = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public void openIndexPage() {
        open(apiConfig.getWebUrl());
    }

    public void openSearchPage() {
        open(apiConfig.getSearchUrl());
    }

    public static void configure() {
        Configuration.browser = cfg.browser();
        Configuration.browserVersion = cfg.browserVersion();
        Configuration.browserSize = cfg.browserSize();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        /* ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=en-en");*/

        if (System.getProperty("environment").equals("remote")) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = cfg.remoteBrowserUrl();
        }

        //capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
        //Configuration.timeout = 10000;
    }
}
