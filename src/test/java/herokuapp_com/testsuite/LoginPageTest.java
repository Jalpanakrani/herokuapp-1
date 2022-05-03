package herokuapp_com.testsuite;

import herokuapp_com.pages.HomePage;
import herokuapp_com.pages.LoginPage;
import herokuapp_com.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void verifyUserShouldNavigateToLoginPage(){
        loginPage.enterEmailId("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        String expectedMessage = "Secure Area\n"+
                "Welcome to the Secure Area. When you are done click logout below.\n" +
                "Logout";
        String actualMessage = loginPage.getWelcomeText();
       Assert.assertEquals(actualMessage,expectedMessage,"Login page not displayed");

    }

    @Test
    public void verifyErrorMessageWithInvalidCredentials(){
        loginPage.enterEmailId("prime123@gmail.com");
        loginPage.enterPassword("prime123");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Your username is invalid!\n" +
                "×";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals( actualErrorMessage,expectedErrorMessage,"Error message not displayed");
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        loginPage.enterEmailId("tomsmith");
        loginPage.enterPassword("SuperSecretPassword");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Your password is invalid!\n" +
                "×";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals( actualErrorMessage,expectedErrorMessage,"Error message not displayed");
    }

}
