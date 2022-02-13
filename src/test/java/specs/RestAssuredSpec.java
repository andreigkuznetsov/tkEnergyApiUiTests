package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static filters.CustomLogFilter.customLogFilter;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static yahoo.andreikuzn.tests.ApiTestBase.apiConfig;

public class RestAssuredSpec {

    public static RequestSpecification requestSpec =
            with()
                    .filter(customLogFilter().withCustomTemplates())
                    .log().uri()
                    .log().body()
                    .header("NrgApi-DevToken", apiConfig.nrgApiDevToken());

    public static ResponseSpecification responseSpec200 = new ResponseSpecBuilder()
            .log(BODY)
            .expectStatusCode(200)
            .build();

    public static ResponseSpecification responseSpec201 = new ResponseSpecBuilder()
            .log(BODY)
            .expectStatusCode(201)
            .build();

    public static ResponseSpecification responseSpec404 = new ResponseSpecBuilder()
            .log(BODY)
            .expectStatusCode(404)
            .build();

    public static ResponseSpecification responseSpec401 = new ResponseSpecBuilder()
            .log(BODY)
            .expectStatusCode(401)
            .build();

}



