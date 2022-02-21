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

public class AuthSteps {

    ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());

    private final String SINGINLINK = "Личный кабинет",
            LOGINFORMTEXT = "Авторизуйтесь или создайте аккаунт",
            USERNAMETEXT = "Петр Петров",
            ACCESSFORBIDDEN = "Access forbidden",
            INVALIDLOGIN = "QWREtYGF12@inbox.ru",
            INVALIDPASSWORD = "eFtyBGFDE12#$";

    private final SelenideElement headerArea = $(".etc-header"),
            loginArea = $("#login"),
            loginFieald = $("input[type='email']"),
            passwordField = $("input[type='password']"),
            submitButton = $("#submitbutton"),
            navArea = $("#navbar"),
            logoutButton = $x("//*[@id=\"navbar\"]/ul/li[5]/a"),
            errorMessageArea = $("div.alert-danger");

    @Step("Открываем страницу входа в личный кабинет")
    public AuthSteps openLoginPage() {
        headerArea.$(byText(SINGINLINK)).click();
        return this;
    }

    @Step("Проверяем, что открылась страница входа в личный кабинет")
    public AuthSteps checkLoginPage() {
        loginArea.shouldHave(text(LOGINFORMTEXT));
        return this;
    }

    @Step("Вводим валидный логин в форму авторизации")
    public AuthSteps typeValidLogin() {
        loginFieald.setValue(config.login());
        return this;
    }

    @Step("Вводим валидный пароль в форму авторизации")
    public AuthSteps typeValidPassword() {
        passwordField.setValue(config.password());
        return this;
    }

    @Step("Нажимаем на кнопку \"Авторизоваться\"")
    public AuthSteps submitAuthButton() {
        submitButton.click();
        return this;
    }

    @Step("Проверяем, что открылась главная страница личного кабинета")
    public AuthSteps checkAccountMainPage() {
        navArea.shouldHave(text(USERNAMETEXT));
        return this;
    }

    @Step("Нажимаем на кнопку \"Выйти\"")
    public AuthSteps submitlogoutButton() {
        logoutButton.click();
        return this;
    }

    @Step("Проверяем, что вход в личный кабинет не выполнен")
    public AuthSteps checkAccountErrorPage() {
        errorMessageArea.shouldHave(text(ACCESSFORBIDDEN));
        return this;
    }

    @Step("Вводим невалидный логин в форму авторизации")
    public AuthSteps typeInvalidLogin() {
        loginFieald.setValue(INVALIDLOGIN);
        return this;
    }

    @Step("Вводим невалидный пароль в форму авторизации")
    public AuthSteps typeInvalidPassword() {
        passwordField.setValue(INVALIDPASSWORD);
        return this;
    }
}
