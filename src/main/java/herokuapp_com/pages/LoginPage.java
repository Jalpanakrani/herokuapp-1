package herokuapp_com.pages;

import herokuapp_com.utility.Utility;
import org.openqa.selenium.By;

/**
 * Created by Jay Vaghani
 */
public class LoginPage extends Utility {

    By secureareaText = By.xpath("//div[@class='example' and contains(.,' Secure Area')]");
    By emailField = By.id("username");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//i[@class='fa fa-2x fa-sign-in']");
    By geterrorMessage = By.xpath("//div[@id='flash']");


    public String getWelcomeText(){
        return getTextFromElement(secureareaText);
    }

    public void enterEmailId(String email){
        sendTextToElement(emailField, email);
    }

    public void enterPassword(String password){
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }

    public String getErrorMessage(){
        return getTextFromElement(geterrorMessage);
    }

}
