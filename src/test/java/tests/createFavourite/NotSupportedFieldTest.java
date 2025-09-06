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

import java.lang.reflect.Field;

import static utils.AssertUtils.assertStatusCode;

public class NotSupportedFieldTest extends BaseTest {

    Place place;

    @BeforeMethod
    public void appSetup() {
        place = ConfigAndDataUtils.loadSingleTestDataFromJson("TokenTest", Place.class);
    }

    @Test
    public void passNotSupportedFieldTest() throws NoSuchFieldException, IllegalAccessException {
        LogManager.getLogger().info("Running create favourite place test with not supported fields");
        Field unknownField = place.getClass().getDeclaredField("unknownField");
        unknownField.setAccessible(true);
        unknownField.set(place, "extraValue");

        Response response = FavRequest.performPost(this.cookie, place);

        assertStatusCode(response, HttpStatus.SC_BAD_REQUEST);
    }

}
