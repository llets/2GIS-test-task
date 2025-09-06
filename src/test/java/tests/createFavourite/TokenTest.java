package tests.createFavourite;

import io.restassured.response.Response;
import models.Place;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import requests.v1.favourites.FavRequest;
import tests.BaseTest;
import utils.ConfigAndDataUtils;

import static utils.AssertUtils.assertStatusCode;

public class TokenTest extends BaseTest {

    Place place;

    @BeforeMethod
    public void appSetup() {
        place = ConfigAndDataUtils.loadSingleTestDataFromJson("TokenTest", Place.class);
    }

    @Test
    public void createFavWithExpiredToken() throws InterruptedException {
        LogManager.getLogger().info("Running create favourite place test with expired token");
        LogManager.getLogger().info("Thread sleep for 5000 millis");
        Thread.sleep(5000);
        Response response = FavRequest.performPost(this.cookie, place);
        assertStatusCode(response, HttpStatus.SC_UNAUTHORIZED);
    }

}
