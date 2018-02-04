package eBayTestHomePage;

import base.CommonAPI;
import eBayHomePage.Login;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

public class TestLogin extends CommonAPI{
    @Test
    public void testLogin()throws InterruptedException{
        Login login = PageFactory.initElements(driver,Login.class);
        login.goToLoginAndRegiPage();
        login.login();
    }
}
