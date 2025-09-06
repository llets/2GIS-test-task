package tests.createFavourite;

import models.Place;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LonTest extends CreateFavouriteBaseTest {

    @DataProvider(name = "getInvalidLonRequirementTests")
    public static Object[][] getInvalidLonRequirementTests() {
        return CreateFavouriteBaseTest.getTestData("InvalidLonRequirementTests");
    }

    @Test(dataProvider = "getInvalidLonRequirementTests")
    public void createFavInvalidLonRequirementTest(Place place){
        performFavouriteTest(place, HttpStatus.SC_BAD_REQUEST);
    }

    @DataProvider(name = "getValidLonRequirementTests")
    public static Object[][] getValidLonRequirementTests() {
        return CreateFavouriteBaseTest.getTestData("ValidLonRequirementTests");
    }

    @Test(dataProvider = "getValidLonRequirementTests")
    public void createFavValidLonRequirementTest(Place place){
        performFavouriteTest(place, HttpStatus.SC_OK);
    }

}
