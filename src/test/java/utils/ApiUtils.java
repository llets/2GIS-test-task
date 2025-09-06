package utils;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

public class ApiUtils {

    public static Response postExpectedBinary(String endpoint){
        return RestAssured.given(SpecificationUtils.getRequestSpecification())
                .when()
                .post(endpoint)
                .then()
                .spec(SpecificationUtils.getResponseBINARYSpecification())
                .extract()
                .response();
    }

    public static Response postWithCookieExpectedJSON(String endpoint, Cookie cookie, Object body){
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
