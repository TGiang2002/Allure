package com.example.tests;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.core.helper.ReadConfigPropertyFile;
import com.example.core.report.Log;
import com.example.core.report.ReportListener;
import com.example.pages.LoginPage;
import com.example.pages.ProductsPage;
import com.google.common.collect.ImmutableMap;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

//tạo single html
// Cài đặt allure combine: `pip install allure-combine`
// Chạy lệnh: `allure generate allure-results --clean -o allure-report `
//chạy lệnh :allure-combine allure-report      
//Báo cáo sẽ được sinh ra trong mục `allure-report`.

@Listeners(ReportListener.class)
@Epic("Regression Test")//tính năng tổng thể của test
@Feature("Product Test")// mô tả những tính năng của ứng dụng sẽ được test.
public class ProductTest  extends BaseTest{

    @BeforeSuite
    void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("browser", ReadConfigPropertyFile.getPropertyValue("browser"))
                        .put("url",ReadConfigPropertyFile.getPropertyValue("url"))
                        .put("os",ReadConfigPropertyFile.getPropertyValue("os"))
                        .build(),System.getProperty("user.dir")
                        + "//allure-results/");
    }
 
    @Test(testName = "Verify The PRODUCTS page title",priority = 0)
    @Story("Page Title")//mô tả ngắn gọn về test case
    @Severity(SeverityLevel.BLOCKER)//ể xác định mức độ quan trọng của test case
    public void verifyTheProductsPageTitle() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        Allure.step("Login with username and password");
        loginPage.actionLogin("standard_user","secret_sauce");
        ProductsPage productsPage=new ProductsPage(driver);
        Allure.step("Assert Title");
        Assert.assertTrue(productsPage.getProductPageTitle.equals("Swag Labs"));

    }
   
    @Test(testName = "Verify THE ADD TO CART BUTTON Display The PRODUCTS page ",priority = 1)
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Page Button")
    public void verifyTheButtonAddToCartDisplayOnProductsPage() throws InterruptedException{
        // LoginPage loginPage = new LoginPage(driver);
        // loginPage.actionLoginUser();
        // Allure.step("login");
        ProductsPage productsPage=new ProductsPage(driver);
        Allure.step("Assert button display");
        Assert.assertTrue(productsPage.isAddToCartButtonDisplay());
        // Allure.step("Assert text button");
        // Assert.assertTrue(productsPage.isTextAddToCartButton());
        
    }

    @Test(testName = "Verify Click ADD TO CART BUTTON The PRODUCTS page ",priority = 2)
    @Severity(SeverityLevel.MINOR)
    @Story("Click Add to cart button")
    public void verifyClicktButtonAddToCart() throws InterruptedException{
        // LoginPage loginPage = new LoginPage(driver);
        // loginPage.actionLoginUser();
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.actionClickADDTOCART();
        Allure.step("Click button ADD TO CART");

    }
    @AfterMethod
    public void takeScreenshot(ITestResult result) throws InterruptedException {
        //Ghi log lại sau khi chạy mỗi method
        Log.info(result.getName());
        Thread.sleep(500);
        //Khởi tạo đối tượng result thuộc ITestResult để lấy trạng thái và tên của từng Test Case
        //Ở đây sẽ so sánh điều kiện nếu testcase passed hoặc failed
        //passed = SUCCESS và failed = FAILURE
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
               byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
               Allure.addAttachment("Fail screen", new ByteArrayInputStream(screenshot));
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }
    
}
