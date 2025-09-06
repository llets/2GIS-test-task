package tests.createFavourite;

import models.Place;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LatTest extends CreateFavouriteBaseTest {

    @DataProvider(name = "getInvalidLatRequirementTests")
    public static Object[][] getInvalidLatRequirementTests() {
        return CreateFavouriteBaseTest.getTestData("InvalidLatRequirementTests");
    }

    @Test(dataProvider = "getInvalidLatRequirementTests")
    public void createFavInvalidLatRequirementTest(Place place){
        performFavouriteTest(place, HttpStatus.SC_BAD_REQUEST);
    }

    @DataProvider(name = "getValidLatRequirementTests")
    public static Object[][] getValidLonRequirementTests() {
        return CreateFavouriteBaseTest.getTestData("ValidLatRequirementTests");
    }

    @Test(dataProvider = "getValidLatRequirementTests")
    public void createFavValidLatRequirementTest(Place place){
        performFavouriteTest(place, HttpStatus.SC_OK);
    }

}
