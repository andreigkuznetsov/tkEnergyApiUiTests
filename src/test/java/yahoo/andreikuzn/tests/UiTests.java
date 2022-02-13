package yahoo.andreikuzn.tests;

import annotations.JiraIssue;
import annotations.JiraIssues;
import annotations.Layer;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import yahoo.andreikuzn.pages.AccountArea;
import yahoo.andreikuzn.pages.WebSite;

@Layer("UI Tests")
@Owner("akuznetsov")
@Tag("Web")
@JiraIssues({@JiraIssue("HOMEWORK-")})
@DisplayName("Тестирование веб-сайта транспортной компании Энергия")
public class UiTests extends UiTestBase {

    WebSite WebSite = new WebSite();
    AccountArea AccountArea = new AccountArea();

    @Test
    @DisplayName("Проверка отображения главной страницы сайта")
    void openIndexPageTest() {
        WebSite.openIndexPage()
                .checkIndexPage();

    }

    @Test
    @DisplayName("Проверка отображения элементов левого бокового меню")
    void siteLeftMenuElementsDisplayTest() {
        WebSite.openIndexPage()
                .checkIndexPage()
                .checkLeftNavMenu();

    }

    @Test
    @DisplayName("Проверка поиска по сайту и отображения результатов")
    void searchAndDisplayTest() {
        WebSite.openSearchPage()
                .checkSearchPage()
                .typeSearchText()
                .checkSearchResult();

    }

    @Test
    @DisplayName("Проверка работы виджета он-лайн калькулятора на главной странице")
    void calcWidgetTest() {
        WebSite.openIndexPage()
                .checkIndexPage()
                .checkCalcWidget(TestData.cityFrom, TestData.cityTo,
                        TestData.weight, TestData.cargoVolume, TestData.cost);

    }

    @Test
    @DisplayName("Проверка работы виджета он-лайн отслеживания на главной странице")
    void trackingWidgetTest() {
        WebSite.openIndexPage()
                .checkIndexPage()
                .checkTrackWidget(TestData.billNumber, TestData.currentStatus);

    }

    @Test
    @DisplayName("Проверка переходов в разделы основного меню сайта")
    void mainMenuSectionsTests() {
        WebSite.openIndexPage()
                .checkIndexPage()
                .openAboutPage()
                .checkAboutPage()
                .openServicePage()
                .checkServicePage()
                .openPartnersPage()
                .checkPartnersPage()
                .openContactsPage()
                .checkContactsPage();
    }

    @Test
    @DisplayName("Проверка переходов и наличия контента страниц раздела \"О компании\"")
    void aboutSectionTests() {
        WebSite.openIndexPage()
                .checkIndexPage()
                .openAboutPage()
                .checkAboutPage()
                .openInfoPortalPage()
                .checkInfoPortalPage()
                .checkInfoPortalPageContent()
                .openAboutPage()
                .openVacanciesPage()
                .checkVacanciesPage()
                .checkVacanciesPageContent()
                .openAboutPage()
                .openDocsPage()
                .checkDocsPage()
                .checkDocsPageContent()
                .openAboutPage()
                .openFaqPage()
                .checkFaqPage()
                .openAboutPage()
                .openRulesPage()
                .checkRulesPage()
                .checkRulesPageContent();
    }

    @Test
    @DisplayName("Авторизация в личный кабинет клиента с валидными данными")
    void authValidDataTest() {
        WebSite.openIndexPage()
                .checkIndexPage();
        AccountArea.openLoginPage()
                .checkLoginPage()
                .typeValidLogin()
                .typeValidPassword()
                .submitAuthButton()
                .checkAccountMainPage()
                .submitlogoutButton()
                .checkLoginPage();

    }

    @Test
    @DisplayName("Авторизация в личный кабинет клиента с невалидными данными")
    void authInvalidDataTests() {
        WebSite.openIndexPage()
                .checkIndexPage();
        AccountArea.openLoginPage()
                .checkLoginPage()
                .submitAuthButton()
                .checkAccountErrorPage()
                .typeValidLogin()
                .typeInvalidPassword()
                .submitAuthButton()
                .checkAccountErrorPage()
                .typeInvalidLogin()
                .typeValidPassword()
                .submitAuthButton()
                .checkAccountErrorPage()
                .typeInvalidLogin()
                .typeInvalidPassword()
                .submitAuthButton()
                .checkAccountErrorPage();

    }

    @Test
    @DisplayName("Проверка, что страницы разделов в личном кабинете открываются")
    void accountPagesTests() {
        WebSite.openIndexPage()
                .checkIndexPage();
        AccountArea.openLoginPage()
                .checkLoginPage()
                .typeValidLogin()
                .typeValidPassword()
                .submitAuthButton()
                .checkAccountMainPage()
                .openSendReceivePage()
                .checkSendReceivePage()
                .openContractorsPage()
                .checkContractorsPage()
                .openBillingPage()
                .checkBillingPage()
                .openDescTopPage()
                .checkDescTopPage()
                .openApiPage()
                .checkApiPage()
                .openProfilesPage()
                .checkProfilesPage()
                .openPassChangePage()
                .checkPassChangePage()
                .submitlogoutButton()
                .checkLoginPage();

    }

    @Test
    @DisplayName("Создание, изменение и удаление контрагента в личном кабинете")
    void crudOperationsContractorTests() {
        WebSite.openIndexPage()
                .checkIndexPage();
        AccountArea.openLoginPage()
                .checkLoginPage()
                .typeValidLogin()
                .typeValidPassword()
                .submitAuthButton()
                .checkAccountMainPage()
                .openContractorsPage()
                .checkContractorsPage()
                .openNewContractorFrom()
                .createNewContractor()
                .checkNewContractorData()
                .changeNewContractorData()
                .deleteNewContractorData()
                .submitlogoutButton()
                .checkLoginPage();

    }

}





