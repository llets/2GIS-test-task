package utils;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;

public class ApiUtils {

    public static Response postExpectedBinary(String endpoint){
        LogManager.getLogger().debug("Sending post request with expected binary response");
        return RestAssured.given(SpecificationUtils.getRequestSpecification())
                .when()
                .post(endpoint)
                .then()
                .spec(SpecificationUtils.getResponseBINARYSpecification())
                .extract()
                .response();
    }

    public static Response postWithCookieExpectedJSON(String endpoint, Cookie cookie, Object body){
        LogManager.getLogger().debug("Sending post request with cookie and expected json response");
        return RestAssured.given(SpecificationUtils.getRequestSpecification(body))
                .cookie(cookie)
                .when()
                .post(endpoint)
                .then()
                .spec(SpecificationUtils.getResponseJSONSpecification())
                .extract()
                .response();
    }

}
