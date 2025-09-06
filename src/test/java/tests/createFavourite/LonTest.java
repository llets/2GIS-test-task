package tests.createFavourite;

import models.Place;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.BaseTest;

public class LonTest extends CreateFavouriteBaseTest {

    @DataProvider(name = "getInvalidLonRequirementTests")
    public static Object[][] getInvalidLonRequirementTests() {
        return BaseTest.getTestData("InvalidLonRequirementTests");
    }

    @Test(dataProvider = "getInvalidLonRequirementTests")
    public void createFavInvalidLonRequirementTest(Place place){
        LogManager.getLogger().info("Running create favourite place test with invalid lon. Place: {}", place);
        performFavouriteTest(place, HttpStatus.SC_BAD_REQUEST);
    }

    @DataProvider(name = "getValidLonRequirementTests")
    public static Object[][] getValidLonRequirementTests() {
        return BaseTest.getTestData("ValidLonRequirementTests");
    }

    @Test(dataProvider = "getValidLonRequirementTests")
    public void createFavValidLonRequirementTest(Place place){
        LogManager.getLogger().info("Running create favourite place test with valid lon. Place: {}", place);
        performFavouriteTest(place, HttpStatus.SC_OK);
    }

}
