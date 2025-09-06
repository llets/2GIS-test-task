package utils;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;

public class ResponseUtils {

    public static int getStatusCode(Response response) {
        LogManager.getLogger().debug("Getting status code from response");
        return response.getStatusCode();
    }

    public static <T> T getObject(Response response, String pathToObject, Class<T> clazz) {
        LogManager.getLogger().debug("Getting object from response body");
        return response.body().jsonPath().getObject(pathToObject, clazz);
    }

}