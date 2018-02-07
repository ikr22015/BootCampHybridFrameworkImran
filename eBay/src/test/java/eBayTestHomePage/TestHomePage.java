package eBayTestHomePage;

import base.CommonAPI;
import eBayHomePage.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import reporting.TestLogger;

public class TestHomePage extends CommonAPI{
    @Test
    public void testSearch()throws Exception{
        TestLogger.log(getClass().getSimpleName() + ": " + converToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        homePage.search();
    }
}
