package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.logging.log4j.LogManager;

import java.util.Map;

public class SpecificationUtils {

    private static final String baseUrl = ConfigAndDataUtils.getLoadedConfig().baseUrl();

    public static RequestSpecification getRequestSpecification() {
        LogManager.getLogger().debug("Getting request specification");
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification getRequestSpecification(Object object) {
        LogManager.getLogger().debug("Getting request specification with object parameter");
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .log(LogDetail.ALL)
                .build();
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> map = mapper.convertValue(object, new TypeReference<Map<String, Object>>() {});

            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    requestSpecification.formParam(entry.getKey(), entry.getValue());
                }
            }
            return requestSpecification;
        } catch (Exception e) {
            throw new RuntimeException("Error converting object to form params", e);
        }
    }

    public static ResponseSpecification getResponseJSONSpecification() {
        LogManager.getLogger().debug("Getting response json specification");
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification getResponseBINARYSpecification() {
        LogManager.getLogger().debug("Getting response binary specification");
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.BINARY)
                .log(LogDetail.ALL)
                .build();
    }

}