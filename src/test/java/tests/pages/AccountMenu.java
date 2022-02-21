package tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AccountMenu {
    private final String USERNAMETEXT = "Петр Петров",
            SENDRECEIVESECTION = "Отправки и Получения",
            CONTRACTORSSECTION = "Контрагенты",
            BILLINGSECTION = "Операции оплаты",
            DESCTOPSECTION = "Рабочий стол",
            APISECTION = "API",
            TOKENSECTION = "Ключ разработчика",
            PROFILESECTION = "Профили",
            CHANGEPASSTEXT = "Смена пароля",
            CHANGEPASSSECTION = "Изменение пароля";

    private final SelenideElement
            navArea = $("#navbar"),
            leftMenuAccountArea = $("div.col-sm-3"),
            accountPageHeaderArea = $("div.page-header");

    @Step("Открываем страницу \"Отправки и Получения\"")
    public AccountMenu openSendReceivePage() {
        leftMenuAccountArea.$(byText(SENDRECEIVESECTION)).click();
        return this;
    }

    @Step("Проверяем, что открыта страница \"Отправки и Получения\"")
    public AccountMenu checkSendReceivePage() {
        accountPageHeaderArea.shouldHave(text(SENDRECEIVESECTION));
        return this;
    }

    @Step("Открываем страницу \"Контрагенты\"")
    public AccountMenu openContractorsPage() {
        leftMenuAccountArea.$(byText(CONTRACTORSSECTION)).click();
        return this;
    }

    @Step("Проверяем, что открыта страница \"Контрагенты\"")
    public AccountMenu checkContractorsPage() {
        accountPageHeaderArea.shouldHave(text(CONTRACTORSSECTION));
        return this;
    }

    @Step("Открываем страницу \"Операции оплаты\"")
    public AccountMenu openBillingPage() {
        leftMenuAccountArea.$(byText(BILLINGSECTION)).click();
        return this;
    }

    @Step("Проверяем, что открыта страница \"Операции оплаты\"")
    public AccountMenu checkBillingPage() {
        accountPageHeaderArea.shouldHave(text(BILLINGSECTION));
        return this;
    }

    @Step("Открываем страницу \"Рабочий стол\"")
    public AccountMenu openDescTopPage() {
        leftMenuAccountArea.$(byText(DESCTOPSECTION)).click();
        return this;
    }

    @Step("Проверяем, что открыта страница \"Рабочий стол\"")
    public AccountMenu checkDescTopPage() {
        accountPageHeaderArea.shouldHave(text(DESCTOPSECTION));
        return this;
    }

    @Step("Открываем страницу \"Ключ разработчика\"")
    public AccountMenu openApiPage() {
        navArea.$(byText(APISECTION)).click();
        $(byText(TOKENSECTION)).click();
        return this;
    }

    @Step("Проверяем, что открыта страница \"Ключ разработчика\"")
    public AccountMenu checkApiPage() {
        accountPageHeaderArea.shouldHave(text(TOKENSECTION));
        return this;
    }

    @Step("Открываем страницу \"Профили\"")
    public AccountMenu openProfilesPage() {
        navArea.$(byText(USERNAMETEXT)).click();
        $(byText(PROFILESECTION)).click();
        return this;
    }

    @Step("Проверяем, что открыта страница \"Профили\"")
    public AccountMenu checkProfilesPage() {
        accountPageHeaderArea.shouldHave(text(PROFILESECTION));
        return this;
    }

    @Step("Открываем страницу \"Изменить пароль\"")
    public AccountMenu openPassChangePage() {
        navArea.$(byText(USERNAMETEXT)).click();
        $(byText(CHANGEPASSTEXT)).click();
        return this;
    }

    @Step("Проверяем, что открыта страница \"Изменить пароль\"")
    public AccountMenu checkPassChangePage() {
        accountPageHeaderArea.shouldHave(text(CHANGEPASSSECTION));
        return this;
    }
}
