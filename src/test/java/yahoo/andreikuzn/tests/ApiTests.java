package yahoo.andreikuzn.tests;


import annotations.JiraIssue;
import annotations.JiraIssues;
import annotations.Layer;
import annotations.Microservice;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import yahoo.andreikuzn.pages.ApiArea;


@Tag("API")
@JiraIssues({@JiraIssue("HOMEWORK-334")})
@DisplayName("Тестирование API сервиса транспортной компании Энергия")
public class ApiTests extends ApiTestBase {

    ApiArea ApiArea = new ApiArea();

    @Test
    @DisplayName("Успешный LogIn и LogOut")
    @Layer("API Tests")
    @Owner("Andrei Kuznetsov")
    @Tags({@Tag("High"), @Tag("Smoke"), @Tag("Regress")})
    @Microservice("API")
    @Feature("Авторизация")
    @Story("Метод GET /login")
    @Severity(SeverityLevel.BLOCKER)
    void logInLogOutTest() {
        ApiArea.loginAndGetUserToken();
        ApiArea.logOutAccount();
        ApiArea.logOutAccountCheck();

    }

    @Test
    @DisplayName("Создание и удаление накладной на перевозку")
    @Layer("API Tests")
    @Owner("Andrei Kuznetsov")
    @Tags({@Tag("High"), @Tag("Regress")})
    @Microservice("API")
    @Feature("Накладная на перевозку")
    @Story("Метод POST /sendings")
    @Severity(SeverityLevel.CRITICAL)
    void deliveryBillCreateDeleteTest() {
        ApiArea.loginAndGetUserToken();
        ApiArea.createFirstContractor();
        ApiArea.createSecondContractor();
        ApiArea.createDeliveryBill();
        ApiArea.getDeliveryBillStatus();
        ApiArea.deleteDeliveryBill();
        ApiArea.getDeliveryBillStatusDel();
        ApiArea.deleteFirstContractorUser();
        ApiArea.getFirstContractorData();
        ApiArea.deleteSecondContractorUser();
        ApiArea.getSecondContractorData();
        ApiArea.logOutAccount();
        ApiArea.logOutAccountCheck();

    }

    @Test
    @DisplayName("Получение данных о пользователе аккаунта")
    @Layer("API Tests")
    @Owner("Andrei Kuznetsov")
    @Tags({@Tag("High"), @Tag("Smoke"), @Tag("Regress")})
    @Microservice("API")
    @Feature("Пользователь аккаунта")
    @Story("Метод GET /users")
    @Severity(SeverityLevel.BLOCKER)
    void accountUserTest() {
        ApiArea.loginAndGetUserToken();
        ApiArea.getAccountUser();
        ApiArea.logOutAccount();
        ApiArea.logOutAccountCheck();

    }

    @Test
    @DisplayName("Получение списка городов обслуживания")
    @Layer("API Tests")
    @Owner("Gleb Danilov")
    @Tags({@Tag("Low"), @Tag("Regress")})
    @Microservice("API")
    @Feature("Города обслуживания")
    @Story("Метод GET /cities")
    @Severity(SeverityLevel.NORMAL)
    void citiesTest() {
        ApiArea.loginAndGetUserToken();
        ApiArea.getCities();
        ApiArea.logOutAccount();
        ApiArea.logOutAccountCheck();

    }

    @Test
    @DisplayName("Поиск города по индексу")
    @Layer("API Tests")
    @Owner("Gleb Danilov")
    @Tags({@Tag("Low"), @Tag("Regress")})
    @Microservice("API")
    @Feature("Города обслуживания")
    @Story("Метод GET /search/city")
    @Severity(SeverityLevel.NORMAL)
    void searchCityTest() {
        ApiArea.loginAndGetUserToken();
        ApiArea.searchCity();
        ApiArea.logOutAccount();
        ApiArea.logOutAccountCheck();

    }

}
