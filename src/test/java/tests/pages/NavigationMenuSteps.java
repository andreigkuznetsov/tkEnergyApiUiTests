package tests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.pages.components.CalcWidgetComponent;
import tests.pages.components.TrackWidgetComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static tests.TestData.searchText;

public class NavigationMenuSteps {
    private final String LEFTNAVMENUCONTENT = "Калькулятор Поиск груза Подать заявку Обратная связь Тарифы",
            ABOUTCOMPANYTEXT = "О компании",
            SERVICETITLE = "Услуги",
            SERVICETEXT = "Широкий спектр услуг",
            PARTNERSHIPTEXT = "Партнерам",
            CONTACTSTEXT = "Контакты";

    private final SelenideElement
            leftNAvMenu = $("div.etc-page-sidebar"),
            searchField = $("input[type='text']"),
            headerArea = $(".etc-header"),
            mainWebPageArea = $(".etc-main");

    public static ElementsCollection
            searchResultArea = $$("div.etc-news");

    public CalcWidgetComponent calcWidgetComponent = new CalcWidgetComponent();
    public TrackWidgetComponent trackWidgetComponent = new TrackWidgetComponent();

       @Step("Открываем страницу \"О компании\" сайта ТК Энергия")
    public NavigationMenuSteps openAboutPage() {
        headerArea.$(byText(ABOUTCOMPANYTEXT)).click();
        return this;
    }

    @Step("Проверяем, что открылась страница \"О компании\"")
    public NavigationMenuSteps checkAboutPage() {
        mainWebPageArea.shouldHave(text(ABOUTCOMPANYTEXT));
        return this;
    }

    @Step("Открываем страницу \"Услуги\" сайта ТК Энергия")
    public NavigationMenuSteps openServicePage() {
        headerArea.$(byText(SERVICETITLE)).click();
        return this;
    }

    @Step("Проверяем, что открылась страница \"Услуги\"")
    public NavigationMenuSteps checkServicePage() {
        mainWebPageArea.shouldHave(text(SERVICETEXT));
        return this;
    }

    @Step("Открываем страницу \"Партнерам\" сайта ТК Энергия")
    public NavigationMenuSteps openPartnersPage() {
        headerArea.$(byText(PARTNERSHIPTEXT)).click();
        return this;
    }

    @Step("Проверяем, что открылась страница \"Партнерам\"")
    public NavigationMenuSteps checkPartnersPage() {
        mainWebPageArea.shouldHave(text(PARTNERSHIPTEXT));
        return this;
    }

    @Step("Открываем страницу \"Конаткты\" сайта ТК Энергия")
    public NavigationMenuSteps openContactsPage() {
        headerArea.$(byText(CONTACTSTEXT)).click();
        return this;
    }

    @Step("Проверяем, что открылась страница \"Конаткты\"")
    public NavigationMenuSteps checkContactsPage() {
        mainWebPageArea.shouldHave(text(CONTACTSTEXT));
        return this;
    }

    @Step("Вносим в поле поиска поисковое слово")
    public NavigationMenuSteps typeSearchText() {
        searchField.setValue(searchText).pressEnter();
        return this;
    }

    @Step("Проверяем, что поиск выдает релевантные результаты")
    public NavigationMenuSteps checkSearchResult() {
        searchResultArea.find(Condition.text(searchText))
                .shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверяем работу виджета рассчета стоимости доставки")
    public NavigationMenuSteps checkCalcWidget(String cityFrom, String cityTo,
                                               String weight, String cargoVolume) {
        calcWidgetComponent.checkCalcWidget(cityFrom, cityTo,
                weight, cargoVolume);
        return this;
    }

    @Step("Проверяем работу виджета отслеживания доставки")
    public NavigationMenuSteps checkTrackWidget(String billNumber, String currentStatus) {
        trackWidgetComponent.checkTrackingWidget(billNumber, currentStatus);
        return this;
    }

    @Step("Проверяем, что левое навигационное меню содержит правильные пункты")
    public NavigationMenuSteps checkLeftNavMenu() {
        leftNAvMenu.shouldHave(text(LEFTNAVMENUCONTENT));
        return this;
    }
}
