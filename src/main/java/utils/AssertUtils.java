package utils;

import io.restassured.response.Response;
import org.testng.Assert;

public class AssertUtils {

    public static void assertStatusCode(Response response, int statusCode) {
        int responseCode = ResponseUtils.getStatusCode(response);
        Assert.assertEquals(responseCode, statusCode,
                String.format("Status code is %d but it should be %d", responseCode, statusCode));
    }

}