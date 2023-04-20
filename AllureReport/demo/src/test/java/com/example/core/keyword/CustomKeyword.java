package com.example.core.keyword;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomKeyword {
    private WebDriver driver;
    private WebDriverWait wait;

    public CustomKeyword(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    /**
     * Keyword for open url with checking if the url valid or not
     * @param baseUrl
     * @throws Exception
     */
    public void openUrl(String baseUrl) throws Exception {
        if(baseUrl.startsWith("http://") || baseUrl.startsWith("https://"))
        {
            driver.get(baseUrl);
        }
        throw new Exception("url not start with http or http. Double check baseUrl");
    }

    /**
     * Scroll to element and find element by xpath
     * @param locator
     * @return
     * @throws InterruptedException
     */
    public WebElement findWebElementByXpath(String locator){
        try{
            scrollToElemtnIntoView(driver.findElement(By.xpath(locator)));
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

        } catch(WebDriverException ex ){
            throw new WebDriverException("Element not found!");
        }
    }

    
    public WebElement findWebElementByClass(String classname){
        try{
            scrollToElemtnIntoView(driver.findElement(By.className(classname)));
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.className(classname)));
        } catch(WebDriverException ex ){
            throw new WebDriverException("Element not found!");
        }
    }

    public WebElement findWebElementById(String id){
        try{
            scrollToElemtnIntoView(driver.findElement(By.id(id)));
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
        } catch(WebDriverException ex ){
            throw new WebDriverException("Element not found!");
        }
    }

    public WebElement findWebElementByCss(String cssselector){
        try{
            scrollToElemtnIntoView(driver.findElement(By.cssSelector(cssselector)));
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssselector)));
        } catch(WebDriverException ex ){
            throw new WebDriverException("Element not found!");
        }
    }

    /**
     * Scroll to element into View
     * @param element
     */
    public void scrollToElemtnIntoView(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebElement waitForElementDisplayed(WebElement element) {
        try{
            scrollToElemtnIntoView(element);
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch(WebDriverException ex){
            throw new WebDriverException("Element not displayed");
        }
        
    }

    /**
     * Wait for Element displayed and input text
     * @param element
     * @param text
     */
    public void sendKeys(WebElement element, String text){
        try{
            waitForElementDisplayed(element).sendKeys(text);
        }catch(WebDriverException ex){
            throw new WebDriverException("Element not availabe to input text!");
        }
    }

  
    public void selectElement(WebElement element, String text){
        try{
            waitForElementDisplayed(element);
            Select select6=new Select(element);
            select6.selectByVisibleText(text);
            }catch(WebDriverException ex){
            throw new WebDriverException("Element not availabe to input text!");
        }
    }

    public void selectElementValue(WebElement element, String value){
        try{
            waitForElementDisplayed(element);
            Select select7=new Select(element);
            select7.selectByValue(value);
            }catch(WebDriverException ex){
            throw new WebDriverException("Element not availabe to input text!");
        }
    }
    public CustomKeyword waitToClick(WebElement element) throws InterruptedException {

        try{

            waitForElementDisplayedWithoutScroll(element);

            element.click();
            Thread.sleep(3000);

            return new CustomKeyword(driver, wait);

        }catch(WebDriverException ex){

            throw new WebDriverException("Element not availabe to click!");

        }

    }

    public WebElement waitForElementDisplayedWithoutScroll(WebElement element) {

        try{

            return wait.until(ExpectedConditions.elementToBeClickable(element));

        } catch(WebDriverException ex){

            throw new WebDriverException("Element not displayed");

        }  

    }
    /**
     * Scroll And Wait To Click
     * @param element
     * @return
     * @throws InterruptedException
     */
    public CustomKeyword scrollAndWaitToClick(WebElement element) throws InterruptedException {
        try{
            
            scrollToElemtnIntoView(element);
            waitForElementDisplayed(element);
            element.click();
            Thread.sleep(3000);
            return new CustomKeyword(driver, wait);
        }catch(WebDriverException ex){
            throw new WebDriverException("Element not availabe to input text!");
        }
    }
    public void scrollByToClick(WebElement element) throws InterruptedException{
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,500)");
            Thread.sleep(3000);
            element.click();
            Thread.sleep(3000);
            }catch(WebDriverException ex){
            throw new WebDriverException("Element not availabe to input text!");
        }
    }

    public void scrollByToBy(WebElement element) throws InterruptedException{
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,100)");
            Thread.sleep(3000);
            }catch(WebDriverException ex){
            throw new WebDriverException("Element not availabe to input text!");
        }
    }
    public void clickElemet(WebElement element) throws InterruptedException{
        try{
            element.click();
            Thread.sleep(4000);
        }catch(WebDriverException ex){
            throw new WebDriverException("Element not availabe to input text!");
        }
    }
    public void argumentsByToClick(WebElement element) throws InterruptedException{
        try{
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click()", element);
            Thread.sleep(3000);
            }catch(WebDriverException ex){
            throw new WebDriverException("Element not availabe to input text!");
        }
    }
   

}
