package eBayTestHomePage;

import base.CommonAPI;
import eBayHomePage.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestHomePage extends CommonAPI{
    @Test
    public void testSearch()throws Exception{
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        homePage.search();
    }
}
