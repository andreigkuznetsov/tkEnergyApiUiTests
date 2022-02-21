package tests.UiTests;

import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import tests.pages.*;

import static configuration.WebDriverUtil.configure;

public class UiTestBase {
    AuthSteps authSteps = new AuthSteps();
    AccountMenuSteps accountMenuSteps = new AccountMenuSteps();
    ContractorSteps contractorSteps = new ContractorSteps();
    AboutCompanySteps aboutCompanySteps = new AboutCompanySteps();
    NavigationMenuSteps navigationMenuSteps = new NavigationMenuSteps();
    MainPage mainPage = new MainPage();

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
