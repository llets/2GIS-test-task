package tests.createFavourite;

import constants.PatternConstants;
import constants.ResponsePathConstants;
import io.restassured.response.Response;
import models.CreateFavPlaceResponse;
import models.Place;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import requests.v1.favourites.FavRequest;
import tests.BaseTest;
import utils.ConfigAndDataUtils;
import utils.ResponseUtils;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static utils.AssertUtils.assertStatusCode;

public class CreateFavouriteBaseTest extends BaseTest {

    public static Object[][] getTests(String testsName) {
        List<Place> places = ConfigAndDataUtils.loadTestsDataFromJson(testsName, Place.class);
        Object[][] obj = new Object[places.size()][];
        for (int i = 0; i < places.size(); i++) {
            obj[i] = new Object[]{places.get(i)};
        }
        return obj;
    }

    protected void performFavouriteTest(Place place, int expectedStatusCode) {
        OffsetDateTime utcTime = OffsetDateTime.now(ZoneOffset.UTC);
        Response response = FavRequest.performPost(this.cookie, place);

        assertStatusCode(response, expectedStatusCode);
        if (response.getStatusCode() == HttpStatus.SC_OK)
            assertResponseValues(response, place, utcTime, PatternConstants.ISO_DATE_TIME);
    }

    protected void assertResponseValues(Response response,
                                     Place place,
                                     OffsetDateTime nowDateTime,
                                     String dateTimePattern){
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
