package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[@class='title']")
    WebElement productMessage;

    @CacheLookup
    @FindBy(xpath = "//div[@class='inventory_item']")
    WebElement listOfProduct;


    public String successfulLoginMessage() {
        Reporter.log("Successfully Login " + productMessage + "Login messages" + productMessage.toString());
        CustomListeners.test.log(Status.PASS, "User successful Login Message" + productMessage);
        return getTextFromElement(productMessage);
    }

    public int productlist() {
        Reporter.log("Product List " + listOfProduct.toString());
        CustomListeners.test.log(Status.PASS, "Product List name" + listOfProduct);
        List<WebElement> product = driver.findElements((By) listOfProduct);
        return product.size();
    }

}


