package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.core.drivers.DriverManager;
import com.example.core.helper.ReadConfigPropertyFile;
import com.example.core.keyword.CustomKeyword;



public class BaseTest {
    public WebDriver driver;
    public CustomKeyword keyword;
    public String pathChromeDriver = "src\\test\\java\\com\\example\\core\\drivers\\driver\\chromedriver.exe";
    public String baseUrl = ReadConfigPropertyFile.getPropertyValue("url");
    public String browser = ReadConfigPropertyFile.getPropertyValue("browser");
    
    
    @BeforeTest
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver",pathChromeDriver);
        this.driver = DriverManager.getDriver(browser);
        driver.get(baseUrl);
       
        
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

  
}


