package com.saucedemo.testsuits;

import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {
   HomePage homePage;
   LoginPage loginPage;

   @BeforeMethod(alwaysRun = true)
   public void inIt(){
       homePage = new HomePage();
       loginPage = new LoginPage();
   }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {


        String expected = "Products";
        //Enter “standard_user” username
        loginPage.enterEmailId("standard_user");
        //Enter “secret_sauce” password
        loginPage.enterPassword("secret_sauce");
        //Click on ‘LOGIN’ button
        loginPage.clickOnLoginButton();
        waitUntilVisibilityOfElementLocated(By.xpath("//span[@class='title']"),5);
        // Verify the text 'product'
        String actualText = homePage.successfulLoginMessage();
        Assert.assertEquals(actualText, expected, "Login page not found");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException {
        //Enter “standard_user” username
        loginPage.enterEmailId("standard_user");
        //Enter “secret_sauce” password
        loginPage.enterPassword("secret_sauce");
        //Click on ‘LOGIN’ button
        loginPage.clickOnLoginButton();

        //Verify that six products are displayed on page
        int actualQuantity = homePage.productlist();
        int expectedQuantity = 6;
        Assert.assertEquals(expectedQuantity, actualQuantity);


    }
}
