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

    public static ResponseSpecification response200Spec = new ResponseSpecBuilder()
            .log(BODY)
            .expectStatusCode(200)
            .build();

    public static ResponseSpecification response201Spec = new ResponseSpecBuilder()
            .log(BODY)
            .expectStatusCode(201)
            .build();

    public static ResponseSpecification response404Spec = new ResponseSpecBuilder()
            .log(BODY)
            .expectStatusCode(404)
            .build();

    public static ResponseSpecification response401Spec = new ResponseSpecBuilder()
            .log(BODY)
            .expectStatusCode(401)
            .build();

}



