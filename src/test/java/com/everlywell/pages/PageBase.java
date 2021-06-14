package com.everlywell.pages;

import com.everlywell.utilities.BrowserUtils;
import com.everlywell.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class PageBase {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 15);

    
    @FindBy(xpath = "//button[@data-testid='open-cart']")
    private WebElement shoppingCart;

    public PageBase() {
        PageFactory.initElements(driver, this);
    }


    public void clickOnShoppingCart(){
        shoppingCart.click();
    }


    /**
     * Method for desktop menu navigation. Provide tab name to navigate
     *
     * @param tabName    like Shop, Learn, For Businesses
     */
    public void navigateTo(String tabName) {
        String tabNameXpath = "//div[@data-testid='desktop-menu']//button[text()='" + tabName + "']";
        
        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        
        tabElement.click();
    }
}
