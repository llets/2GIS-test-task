package tests.createFavourite;

import models.Place;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TitleTest extends CreateFavouriteBaseTest {

    @DataProvider(name = "getInvalidTitleRequirementTests")
    public static Object[][] getInvalidTitleRequirementTests() {
        return CreateFavouriteBaseTest.getTestData("InvalidTitleRequirementTests");
    }

    @Test(dataProvider = "getInvalidTitleRequirementTests")
    public void createFavInvalidTitleRequirementTest(Place place){
        performFavouriteTest(place, HttpStatus.SC_BAD_REQUEST);
    }

    @DataProvider(name = "getValidTitleRequirementTests")
    public static Object[][] getValidTitleRequirementTests() {
        return CreateFavouriteBaseTest.getTestData("ValidTitleRequirementTests");
    }

    @Test(dataProvider = "getValidTitleRequirementTests")
    public void createFavValidTitleRequirementTest(Place place){
        performFavouriteTest(place, HttpStatus.SC_OK);
    }

}
