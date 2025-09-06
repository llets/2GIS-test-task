package tests.createFavourite;

import models.Place;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ColorTest extends CreateFavouriteBaseTest {

    @DataProvider(name = "getValidColorRequirementTests")
    public static Object[][] getValidColorRequirementTests() {
        return CreateFavouriteBaseTest.getTestData("ValidColorRequirementTests");
    }
    
    @Test(dataProvider = "getValidColorRequirementTests")
    public void createFavValidColorRequirementTest(Place place){
        performFavouriteTest(place, HttpStatus.SC_OK);
    }

    @DataProvider(name = "getInvalidColorRequirementTests")
    public static Object[][] getInvalidColorRequirementTests() {
        return CreateFavouriteBaseTest.getTestData("InvalidColorRequirementTests");
    }

    @Test(dataProvider = "getInvalidColorRequirementTests")
    public void createFavInvalidColorRequirementTest(Place place){
        performFavouriteTest(place, HttpStatus.SC_BAD_REQUEST);
    }

}