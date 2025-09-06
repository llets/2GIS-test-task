package requests.v1.favourites;

import io.restassured.http.Cookie;
import io.restassured.response.Response;
import utils.ApiUtils;

public class FavRequest {

    private static final String endpoint = "/v1/favorites";

    public static Response performPost(Cookie cookie, Object body){
        return ApiUtils.postWithCookieExpectedJSON(endpoint, cookie, body);
    }

}
