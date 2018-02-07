package testcses;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageobject.HomePage;
import reporting.TestLogger;

public class TestHomePage extends CommonAPI{
    @Test
    public void login()throws InterruptedException{
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        homePage.goToLogin();
        homePage.login();
    }
}
