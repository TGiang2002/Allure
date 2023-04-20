package com.example.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import com.example.core.helper.ReadConfigPropertyFile;


public class LoginPage extends BasePage{

    public static final String assertUserPasswordTextBox = null;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    
    WebElement title = keyword.findWebElementByXpath("//div[@class='login_logo']");
    WebElement txtEmail = keyword.findWebElementByXpath("//input[@id='user-name']");
    WebElement txtPassword = keyword.findWebElementByXpath("//input[@id='password']");
    WebElement btnLogin = keyword.findWebElementByXpath("//input[@id='login-button']");
    String expectedMessageUsername="Username";
    String expectedMessagePassword="Password";
    String expectedMessageLogin="Login";
    String expectedColorLogin="#e2231a";
    String getTitle=title.getText();
    String expectTitle="Swag Labs";

    public boolean isTitle(){
        if(getTitle.equals(expectTitle)){
            return true;
        }
        return false;
    }

    /**
     * Implement Function
     * @throws InterruptedException
     */
    public void actionLoginUser() throws InterruptedException{
        keyword.sendKeys(txtEmail, ReadConfigPropertyFile.getPropertyValue("username"));
        keyword.sendKeys(txtPassword, ReadConfigPropertyFile.getPropertyValue("password"));
        keyword.scrollAndWaitToClick(btnLogin);
    }

    public void actionLogin(String username, String password) throws InterruptedException{
        keyword.sendKeys(txtEmail,username);
        keyword.sendKeys(txtPassword,password);
        keyword.scrollAndWaitToClick(btnLogin);
    }
    

    public boolean isTextUserTextBox(){
        if(txtEmail.getAttribute("placeholder").equals(expectedMessageUsername)){
            return true;
        }
        return false;
    }
    public boolean isTextPasswordTextBox(){
        if(txtPassword.getAttribute("placeholder").equals(expectedMessagePassword)){
            return true;
        }
        return false;
    }

    public boolean isLoginButtonDisplay(){
        if(btnLogin.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean isTextLoginButton(){
        if(btnLogin.getAttribute("value").equals(expectedMessageLogin)){
            return true;
        }
        return false;
    }

    public boolean getColorLoginBtn() {
         if(Color.fromString(btnLogin.getCssValue("background-color")).asHex().equals(expectedColorLogin)){
            return true;
        }
        return false;
    
    }
}


