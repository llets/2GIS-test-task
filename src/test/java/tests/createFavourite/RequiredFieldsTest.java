package tests.createFavourite;

import models.Place;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RequiredFieldsTest extends CreateFavouriteBaseTest{

    @DataProvider(name = "getDataRequiredFieldsTest")
    public static Object[][] getDataRequiredFieldsTest() {
        return CreateFavouriteBaseTest.getTestData("WithoutAllNecessaryFieldsTests");
    }

    @Test(dataProvider = "getDataRequiredFieldsTest")
    public void createFavDataRequiredFieldsTest(Place place){
        performFavouriteTest(place, HttpStatus.SC_BAD_REQUEST);
    }

}
