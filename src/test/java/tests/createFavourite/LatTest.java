package tests.createFavourite;

import models.Place;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.BaseTest;

public class LatTest extends CreateFavouriteBaseTest {

    @DataProvider(name = "getInvalidLatRequirementTests")
    public static Object[][] getInvalidLatRequirementTests() {
        return BaseTest.getTestData("InvalidLatRequirementTests");
    }

    @Test(dataProvider = "getInvalidLatRequirementTests")
    public void createFavInvalidLatRequirementTest(Place place){
        LogManager.getLogger().info("Running create favourite place test with invalid lat. Place: {}", place);
        performFavouriteTest(place, HttpStatus.SC_BAD_REQUEST);
    }

    @DataProvider(name = "getValidLatRequirementTests")
    public static Object[][] getValidLonRequirementTests() {
        return BaseTest.getTestData("ValidLatRequirementTests");
    }

    @Test(dataProvider = "getValidLatRequirementTests")
    public void createFavValidLatRequirementTest(Place place){
        LogManager.getLogger().info("Running create favourite place test with valid lat. Place: {}", place);
        performFavouriteTest(place, HttpStatus.SC_OK);
    }

}
