package tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ContractorSteps {
    private final String CONTRACTORSAVEBUTTON = "Сохранить",
            PHONEFREFIX = "+7",
            SUCCESSSAVEMESSAGE = "Контрагент успешно сохранён!",
            CONTRACTORCLOSEAREABUTTON = "Закрыть",
            CONTRACTORDELETEMESSAGE = "Удалить клиента",
            SUCCESSDELETEMESSAGE = "Контрагент успешно удалён!";

    private final SelenideElement
            submitButton = $("#submitbutton"),
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

    @Step("Открываем страницу форму добавления нового адресата")
    public ContractorSteps openNewContractorFrom() {
        contractorAddButton.click();
        return this;
    }

    @Step("Создаем нового адресата")
    public ContractorSteps createNewContractor() {
        fullTitleTextField.setValue(TestData.firstContractorName);
        titleTextField.setValue(TestData.firstContractorLastName);
        cityTextField.click();
        $(byText(TestData.city + ", " + TestData.region)).click();
        addressTextField.setValue(TestData.firstContractorAddress);
        phoneIntField.setValue(PHONEFREFIX + TestData.firstContractorPhone);
        emailTextField.setValue(TestData.firstContractorEmail);
        innIntField.setValue(TestData.firstContractorInn);
        kppIntField.setValue(TestData.firstContractorKpp);
        jurAddressTextField.setValue(TestData.firstContractorJurAddress);
        modalFooterArea.$(byText(CONTRACTORSAVEBUTTON)).click();
        return this;
    }

    @Step("Проверяем, что новый адресат создан с правильными данными")
    public ContractorSteps checkNewContractorData() {
        contractorsDisplayArea.shouldHave(text(TestData.firstContractorLastName))
                .shouldHave(text(TestData.firstContractorName))
                .shouldHave(text(TestData.city))
                .shouldHave(text(TestData.firstContractorAddress))
                .shouldHave(text(TestData.firstContractorPhone))
                .shouldHave(text(TestData.firstContractorEmail))
                .shouldHave(text(TestData.firstContractorInn))
                .shouldHave(text(TestData.firstContractorKpp))
                .shouldHave(text(TestData.firstContractorJurAddress));
        return this;
    }

    @Step("Изменяем данные нового контрагента и проверяем изменения")
    public ContractorSteps changeNewContractorData() {
        editContractorButton.click();
        emailTextField.setValue(TestData.firstContractorNewEmail);
        submitButton.click();
        allertArea.shouldHave(text(SUCCESSSAVEMESSAGE));
        closeEditContractorArea.$(byText(CONTRACTORCLOSEAREABUTTON)).click();
        contractorsDisplayArea.shouldHave(text(TestData.firstContractorNewEmail));
        return this;
    }

    @Step("Удаляем нового контрагента")
    public ContractorSteps deleteNewContractorData() {
        deleteContractorButton.click();
        accountPageHeaderArea.shouldHave(text(CONTRACTORDELETEMESSAGE));
        deleteConfirmButton.click();
        allertArea.shouldHave(text(SUCCESSDELETEMESSAGE));
        return this;
    }
}
