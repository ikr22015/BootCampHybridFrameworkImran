package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.MemberLogInPage;
import reporting.TestLogger;
import utilities.ReadExcelFile;

public class TestMemberLogInPage extends MemberLogInPage{
    @Test(dataProvider = "testdata")
    public void testMemberLogIn(String username, String password)throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + converToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        HomePage hp = PageFactory.initElements(driver,HomePage.class);
        hp.goToMemberLogin();

        MemberLogInPage mlp = PageFactory.initElements(driver, MemberLogInPage.class);
        mlp.memberLogin(username,password);

    }

    @DataProvider(name = "testdata")
    public Object[][] TestDataFeed(){
        ReadExcelFile config = new ReadExcelFile("../HealthFIrst/data/file.xls");
        int rows = config.getRowCount(0);
        Object[][] credentials = new Object[rows][2];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < 2; j++){
                credentials[i][j] = config.getData(0,i,j);
                credentials[i][j] = config.getData(0,i,j);
            }
        }
        return credentials;
    }
}
