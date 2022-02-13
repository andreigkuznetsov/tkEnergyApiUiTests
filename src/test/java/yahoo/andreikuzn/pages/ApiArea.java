package yahoo.andreikuzn.pages;

import io.qameta.allure.Step;
import lombok.*;

import static base.ApiEndpoints.*;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.RestAssuredSpec.*;
import static yahoo.andreikuzn.tests.ApiTestBase.apiConfig;
import static yahoo.andreikuzn.tests.TestData.*;

public class ApiArea {

    public static final TokenResponseData TOKEN_RESPONSE_DATA = new TokenResponseData();
    public static final CreateFirstContractor ID_FIRST_CONTRACTOR = new CreateFirstContractor();
    public static final CreateSecondContractor ID_SECOND_CONTRACTOR = new CreateSecondContractor();
    public static final CreateInvoice INVOICE_ID = new CreateInvoice();

    public static final String LOGIN = apiConfig.login();
    public static final String PASSWORD = apiConfig.password();
    public static final String ACCOUNT_ID = apiConfig.accountId();
    public static final String ACCOUNT_USER_ID = apiConfig.accountUserId();
    public static final String ACCOUNT_USER_PHONE = apiConfig.accountUserPhone();

    @Step("Вход в аккаунт и получение токена")
    public void loginAndGetUserToken() {

        TokenResponseData tokenResponseData
                = given(requestSpec)
                .header("Accept", "application/json")
                .get(userLogin)
                .then()
                .spec(responseSpec200)
                .body(matchesJsonSchemaInClasspath("shemas/LoginGetTokenScheme.json"))
                .extract().as(TokenResponseData.class);

        assertThat(tokenResponseData.getToken()).isNotNull();
        assertThat(tokenResponseData.getType()).isEqualTo(type);
        assertThat(tokenResponseData.getAccountId()).isNotNull();
        TOKEN_RESPONSE_DATA.setToken(tokenResponseData.getToken());

    }

    @Step("Создание первого клиента")
    public Long createFirstContractor() {

        CreateFirstContractor createFirstContractor =
                given(requestSpec)
                        .contentType(JSON)
                        .body(firstContractorData)
                        .when()
                        .post(createContractor + TOKEN_RESPONSE_DATA.getToken())
                        .then()
                        .spec(responseSpec201)
                        .body(matchesJsonSchemaInClasspath("shemas/SuccessCreateContractorScheme.json"))
                        .extract().as(CreateFirstContractor.class);

        assertThat(createFirstContractor.getId()).isNotNull();
        assertThat(createFirstContractor.getUrl()).isNotNull();
        ID_FIRST_CONTRACTOR.setId(createFirstContractor.getId());
        return createFirstContractor.getId();

    }

    @Step("Создание второго клиента")
    public Long createSecondContractor() {

        CreateSecondContractor createSecondContractor =
                given(requestSpec)
                        .contentType(JSON)
                        .body(secondContractorData)
                        .when()
                        .post(createContractor + TOKEN_RESPONSE_DATA.getToken())
                        .then()
                        .spec(responseSpec201)
                        .body(matchesJsonSchemaInClasspath("shemas/SuccessCreateContractorScheme.json"))
                        .extract().as(CreateSecondContractor.class);

        assertThat(createSecondContractor.getId()).isNotNull();
        assertThat(createSecondContractor.getUrl()).isNotNull();
        ID_SECOND_CONTRACTOR.setId(createSecondContractor.getId());
        return createSecondContractor.getId();
    }

    @Step("Создание накладной на перевозку")
    public Long createDeliveryBill(Long firstContractorId, Long secondContractorId) {

        String deliveryBillData = getDelliveryBillData(firstContractorId, secondContractorId);
        CreateInvoice createinvoice =
                given(requestSpec)
                        .contentType(JSON)
                        .body(deliveryBillData)
                        .when()
                        .post(createDeliveryBill + TOKEN_RESPONSE_DATA.getToken())
                        .then()
                        .spec(responseSpec200)
                        .body(matchesJsonSchemaInClasspath("shemas/SuccessCreateDeliveryBillScheme.json"))
                        .extract().as(CreateInvoice.class);

        assertThat(createinvoice.getId()).isNotNull();
        assertThat(createinvoice.getUrl()).isNotNull();
        INVOICE_ID.setId(createinvoice.getId());
        return createinvoice.getId();
    }

    @Step("Получение данных о созданной накладной на перевозку")
    public void getDeliveryBillStatus() {

        InvoiceStatus invoiceStatus =
                given(requestSpec)
                        .header("Accept", "application/json")
                        .get(getDeliveryBill + INVOICE_ID.getId() + "?token="
                                + TOKEN_RESPONSE_DATA.getToken() + "&barcodes=false")
                        .then()
                        .spec(responseSpec200)
                        .extract().as(InvoiceStatus.class);

        assertThat(invoiceStatus.getClientFromAgent()).isEqualTo(clientFromAgent);
        assertThat(invoiceStatus.getIdClientFrom()).isEqualTo(ID_FIRST_CONTRACTOR.getId());
        assertThat(invoiceStatus.getIdClientTo()).isEqualTo(ID_SECOND_CONTRACTOR.getId());
        assertThat(invoiceStatus.getIdClientPayer()).isEqualTo(ID_SECOND_CONTRACTOR.getId());
        assertThat(invoiceStatus.getIdCityFrom()).isEqualTo(idCityFrom);
        assertThat(invoiceStatus.getIdCityTo()).isEqualTo(idCityTo);
        assertThat(invoiceStatus.getCityFromTitle()).isEqualTo(cityFromTitle);
        assertThat(invoiceStatus.getCityToTitle()).isEqualTo(cityToTitle);
        assertThat(invoiceStatus.getIdWareFrom()).isEqualTo(idWareFrom);
        assertThat(invoiceStatus.getIdWareTo()).isEqualTo(idWareTo);
        assertThat(invoiceStatus.getDescription()).isEqualTo(description);
        assertThat(invoiceStatus.getPriceFreight()).isEqualTo(priceFreight);
        assertThat(invoiceStatus.getPackaging()).isEqualTo(packaging);
        assertThat(invoiceStatus.getCargoname()).isEqualTo(cargoname);

    }

    @Step("Удаление созданной накладной на перевозку")
    public void deleteDeliveryBill() {

        DeleteAction deleteAction =
                given(requestSpec)
                        .header("Accept", "application/json")
                        .delete(delDeliveryBill + INVOICE_ID.getId() + "?token="
                                + TOKEN_RESPONSE_DATA.getToken())
                        .then()
                        .spec(responseSpec200)
                        .body(matchesJsonSchemaInClasspath("shemas/DeleteActionScheme.json"))
                        .extract().as(DeleteAction.class);

        assertEquals(code, deleteAction.getCode());
        assertEquals(message, deleteAction.getMessage());

    }

    @Step("Подтверждение удаления накладной на перевозку")
    public void getDeliveryBillStatusDel() {

        DeleteConfirmAction deleteConfirmAction =
                given(requestSpec)
                        .header("Accept", "application/json")
                        .get(getDeliveryBill + INVOICE_ID.getId() + "?token="
                                + TOKEN_RESPONSE_DATA.getToken() + "&barcodes=false")
                        .then()
                        .spec(responseSpec404)
                        .extract().as(DeleteConfirmAction.class);

        assertThat(deleteConfirmAction.getNotFoundCode()).isEqualTo(NotFoundCode);
        assertThat(deleteConfirmAction.getNotFoundMessage()).isEqualTo(NotFoundMessage);

    }

    @Step("Удаление первого клиента")
    public void deleteFirstContractorUser() {

        DeleteAction deleteAction =
                given(requestSpec)
                        .header("Accept", "application/json")
                        .delete(delFirstContractor + ID_FIRST_CONTRACTOR.getId()
                                + "?token=" + TOKEN_RESPONSE_DATA.getToken())
                        .then()
                        .spec(responseSpec200)
                        .body(matchesJsonSchemaInClasspath("shemas/DeleteActionScheme.json"))
                        .extract().as(DeleteAction.class);

        assertEquals(code, deleteAction.getCode());
        assertEquals(message, deleteAction.getMessage());

    }

    @Step("Проверка удаления первого клиента")
    public void getFirstContractorData() {

        DeleteConfirmAction deleteConfirmAction =
                given(requestSpec)
                        .header("Accept", "application/json")
                        .get(getFirstContractorData + ID_FIRST_CONTRACTOR.getId()
                                + "?token=" + TOKEN_RESPONSE_DATA.getToken())
                        .then()
                        .spec(responseSpec404)
                        .body(matchesJsonSchemaInClasspath("shemas/NoContactorsScheme.json"))
                        .extract().as(DeleteConfirmAction.class);

        assertThat(deleteConfirmAction.getNotFoundCode()).isEqualTo(NotFoundCode);
        assertThat(deleteConfirmAction.getNotFoundMessage()).isEqualTo(NotFoundMessage);

    }

    @Step("Удаление второго клиента")
    public void deleteSecondContractorUser() {

        DeleteAction deleteAction =
                given(requestSpec)
                        .header("Accept", "application/json")
                        .delete(delSecondContractor + ID_SECOND_CONTRACTOR.getId()
                                + "?token=" + TOKEN_RESPONSE_DATA.getToken())
                        .then()
                        .spec(responseSpec200)
                        .body(matchesJsonSchemaInClasspath("shemas/DeleteActionScheme.json"))
                        .extract().as(DeleteAction.class);

        assertEquals(code, deleteAction.getCode());
        assertEquals(message, deleteAction.getMessage());

    }

    @Step("Проверка удаления второго клиента")
    public void getSecondContractorData() {

        DeleteConfirmAction deleteConfirmAction =
                given(requestSpec)
                        .header("Accept", "application/json")
                        .get(getSecondContractorData + ID_SECOND_CONTRACTOR.getId()
                                + "?token=" + TOKEN_RESPONSE_DATA.getToken())
                        .then()
                        .spec(responseSpec404)
                        .body(matchesJsonSchemaInClasspath("shemas/NoContactorsScheme.json"))
                        .extract().as(DeleteConfirmAction.class);

        assertThat(deleteConfirmAction.getNotFoundCode()).isEqualTo(NotFoundCode);
        assertThat(deleteConfirmAction.getNotFoundMessage()).isEqualTo(NotFoundMessage);
    }

    @Step("Выход из аккаунта с закрытием всех сессий")
    public void logOutAccount() {

        DeleteAction deleteAction =
                given(requestSpec)
                .header("Accept", "application/json")
                .get(logOutAccount + TOKEN_RESPONSE_DATA.getToken() + "&allSessions=true")
                .then()
                .spec(responseSpec200)
                .body(matchesJsonSchemaInClasspath("shemas/DeleteActionScheme.json"))
                .extract().as(DeleteAction.class);

        assertEquals(code, deleteAction.getCode());
        assertEquals(message, deleteAction.getMessage());

    }

    @Step("Проверка успешного выхода из аккаута")
    public void logOutAccountCheck() {

        LogOutAccountCheck logOutAccountCheck
                = given(requestSpec)
                .header("Accept", "application/json")
                .get(logOutAccount + TOKEN_RESPONSE_DATA.getToken() + "&allSessions=true")
                .then()
                .spec(responseSpec401)
                .body(matchesJsonSchemaInClasspath("shemas/DeleteActionScheme.json"))
                .extract().as(LogOutAccountCheck.class);

        assertThat(logOutAccountCheck.getNotAuthCode()).isEqualTo(notAuthCode);
        assertThat(logOutAccountCheck.getNotAuthMessage()).isEqualTo(notAuthMessage);

    }

    @Step("Получение пользователя аккаунта")
    public void getAccountUser() {

        GetAccountUser getAccountUser =
                given(requestSpec)
                        .header("Accept", "application/json")
                        .get(getAccountUsers + TOKEN_RESPONSE_DATA.getToken())
                        .then()
                        .spec(responseSpec200)
                        .body(matchesJsonSchemaInClasspath("shemas/GetUserScheme.json"))
                        .extract().as(GetAccountUser.class);

        assertThat(getAccountUser.getIdCity()).isEqualTo(idCityFrom);
        assertThat(getAccountUser.getTitle()).isEqualTo(accountUser);
        assertThat(getAccountUser.getFulltitle()).isEqualTo(accountUser);
        assertThat(getAccountUser.getPhone()).isEqualTo(ACCOUNT_USER_PHONE);
        assertThat(getAccountUser.getEmail()).isEqualTo(LOGIN);

    }

    @Step("Получение данных о городах обслуживания")
    public void getCities() {

        CityList cityList =
                given(requestSpec)
                        .header("Accept", "application/json")
                        .get("/cities?lang=ru")
                        .then()
                        .spec(responseSpec200)
                        .extract().as(CityList.class);

        assertEquals(cityId, cityList.getCityList()[1].getId());
        assertEquals(cityName, cityList.getCityList()[1].getName());
        assertEquals(cityParentId, cityList.getCityList()[1].getParentId());
        assertEquals(cityDescription, cityList.getCityList()[1].getDescription());
        assertEquals(cityType, cityList.getCityList()[1].getType());
        assertEquals(cityDefaultIdWare, cityList.getCityList()[1].getDefaultIdWare());

    }

    @Step("Получение данных о валютах и текущих курсах")
    public void searchCity() {

        SearchCity searchCity =
                given(requestSpec)
                        .header("Accept", "application/json")
                        .get(searchCityByZip + cityzip)
                        .then()
                        .spec(responseSpec200)
                        .extract().as(SearchCity.class);

        assertEquals(idCityTo, searchCity.getId());
        assertEquals(cityToTitleS, searchCity.getName());

    }

}
