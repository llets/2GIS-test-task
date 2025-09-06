package tests.createFavourite;

import models.Place;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.BaseTest;

public class RequiredFieldsTest extends CreateFavouriteBaseTest{

    @DataProvider(name = "getDataRequiredFieldsTest")
    public static Object[][] getDataRequiredFieldsTest() {
        return BaseTest.getTestData("WithoutAllNecessaryFieldsTests");
    }

    @Test(dataProvider = "getDataRequiredFieldsTest")
    public void createFavDataRequiredFieldsTest(Place place){
        LogManager.getLogger().info("Running create favourite place test without required fields");
        performFavouriteTest(place, HttpStatus.SC_BAD_REQUEST);
    }

}
