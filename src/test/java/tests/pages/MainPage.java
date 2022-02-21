package tests.pages;

import com.codeborne.selenide.SelenideElement;
import configuration.WebDriverUtil;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final String MAINPAGETEXT = "17 лет ежедневно перевозим",
            SEARCHPAGETEXT = "Поиск по сайту";

    private final SelenideElement
            indexPageText = $("div.etc-jumbotron-content"),
            searchPageText = $(".etc-main");

    WebDriverUtil webDriver = new WebDriverUtil();

    @Step("Открываем главную страницу сайта ТК Энергия")
    public MainPage openIndexPage() {
        webDriver.openIndexPage();
        return this;
    }

    @Step("Проверяем, что открылась главная страница сайта ТК Энергия")
    public MainPage checkIndexPage() {
        indexPageText.shouldHave(text(MAINPAGETEXT));
        return this;
    }

    @Step("Открываем страницу поиска сайта ТК Энергия")
    public MainPage openSearchPage() {
        webDriver.openSearchPage();
        return this;
    }

    @Step("Проверяем, что открылась страница поиска сайта ТК Энергия")
    public MainPage checkSearchPage() {
        searchPageText.shouldHave(text(SEARCHPAGETEXT));
        return this;
    }
}
