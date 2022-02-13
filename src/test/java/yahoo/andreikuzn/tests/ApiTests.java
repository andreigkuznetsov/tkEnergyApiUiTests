package yahoo.andreikuzn.tests;


import annotations.Microservice;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import yahoo.andreikuzn.pages.ApiArea;

public class ApiTests extends ApiTestBase {

    ApiArea ApiArea = new ApiArea();

    @Test
    @DisplayName("Успешный LogIn и LogOut")
    @Tags({@Tag("High"), @Tag("Smoke")})
    @Microservice("API")
    @Feature("Авторизация")
    @Story("Метод GET /login")
    @Severity(SeverityLevel.NORMAL)
    void logInLogOutTest() {
        ApiArea.loginAndGetUserToken();
        ApiArea.logOutAccount();
        ApiArea.logOutAccountCheck();

    }

    @Test
    @DisplayName("Создание и удаление накладной на перевозку")
    void deliveryBillCreateDeleteTest() {
        ApiArea.loginAndGetUserToken();
        Long firstContractorId = ApiArea.createFirstContractor();
        Long secondContractorId = ApiArea.createSecondContractor();
        ApiArea.createDeliveryBill(firstContractorId, secondContractorId);
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
    void accountUserTest() {
        ApiArea.loginAndGetUserToken();
        ApiArea.getAccountUser();
        ApiArea.logOutAccount();
        ApiArea.logOutAccountCheck();

    }

    @Test
    @DisplayName("Получение списка городов обслуживания")
    void citiesTest() {
        ApiArea.loginAndGetUserToken();
        ApiArea.getCities();
        ApiArea.logOutAccount();
        ApiArea.logOutAccountCheck();

    }

    @Test
    @DisplayName("Поиск города по индексу")
    void searchCityTest() {
        ApiArea.loginAndGetUserToken();
        ApiArea.searchCity();
        ApiArea.logOutAccount();
        ApiArea.logOutAccountCheck();

    }

}
