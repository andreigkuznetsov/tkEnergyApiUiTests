package tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AccountMenuSteps {
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
    public AccountMenuSteps openSendReceivePage() {
        leftMenuAccountArea.$(byText(SENDRECEIVESECTION)).click();
        return this;
    }

    @Step("Проверяем, что открыта страница \"Отправки и Получения\"")
    public AccountMenuSteps checkSendReceivePage() {
        accountPageHeaderArea.shouldHave(text(SENDRECEIVESECTION));
        return this;
    }

    @Step("Открываем страницу \"Контрагенты\"")
    public AccountMenuSteps openContractorsPage() {
        leftMenuAccountArea.$(byText(CONTRACTORSSECTION)).click();
        return this;
    }

    @Step("Проверяем, что открыта страница \"Контрагенты\"")
    public AccountMenuSteps checkContractorsPage() {
        accountPageHeaderArea.shouldHave(text(CONTRACTORSSECTION));
        return this;
    }

    @Step("Открываем страницу \"Операции оплаты\"")
    public AccountMenuSteps openBillingPage() {
        leftMenuAccountArea.$(byText(BILLINGSECTION)).click();
        return this;
    }

    @Step("Проверяем, что открыта страница \"Операции оплаты\"")
    public AccountMenuSteps checkBillingPage() {
        accountPageHeaderArea.shouldHave(text(BILLINGSECTION));
        return this;
    }

    @Step("Открываем страницу \"Рабочий стол\"")
    public AccountMenuSteps openDescTopPage() {
        leftMenuAccountArea.$(byText(DESCTOPSECTION)).click();
        return this;
    }

    @Step("Проверяем, что открыта страница \"Рабочий стол\"")
    public AccountMenuSteps checkDescTopPage() {
        accountPageHeaderArea.shouldHave(text(DESCTOPSECTION));
        return this;
    }

    @Step("Открываем страницу \"Ключ разработчика\"")
    public AccountMenuSteps openApiPage() {
        navArea.$(byText(APISECTION)).click();
        $(byText(TOKENSECTION)).click();
        return this;
    }

    @Step("Проверяем, что открыта страница \"Ключ разработчика\"")
    public AccountMenuSteps checkApiPage() {
        accountPageHeaderArea.shouldHave(text(TOKENSECTION));
        return this;
    }

    @Step("Открываем страницу \"Профили\"")
    public AccountMenuSteps openProfilesPage() {
        navArea.$(byText(USERNAMETEXT)).click();
        $(byText(PROFILESECTION)).click();
        return this;
    }

    @Step("Проверяем, что открыта страница \"Профили\"")
    public AccountMenuSteps checkProfilesPage() {
        accountPageHeaderArea.shouldHave(text(PROFILESECTION));
        return this;
    }

    @Step("Открываем страницу \"Изменить пароль\"")
    public AccountMenuSteps openPassChangePage() {
        navArea.$(byText(USERNAMETEXT)).click();
        $(byText(CHANGEPASSTEXT)).click();
        return this;
    }

    @Step("Проверяем, что открыта страница \"Изменить пароль\"")
    public AccountMenuSteps checkPassChangePage() {
        accountPageHeaderArea.shouldHave(text(CHANGEPASSSECTION));
        return this;
    }
}
