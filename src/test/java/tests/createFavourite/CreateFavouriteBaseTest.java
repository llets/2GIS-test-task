package tests.createFavourite;

import constants.DateTimePatternConstants;
import constants.ResponsePathConstants;
import io.restassured.response.Response;
import models.CreateFavPlaceResponse;
import models.Place;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import requests.v1.favourites.FavRequest;
import tests.BaseTest;
import utils.ResponseUtils;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static utils.AssertUtils.assertStatusCode;

public class CreateFavouriteBaseTest extends BaseTest {

    protected void performFavouriteTest(Place place, int expectedStatusCode) {
        LogManager.getLogger().debug("Performing method to create favourite place test");
        OffsetDateTime utcTime = OffsetDateTime.now(ZoneOffset.UTC);
        Response response = FavRequest.performPost(this.cookie, place);

        assertStatusCode(response, expectedStatusCode);
        if (response.getStatusCode() == HttpStatus.SC_OK)
            assertResponseValues(response, place, utcTime, DateTimePatternConstants.ISO_DATE_TIME);
    }

    protected void assertResponseValues(Response response,
                                     Place place,
                                     OffsetDateTime nowDateTime,
                                     String dateTimePattern){
        LogManager.getLogger().info("Asserting response values");
        CreateFavPlaceResponse createFavPlaceResponse = ResponseUtils.getObject(
                response,
                ResponsePathConstants.ROOT,
                CreateFavPlaceResponse.class);
        Assert.assertEquals(createFavPlaceResponse.getPlace(), place,
                String.format("Actual place is %s but it should be %s",
                        createFavPlaceResponse.getPlace(),
                        place));
        Assert.assertTrue(nowDateTime.format(DateTimeFormatter.ofPattern(dateTimePattern))
                        .compareTo(OffsetDateTime.parse(createFavPlaceResponse.getCreated_at()).toString()) > 0,
                String.format("Actual time is %s but it should be %s",
                        createFavPlaceResponse.getCreated_at(),
                        nowDateTime.format(DateTimeFormatter.ofPattern(dateTimePattern))));
    }

}
