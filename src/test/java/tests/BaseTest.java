package tests;

import io.restassured.RestAssured;
import io.restassured.config.DecoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import models.Place;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import requests.v1.auth.tokens.TokenRequest;
import utils.ConfigAndDataUtils;

import java.util.List;

import static io.restassured.config.EncoderConfig.*;

public class BaseTest {

    protected Cookie cookie = null;

    @BeforeClass
    public static void setup() {
        RestAssured.config = RestAssuredConfig.config()
                .encoderConfig(encoderConfig()
                        .defaultContentCharset("UTF-8"))
                .decoderConfig(DecoderConfig.decoderConfig()
                        .defaultContentCharset("UTF-8"));
    }

    @BeforeMethod
    public void getToken() {
        Response response = TokenRequest.performPost();
        System.out.println(response.getCookie("token"));
        this.cookie = new Cookie.Builder("token", response.getCookie("token")).build();
    }

    public static Object[][] getTestData(String testsName) {
        List<Place> places = ConfigAndDataUtils.loadTestsDataFromJson(testsName, Place.class);
        Object[][] obj = new Object[places.size()][];
        for (int i = 0; i < places.size(); i++) {
            obj[i] = new Object[]{places.get(i)};
        }
        return obj;
    }

}