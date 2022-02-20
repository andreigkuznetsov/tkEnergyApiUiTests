package yahoo.andreikuzn.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import configuration.WebDriverUtil;
import io.qameta.allure.Step;
import yahoo.andreikuzn.pages.components.CalcWidgetComponent;
import yahoo.andreikuzn.pages.components.TrackWidgetComponent;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static yahoo.andreikuzn.tests.TestData.searchText;

public class WebSite {

    private final String MAINPAGETEXT = "17 лет ежедневно перевозим",
            SEARCHPAGETEXT = "Поиск по сайту",
            LEFTNAVMENUCONTENT = "Калькулятор Поиск груза Подать заявку Обратная связь Тарифы",
            ABOUTCOMPANYTEXT = "О компании",
            SERVICETITLE = "Услуги",
            SERVICETEXT = "Широкий спектр услуг",
            PARTNERSHIPTEXT = "Партнерам",
            CONTACTSTEXT = "Контакты",
            INFOPORTALTEXT = "Информационный портал",
            VACANCIESTEXT = "Вакансии",
            DOCSECTIONSTEXT = "Документы",
            FAQTITLE = "Вопрос-ответ",
            FAQTEXT = "Часто задаваемые вопросы",
            RULESSECTIONTEXT = "Правила";

    private final SelenideElement
            indexPageText = $("div.etc-jumbotron-content"),
            searchPageText = $(".etc-main"),
            leftNAvMenu = $("div.etc-page-sidebar"),
            searchField = $("input[type='text']"),
            headerArea = $(".etc-header"),
            mainWebPageArea = $(".etc-main");

    public static ElementsCollection
            searchResultArea = $$("div.etc-news"),
            infoPortalContentArea = $$("div.grid"),
            vacanciesContentArea = $$("#jobs"),
            docsContentArea = $$("#documents"),
            rulesContentArea = $$("div.etc-blog-post");

    public CalcWidgetComponent CalcWidgetCheck = new CalcWidgetComponent();
    public TrackWidgetComponent TrackWidgetCheck = new TrackWidgetComponent();

    WebDriverUtil webDriver = new WebDriverUtil();

    @Step("Открываем главную страницу сайта ТК Энергия")
    public WebSite openIndexPage() {
        webDriver.openIndexPage();

        return this;
    }

    @Step("Проверяем, что открылась главная страница сайта ТК Энергия")
    public WebSite checkIndexPage() {
        indexPageText.shouldHave(text(MAINPAGETEXT));

        return this;
    }

    @Step("Открываем страницу поиска сайта ТК Энергия")
    public WebSite openSearchPage() {
        webDriver.openSearchPage();

        return this;
    }

    @Step("Проверяем, что открылась страница поиска сайта ТК Энергия")
    public WebSite checkSearchPage() {
        searchPageText.shouldHave(text(SEARCHPAGETEXT));

        return this;
    }

    @Step("Проверяем, что левое навигационное меню содержит правильные пункты")
    public WebSite checkLeftNavMenu() {
        leftNAvMenu.shouldHave(text(LEFTNAVMENUCONTENT));

        return this;
    }

    @Step("Вносим в поле поиска поисковое слово")
    public WebSite typeSearchText() {
        searchField.setValue(searchText).pressEnter();

        return this;
    }

    @Step("Проверяем, что поиск выдает релевантные результаты")
    public WebSite checkSearchResult() {
        searchResultArea.find(Condition.text(searchText))
                .shouldBe(Condition.visible);

        return this;
    }

    @Step("Проверяем работу виджета рассчета стоимости доставки")
    public WebSite checkCalcWidget(String cityFrom, String cityTo,
                                   String weight, String cargoVolume) {
        CalcWidgetCheck.checkCalcWidget(cityFrom, cityTo,
                weight, cargoVolume);

        return this;
    }

    @Step("Проверяем работу виджета отслеживания доставки")
    public WebSite checkTrackWidget(String billNumber, String currentStatus) {
        TrackWidgetCheck.checkTrackingWidget(billNumber, currentStatus);

        return this;
    }

    @Step("Открываем страницу \"О компании\" сайта ТК Энергия")
    public WebSite openAboutPage() {
        headerArea.$(byText(ABOUTCOMPANYTEXT)).click();

        return this;
    }

    @Step("Проверяем, что открылась страница \"О компании\"")
    public WebSite checkAboutPage() {
        mainWebPageArea.shouldHave(text(ABOUTCOMPANYTEXT));

        return this;
    }

    @Step("Открываем страницу \"Услуги\" сайта ТК Энергия")
    public WebSite openServicePage() {
        headerArea.$(byText(SERVICETITLE)).click();

        return this;
    }

    @Step("Проверяем, что открылась страница \"Услуги\"")
    public WebSite checkServicePage() {
        mainWebPageArea.shouldHave(text(SERVICETEXT));

        return this;
    }

    @Step("Открываем страницу \"Партнерам\" сайта ТК Энергия")
    public WebSite openPartnersPage() {
        headerArea.$(byText(PARTNERSHIPTEXT)).click();

        return this;
    }

    @Step("Проверяем, что открылась страница \"Партнерам\"")
    public WebSite checkPartnersPage() {
        mainWebPageArea.shouldHave(text(PARTNERSHIPTEXT));

        return this;
    }

    @Step("Открываем страницу \"Конаткты\" сайта ТК Энергия")
    public WebSite openContactsPage() {
        headerArea.$(byText(CONTACTSTEXT)).click();

        return this;
    }

    @Step("Проверяем, что открылась страница \"Конаткты\"")
    public WebSite checkContactsPage() {
        mainWebPageArea.shouldHave(text(CONTACTSTEXT));

        return this;
    }

    @Step("Открываем страницу \"Информационный портал\" раздела \"О компании\"")
    public WebSite openInfoPortalPage() {
        mainWebPageArea.$(byText(INFOPORTALTEXT)).click();

        return this;
    }

    @Step("Проверяем, что открылась страница \"Информационный портал\"")
    public WebSite checkInfoPortalPage() {
        mainWebPageArea.shouldHave(text(INFOPORTALTEXT));

        return this;
    }

    @Step("Проверяем наличие контента на странице \"Информационный портал\"")
    public WebSite checkInfoPortalPageContent() {
        infoPortalContentArea.shouldHave(sizeGreaterThan(0));

        return this;
    }

    @Step("Открываем страницу \"Вакансии\" раздела \"О компании\"")
    public WebSite openVacanciesPage() {
        mainWebPageArea.$(byText(VACANCIESTEXT)).click();

        return this;
    }

    @Step("Проверяем, что открылась страница \"Вакансии\"")
    public WebSite checkVacanciesPage() {
        mainWebPageArea.shouldHave(text(VACANCIESTEXT));

        return this;
    }

    @Step("Проверяем наличие контента на странице \"Вакансии\"")
    public WebSite checkVacanciesPageContent() {
        vacanciesContentArea.shouldHave(sizeGreaterThan(0));

        return this;
    }

    @Step("Открываем страницу \"Документы\" раздела \"О компании\"")
    public WebSite openDocsPage() {
        mainWebPageArea.$(byText(DOCSECTIONSTEXT)).click();

        return this;
    }

    @Step("Проверяем, что открылась страница \"Документы\"")
    public WebSite checkDocsPage() {
        mainWebPageArea.shouldHave(text(DOCSECTIONSTEXT));

        return this;
    }

    @Step("Проверяем наличие контента на странице \"Документы\"")
    public WebSite checkDocsPageContent() {
        docsContentArea.shouldHave(sizeGreaterThan(0));

        return this;
    }

    @Step("Открываем страницу \"Вопрос-ответ\" раздела \"О компании\"")
    public WebSite openFaqPage() {
        mainWebPageArea.$(byText(FAQTITLE)).click();

        return this;
    }

    @Step("Проверяем, что открылась страница \"Вопрос-ответ\"")
    public WebSite checkFaqPage() {
        mainWebPageArea.shouldHave(text(FAQTEXT));

        return this;
    }

    @Step("Открываем страницу \"Правила\" раздела \"О компании\"")
    public WebSite openRulesPage() {
        mainWebPageArea.$(byText(RULESSECTIONTEXT)).click();

        return this;
    }

    @Step("Проверяем, что открылась страница \"Правила\"")
    public WebSite checkRulesPage() {
        mainWebPageArea.shouldHave(text(RULESSECTIONTEXT));

        return this;
    }

    @Step("Проверяем наличие контента на странице \"Правила\"")
    public WebSite checkRulesPageContent() {
        rulesContentArea.shouldHave(sizeGreaterThan(0));

        return this;
    }
}

