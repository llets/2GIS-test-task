package requests.v1.auth.tokens;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import utils.ApiUtils;

public class TokenRequest {

    private static final String endpoint = "/v1/auth/tokens";

    public static Response performPost(){
        LogManager.getLogger().debug("Sending request to create token");
        return ApiUtils.postExpectedBinary(endpoint);
    }

}
