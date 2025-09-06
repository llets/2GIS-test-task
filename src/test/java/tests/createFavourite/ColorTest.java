package tests.createFavourite;

import models.Place;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.BaseTest;

public class ColorTest extends CreateFavouriteBaseTest {

    @DataProvider(name = "getValidColorRequirementTests")
    public static Object[][] getValidColorRequirementTests() {
        return BaseTest.getTestData("ValidColorRequirementTests");
    }
    
    @Test(dataProvider = "getValidColorRequirementTests")
    public void createFavValidColorRequirementTest(Place place){
        LogManager.getLogger().info("Running create favourite place test with valid color. Place: {}", place);
        performFavouriteTest(place, HttpStatus.SC_OK);
    }

    @DataProvider(name = "getInvalidColorRequirementTests")
    public static Object[][] getInvalidColorRequirementTests() {
        return BaseTest.getTestData("InvalidColorRequirementTests");
    }

    @Test(dataProvider = "getInvalidColorRequirementTests")
    public void createFavInvalidColorRequirementTest(Place place){
        LogManager.getLogger().info("Running create favourite place test with invalid color. Place: {}", place);
        performFavouriteTest(place, HttpStatus.SC_BAD_REQUEST);
    }

}