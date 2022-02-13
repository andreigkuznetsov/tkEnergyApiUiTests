package yahoo.andreikuzn.tests;

import configuration.ApiConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class ApiTestBase {

    public static ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());

    @BeforeAll
    static void startUrl() {
        RestAssured.baseURI = apiConfig.getBaseUrl();

    }

}
