package tests.apiTests;


import annotations.JiraIssue;
import annotations.JiraIssues;
import annotations.Layer;
import annotations.Microservice;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;


@Tag("API")
@JiraIssues({@JiraIssue("HOMEWORK-334")})
@DisplayName("Тестирование API сервиса транспортной компании Энергия")
public class ApiTests extends ApiTestBase {
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
        apiSteps.loginAndGetUserToken();
        apiSteps.logOutAccount();
        apiSteps.logOutAccountCheck();
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
        apiSteps.loginAndGetUserToken();
        apiSteps.createFirstContractor();
        apiSteps.createSecondContractor();
        apiSteps.createDeliveryBill();
        apiSteps.getDeliveryBillStatus();
        apiSteps.deleteDeliveryBill();
        apiSteps.getDeliveryBillStatusDel();
        apiSteps.deleteFirstContractorUser();
        apiSteps.getFirstContractorData();
        apiSteps.deleteSecondContractorUser();
        apiSteps.getSecondContractorData();
        apiSteps.logOutAccount();
        apiSteps.logOutAccountCheck();
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
        apiSteps.loginAndGetUserToken();
        apiSteps.getAccountUser();
        apiSteps.logOutAccount();
        apiSteps.logOutAccountCheck();
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
        apiSteps.loginAndGetUserToken();
        apiSteps.getCities();
        apiSteps.logOutAccount();
        apiSteps.logOutAccountCheck();
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
        apiSteps.loginAndGetUserToken();
        apiSteps.searchCity();
        apiSteps.logOutAccount();
        apiSteps.logOutAccountCheck();
    }
}
