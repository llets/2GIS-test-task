package requests.v1.auth.tokens;

import io.restassured.response.Response;
import utils.ApiUtils;

public class TokenRequest {

    private static final String endpoint = "/v1/auth/tokens";

    public static Response performPost(){
        return ApiUtils.postExpectedBinary(endpoint);
    }

}
