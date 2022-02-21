package tests.UiTests;

import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import tests.pages.*;

import static configuration.WebDriverUtil.configure;

public class UiTestBase {
    Auth auth = new Auth();
    AccountMenu accountMenu = new AccountMenu();
    Contractor contractor = new Contractor();
    AboutCompany aboutCompany = new AboutCompany();
    NavigationMenu navigationMenu = new NavigationMenu();

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
