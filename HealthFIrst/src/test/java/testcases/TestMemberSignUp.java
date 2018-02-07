package testcases;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.MemberLogInPage;
import pageobject.MemberSignUpPage;
import reporting.TestLogger;

public class TestMemberSignUp extends CommonAPI{
    @Test
    public void testMemberSignUp(){
        TestLogger.log(getClass().getSimpleName() + ": " + converToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        HomePage hp = PageFactory.initElements(driver,HomePage.class);
        hp.goToMemberLogin();

        MemberLogInPage mlp = PageFactory.initElements(driver, MemberLogInPage.class);
        mlp.newMemberSignUp();

        MemberSignUpPage msup = PageFactory.initElements(driver, MemberSignUpPage.class);
        msup.clickAgree();
        msup.fillUpForm();
    }
}
