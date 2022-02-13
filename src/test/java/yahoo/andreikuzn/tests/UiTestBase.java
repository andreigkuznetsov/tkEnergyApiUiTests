package yahoo.andreikuzn.tests;

import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import yahoo.andreikuzn.pages.AccountArea;
import yahoo.andreikuzn.pages.WebSite;

import static configuration.WebDriverUtil.configure;

public class UiTestBase {

    AccountArea AccountArea = new AccountArea();
    WebSite WebSite = new WebSite();

    @BeforeAll
    static void setUp() {
        configure();
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
