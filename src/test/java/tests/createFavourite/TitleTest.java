package tests.createFavourite;

import models.Place;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.BaseTest;

public class TitleTest extends CreateFavouriteBaseTest {

    @DataProvider(name = "getInvalidTitleRequirementTests")
    public static Object[][] getInvalidTitleRequirementTests() {
        return BaseTest.getTestData("InvalidTitleRequirementTests");
    }

    @Test(dataProvider = "getInvalidTitleRequirementTests")
    public void createFavInvalidTitleRequirementTest(Place place){
        LogManager.getLogger().info("Running create favourite place test with invalid title. Place: {}", place);
        performFavouriteTest(place, HttpStatus.SC_BAD_REQUEST);
    }

    @DataProvider(name = "getValidTitleRequirementTests")
    public static Object[][] getValidTitleRequirementTests() {
        return BaseTest.getTestData("ValidTitleRequirementTests");
    }

    @Test(dataProvider = "getValidTitleRequirementTests")
    public void createFavValidTitleRequirementTest(Place place){
        LogManager.getLogger().info("Running create favourite place test with valid title. Place: {}", place);
        performFavouriteTest(place, HttpStatus.SC_OK);
    }

}
