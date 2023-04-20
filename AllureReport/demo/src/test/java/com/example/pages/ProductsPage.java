package com.example.pages;


import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ProductsPage  extends BasePage{
    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public String getProductPageTitle= driver.getTitle();
   List <WebElement> getProduct = driver.findElements(By.xpath("//div[@class='inventory_item']"));


    int countProduct=getProduct.size();
    String expectecNumber="5";
    String strCountProduct=String.valueOf(countProduct);
    public boolean isProductMatch(){
        if(strCountProduct.equals(expectecNumber)){
            return true;
        }
        return false;
    }

    

     WebElement btnAddToCart = keyword.findWebElementByXpath("//button[@id='add-to-cart-sauce-labs-backpack']");
     String expectedMessage="ADD TO CART";


     public boolean isAddToCartButtonDisplay(){
        if(btnAddToCart.isDisplayed()){
            return true;
        }
        return false;
    }

        public boolean isTextAddToCartButton(){
            if(btnAddToCart.getText().equals(expectedMessage)){
                return true;
            }
            return false;
        }
        
        public void actionClickADDTOCART() throws InterruptedException{
          keyword.waitToClick(btnAddToCart);
          Thread.sleep(5000);
        }

        String expectedMessages="REMOVE";
        public boolean isTextAddToCartButtonToChange() throws InterruptedException{
            keyword.waitToClick(btnAddToCart);
            WebElement btnRemoveOutCart = keyword.findWebElementByXpath("//button[@id='remove-sauce-labs-backpack']");     
            if(btnRemoveOutCart.getText().equals(expectedMessages)){
                return true;
            }
            return false;
        }
    WebElement btnCart = keyword.findWebElementByXpath("//div[@class='shopping_cart_container']");
    public boolean actionProductAlsoRemoveWhenClickRemive() throws InterruptedException{
        keyword.waitToClick(btnAddToCart);
        WebElement btnRemoveOutCart = keyword.findWebElementByXpath("//button[@id='remove-sauce-labs-backpack']");     
        keyword.scrollAndWaitToClick(btnRemoveOutCart);
        keyword.scrollAndWaitToClick(btnCart);
        if(driver.findElements(By.xpath("//div[@class='cart-item']")).size()==0){
            return true;
        }
        return false;
    }
    WebElement selectedProduct= keyword.findWebElementByXpath("//select[@class='product_sort_container']");

    public  void sortProduct(){
        keyword.selectElementValue(selectedProduct, "hilo");
    }
}


    
