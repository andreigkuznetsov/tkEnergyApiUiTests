package tests.apiTests;

import configuration.ApiConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import tests.api.ApiSteps;

public class ApiTestBase {
    ApiSteps apiSteps = new ApiSteps();
    public static ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());

    @BeforeAll
    static void startUrl() {
        RestAssured.baseURI = apiConfig.getBaseUrl();
    }
}
