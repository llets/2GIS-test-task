package utils;

import io.restassured.response.Response;

public class ResponseUtils {

    public static int getStatusCode(Response response) {
        return response.getStatusCode();
    }

    public static <T> T getObject(Response response, String pathToObject, Class<T> clazz) {
        return response.body().jsonPath().getObject(pathToObject, clazz);
    }

}