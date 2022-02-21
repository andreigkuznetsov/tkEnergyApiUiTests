package tests.pages;

import com.codeborne.selenide.SelenideElement;
import configuration.ApiConfig;
import configuration.WebDriverUtil;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Auth {

    ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());

    private final String MAINPAGETEXT = "17 лет ежедневно перевозим",
            SEARCHPAGETEXT = "Поиск по сайту",
            SINGINLINK = "Личный кабинет",
            LOGINFORMTEXT = "Авторизуйтесь или создайте аккаунт",
            USERNAMETEXT = "Петр Петров",
            ACCESSFORBIDDEN = "Access forbidden",
            INVALIDLOGIN = "QWREtYGF12@inbox.ru",
            INVALIDPASSWORD = "eFtyBGFDE12#$";

    private final SelenideElement
            indexPageText = $("div.etc-jumbotron-content"),
            searchPageText = $(".etc-main"),
            headerArea = $(".etc-header"),
            loginArea = $("#login"),
            loginFieald = $("input[type='email']"),
            passwordField = $("input[type='password']"),
            submitButton = $("#submitbutton"),
            navArea = $("#navbar"),
            logoutButton = $x("//*[@id=\"navbar\"]/ul/li[5]/a"),
            errorMessageArea = $("div.alert-danger");

    WebDriverUtil webDriver = new WebDriverUtil();

    @Step("Открываем главную страницу сайта ТК Энергия")
    public Auth openIndexPage() {
        webDriver.openIndexPage();
        return this;
    }

    @Step("Проверяем, что открылась главная страница сайта ТК Энергия")
    public Auth checkIndexPage() {
        indexPageText.shouldHave(text(MAINPAGETEXT));
        return this;
    }

    @Step("Открываем страницу поиска сайта ТК Энергия")
    public Auth openSearchPage() {
        webDriver.openSearchPage();
        return this;
    }

    @Step("Проверяем, что открылась страница поиска сайта ТК Энергия")
    public Auth checkSearchPage() {
        searchPageText.shouldHave(text(SEARCHPAGETEXT));
        return this;
    }
    @Step("Открываем страницу входа в личный кабинет")
    public Auth openLoginPage() {
        headerArea.$(byText(SINGINLINK)).click();
        return this;
    }

    @Step("Проверяем, что открылась страница входа в личный кабинет")
    public Auth checkLoginPage() {
        loginArea.shouldHave(text(LOGINFORMTEXT));
        return this;
    }

    @Step("Вводим валидный логин в форму авторизации")
    public Auth typeValidLogin() {
        loginFieald.setValue(config.login());
        return this;
    }

    @Step("Вводим валидный пароль в форму авторизации")
    public Auth typeValidPassword() {
        passwordField.setValue(config.password());
        return this;
    }

    @Step("Нажимаем на кнопку \"Авторизоваться\"")
    public Auth submitAuthButton() {
        submitButton.click();
        return this;
    }

    @Step("Проверяем, что открылась главная страница личного кабинета")
    public Auth checkAccountMainPage() {
        navArea.shouldHave(text(USERNAMETEXT));
        return this;
    }

    @Step("Нажимаем на кнопку \"Выйти\"")
    public Auth submitlogoutButton() {
        logoutButton.click();
        return this;
    }

    @Step("Проверяем, что вход в личный кабинет не выполнен")
    public Auth checkAccountErrorPage() {
        errorMessageArea.shouldHave(text(ACCESSFORBIDDEN));
        return this;
    }

    @Step("Вводим невалидный логин в форму авторизации")
    public Auth typeInvalidLogin() {
        loginFieald.setValue(INVALIDLOGIN);
        return this;
    }

    @Step("Вводим невалидный пароль в форму авторизации")
    public Auth typeInvalidPassword() {
        passwordField.setValue(INVALIDPASSWORD);
        return this;
    }
}
