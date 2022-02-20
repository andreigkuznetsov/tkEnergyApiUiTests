package yahoo.andreikuzn.pages;

import com.codeborne.selenide.SelenideElement;
import configuration.ApiConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import yahoo.andreikuzn.tests.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AccountArea {

    ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());

    private final String SINGINLINK = "Личный кабинет",
            LOGINFORMTEXT = "Авторизуйтесь или создайте аккаунт",
            USERNAMETEXT = "Петр Петров",
            ACCESSFORBIDDEN = "Access forbidden",
            INVALIDLOGIN = "QWREtYGF12@inbox.ru",
            INVALIDPASSWORD = "eFtyBGFDE12#$",
            SENDRECEIVESECTION = "Отправки и Получения",
            CONTRACTORSSECTION = "Контрагенты",
            BILLINGSECTION = "Операции оплаты",
            DESCTOPSECTION = "Рабочий стол",
            APISECTION = "API",
            TOKENSECTION = "Ключ разработчика",
            PROFILESECTION = "Профили",
            CHANGEPASSTEXT = "Смена пароля",
            CHANGEPASSSECTION = "Изменение пароля",
            CONTRACTORSAVEBUTTON = "Сохранить",
            PHONEFREFIX = "+7",
            SUCCESSSAVEMESSAGE = "Контрагент успешно сохранён!",
            CONTRACTORCLOSEAREABUTTON = "Закрыть",
            CONTRACTORDELETEMESSAGE = "Удалить клиента",
            SUCCESSDELETEMESSAGE = "Контрагент успешно удалён!";

    private final SelenideElement
            headerArea = $(".etc-header"),
            loginArea = $("#login"),
            loginFieald = $("input[type='email']"),
            passwordField = $("input[type='password']"),
            submitButton = $("#submitbutton"),
            navArea = $("#navbar"),
            logoutButton = $x("//*[@id=\"navbar\"]/ul/li[5]/a"),
            errorMessageArea = $("div.alert-danger"),
            leftMenuAccountArea = $("div.col-sm-3"),
            accountPageHeaderArea = $("div.page-header"),
            contractorAddButton = $("#contractorAdd"),
            fullTitleTextField = $("input[name='contractor[fullTitle]']"),
            titleTextField = $("input[name='contractor[title]']"),
            cityTextField = $("select[name='contractor[idCity]']"),
            addressTextField = $("input[name='contractor[address]']"),
            phoneIntField = $("input[name='contractor[phone]']"),
            emailTextField = $("input[name='contractor[email]']"),
            innIntField = $("input[name='contractor[inn]']"),
            kppIntField = $("input[name='contractor[kpp]']"),
            jurAddressTextField = $("input[name='contractor[jurAddress]']"),
            modalFooterArea = $("div.modal-footer"),
            contractorsDisplayArea = $("div.dataTables_scrollBody"),
            editContractorButton = $(".glyphicon-edit"),
            allertArea = $("div.alert-success"),
            closeEditContractorArea = $("div.text-right"),
            deleteContractorButton = $(".glyphicon-remove-circle"),
            deleteConfirmButton = $(".btn-danger");

    @Step("Открываем страницу входа в личный кабинет")
    public AccountArea openLoginPage() {
        headerArea.$(byText(SINGINLINK)).click();

        return this;
    }

    @Step("Проверяем, что открылась страница входа в личный кабинет")
    public AccountArea checkLoginPage() {
        loginArea.shouldHave(text(LOGINFORMTEXT));

        return this;
    }

    @Step("Вводим валидный логин в форму авторизации")
    public AccountArea typeValidLogin() {
        loginFieald.setValue(config.login());

        return this;
    }

    @Step("Вводим валидный пароль в форму авторизации")
    public AccountArea typeValidPassword() {
        passwordField.setValue(config.password());

        return this;
    }

    @Step("Нажимаем на кнопку \"Авторизоваться\"")
    public AccountArea submitAuthButton() {
        submitButton.click();

        return this;
    }

    @Step("Проверяем, что открылась главная страница личного кабинета")
    public AccountArea checkAccountMainPage() {
        navArea.shouldHave(text(USERNAMETEXT));

        return this;
    }

    @Step("Нажимаем на кнопку \"Выйти\"")
    public AccountArea submitlogoutButton() {
        logoutButton.click();

        return this;
    }

    @Step("Проверяем, что вход в личный кабинет не выполнен")
    public AccountArea checkAccountErrorPage() {
        errorMessageArea.shouldHave(text(ACCESSFORBIDDEN));

        return this;
    }

    @Step("Вводим невалидный логин в форму авторизации")
    public AccountArea typeInvalidLogin() {
        loginFieald.setValue(INVALIDLOGIN);

        return this;
    }

    @Step("Вводим невалидный пароль в форму авторизации")
    public AccountArea typeInvalidPassword() {
        passwordField.setValue(INVALIDPASSWORD);

        return this;
    }

    @Step("Открываем страницу \"Отправки и Получения\"")
    public AccountArea openSendReceivePage() {
        leftMenuAccountArea.$(byText(SENDRECEIVESECTION)).click();

        return this;
    }

    @Step("Проверяем, что открыта страница \"Отправки и Получения\"")
    public AccountArea checkSendReceivePage() {
        accountPageHeaderArea.shouldHave(text(SENDRECEIVESECTION));

        return this;
    }

    @Step("Открываем страницу \"Контрагенты\"")
    public AccountArea openContractorsPage() {
        leftMenuAccountArea.$(byText(CONTRACTORSSECTION)).click();

        return this;
    }

    @Step("Проверяем, что открыта страница \"Контрагенты\"")
    public AccountArea checkContractorsPage() {
        accountPageHeaderArea.shouldHave(text(CONTRACTORSSECTION));

        return this;
    }

    @Step("Открываем страницу \"Операции оплаты\"")
    public AccountArea openBillingPage() {
        leftMenuAccountArea.$(byText(BILLINGSECTION)).click();

        return this;
    }

    @Step("Проверяем, что открыта страница \"Операции оплаты\"")
    public AccountArea checkBillingPage() {
        accountPageHeaderArea.shouldHave(text(BILLINGSECTION));

        return this;
    }

    @Step("Открываем страницу \"Рабочий стол\"")
    public AccountArea openDescTopPage() {
        leftMenuAccountArea.$(byText(DESCTOPSECTION)).click();

        return this;
    }

    @Step("Проверяем, что открыта страница \"Рабочий стол\"")
    public AccountArea checkDescTopPage() {
        accountPageHeaderArea.shouldHave(text(DESCTOPSECTION));

        return this;
    }

    @Step("Открываем страницу \"Ключ разработчика\"")
    public AccountArea openApiPage() {
        navArea.$(byText(APISECTION)).click();
        $(byText(TOKENSECTION)).click();
        return this;
    }

    @Step("Проверяем, что открыта страница \"Ключ разработчика\"")
    public AccountArea checkApiPage() {
        accountPageHeaderArea.shouldHave(text(TOKENSECTION));

        return this;
    }

    @Step("Открываем страницу \"Профили\"")
    public AccountArea openProfilesPage() {
        navArea.$(byText(USERNAMETEXT)).click();
        $(byText(PROFILESECTION)).click();
        return this;
    }

    @Step("Проверяем, что открыта страница \"Профили\"")
    public AccountArea checkProfilesPage() {
        accountPageHeaderArea.shouldHave(text(PROFILESECTION));

        return this;
    }

    @Step("Открываем страницу \"Профили\"")
    public AccountArea openPassChangePage() {
        navArea.$(byText(USERNAMETEXT)).click();
        $(byText(CHANGEPASSTEXT)).click();
        return this;
    }

    @Step("Проверяем, что открыта страница \"Профили\"")
    public AccountArea checkPassChangePage() {
        accountPageHeaderArea.shouldHave(text(CHANGEPASSSECTION));

        return this;
    }

    @Step("Открываем страницу форму добавления нового адресата")
    public AccountArea openNewContractorFrom() {
        contractorAddButton.click();

        return this;
    }

    @Step("Создаем нового адресата")
    public AccountArea createNewContractor() {
        fullTitleTextField.setValue(TestData.name);
        titleTextField.setValue(TestData.lastName);
        cityTextField.click();
        $(byText(TestData.city + ", " + TestData.region)).click();
        addressTextField.setValue(TestData.address);
        phoneIntField.setValue(PHONEFREFIX + TestData.phone);
        emailTextField.setValue(TestData.email);
        innIntField.setValue(TestData.inn);
        kppIntField.setValue(TestData.kpp);
        jurAddressTextField.setValue(TestData.juraddress);
        modalFooterArea.$(byText(CONTRACTORSAVEBUTTON)).click();

        return this;
    }

    @Step("Проверяем, что новый адресат создан с правильными данными")
    public AccountArea checkNewContractorData() {
        contractorsDisplayArea.shouldHave(text(TestData.lastName));
        contractorsDisplayArea.shouldHave(text(TestData.name));
        contractorsDisplayArea.shouldHave(text(TestData.city));
        contractorsDisplayArea.shouldHave(text(TestData.address));
        contractorsDisplayArea.shouldHave(text(TestData.phone));
        contractorsDisplayArea.shouldHave(text(TestData.email));
        contractorsDisplayArea.shouldHave(text(TestData.inn));
        contractorsDisplayArea.shouldHave(text(TestData.kpp));
        contractorsDisplayArea.shouldHave(text(TestData.juraddress));

        return this;
    }

    @Step("Изменяем данные нового контрагента и проверяем изменения")
    public AccountArea changeNewContractorData() {
        editContractorButton.click();
        emailTextField.setValue(TestData.newemail);
        submitButton.click();
        allertArea.shouldHave(text(SUCCESSSAVEMESSAGE));
        closeEditContractorArea.$(byText(CONTRACTORCLOSEAREABUTTON)).click();
        contractorsDisplayArea.shouldHave(text(TestData.newemail));

        return this;
    }

    @Step("Удаляем нового контрагента")
    public AccountArea deleteNewContractorData() {
        deleteContractorButton.click();
        accountPageHeaderArea.shouldHave(text(CONTRACTORDELETEMESSAGE));
        deleteConfirmButton.click();
        allertArea.shouldHave(text(SUCCESSDELETEMESSAGE));

        return this;
    }

}


