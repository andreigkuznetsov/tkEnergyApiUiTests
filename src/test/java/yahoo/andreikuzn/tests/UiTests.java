package yahoo.andreikuzn.tests;

import annotations.JiraIssue;
import annotations.JiraIssues;
import annotations.Layer;
import annotations.Microservice;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tag("Web")
@JiraIssues({@JiraIssue("HOMEWORK-334")})
@DisplayName("Тестирование веб-сайта транспортной компании Энергия")
public class UiTests extends UiTestBase {

    @Test
    @DisplayName("Проверка отображения главной страницы сайта")
    @Layer("UI Tests")
    @Owner("Andrei Kuznetsov")
    @Tags({@Tag("High"), @Tag("Smoke"), @Tag("Regress")})
    @Microservice("Web")
    @Feature("Главная страница веб-сайта")
    @Story("Основные страницы веб-сайта")
    @Severity(SeverityLevel.BLOCKER)
    void openIndexPageTest() {
        WebSite.openIndexPage()
                .checkIndexPage();

    }

    @Test
    @DisplayName("Проверка отображения элементов левого бокового меню")
    @Layer("UI Tests")
    @Owner("Andrei Kuznetsov")
    @Tags({@Tag("High"), @Tag("Regress")})
    @Microservice("Web")
    @Feature("Левое боковое меню навигации")
    @Story("Навигация по веб-сайту")
    @Severity(SeverityLevel.CRITICAL)
    void siteLeftMenuElementsDisplayTest() {
        WebSite.openIndexPage()
                .checkIndexPage()
                .checkLeftNavMenu();

    }

    @Test
    @DisplayName("Проверка поиска по сайту и отображения результатов")
    @Layer("UI Tests")
    @Owner("Andrei Kuznetsov")
    @Tags({@Tag("High"), @Tag("Smoke"), @Tag("Regress")})
    @Microservice("Web")
    @Feature("Поиск по сайту")
    @Story("Функционал веб-сайта")
    @Severity(SeverityLevel.BLOCKER)
    void searchAndDisplayTest() {
        WebSite.openSearchPage()
                .checkSearchPage()
                .typeSearchText()
                .checkSearchResult();

    }

    @Test
    @DisplayName("Проверка работы виджета он-лайн калькулятора на главной странице")
    @Layer("UI Tests")
    @Owner("Andrei Kuznetsov")
    @Tags({@Tag("High"), @Tag("Smoke"), @Tag("Regress")})
    @Microservice("Web")
    @Feature("Виджет он-лайн калькулятора")
    @Story("Элементы страниц веб-сайта")
    @Severity(SeverityLevel.CRITICAL)
    void calcWidgetTest() {
        WebSite.openIndexPage()
                .checkIndexPage()
                .checkCalcWidget(TestData.cityFrom, TestData.cityTo,
                        TestData.weight, TestData.cargoVolume, TestData.cost);

    }

    @Test
    @DisplayName("Проверка работы виджета он-лайн отслеживания на главной странице")
    @Layer("UI Tests")
    @Owner("Andrei Kuznetsov")
    @Tags({@Tag("High"), @Tag("Smoke"), @Tag("Regress")})
    @Microservice("Web")
    @Feature("Виджет он-лайн отслеживания")
    @Story("Элементы страниц веб-сайта")
    @Severity(SeverityLevel.CRITICAL)
    void trackingWidgetTest() {
        WebSite.openIndexPage()
                .checkIndexPage()
                .checkTrackWidget(TestData.billNumber, TestData.currentStatus);

    }

    @Test
    @DisplayName("Проверка переходов в разделы основного меню сайта")
    @Layer("UI Tests")
    @Owner("Gleb Danilov")
    @Tags({@Tag("High"), @Tag("Regress")})
    @Microservice("Web")
    @Feature("Основное меню веб-сайта")
    @Story("Навигация по веб-сайту")
    @Severity(SeverityLevel.CRITICAL)
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
    @Layer("UI Tests")
    @Owner("Gleb Danilov")
    @Tags({@Tag("Low"), @Tag("Regress")})
    @Microservice("Web")
    @Feature("Меню раздела О компании веб-сайта")
    @Story("Навигация по веб-сайту")
    @Severity(SeverityLevel.NORMAL)
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
    @Layer("UI Tests")
    @Owner("Andrei Kuznetsov")
    @Tags({@Tag("High"), @Tag("Smoke"), @Tag("Regress")})
    @Microservice("Web")
    @Feature("Авторизация")
    @Story("Личный кабинет пользователя веб-сайта")
    @Severity(SeverityLevel.BLOCKER)
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
    @Layer("UI Tests")
    @Owner("Andrei Kuznetsov")
    @Tags({@Tag("Low"), @Tag("Regress")})
    @Microservice("Web")
    @Feature("Авторизация")
    @Story("Личный кабинет пользователя веб-сайта")
    @Severity(SeverityLevel.NORMAL)
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
    @Layer("UI Tests")
    @Owner("Gleb Danilov")
    @Tags({@Tag("Low"), @Tag("Regress")})
    @Microservice("Web")
    @Feature("Разделы в личном кабинете пользователя")
    @Story("Личный кабинет пользователя веб-сайта")
    @Severity(SeverityLevel.NORMAL)
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
    @Layer("UI Tests")
    @Owner("Andrei Kuznetsov")
    @Tags({@Tag("Nigh"), @Tag("Regress")})
    @Microservice("Web")
    @Feature("Клиенты и контагенты пользователя личного кабинета")
    @Story("Личный кабинет пользователя веб-сайта")
    @Severity(SeverityLevel.CRITICAL)
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





