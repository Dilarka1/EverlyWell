package com.everlywell.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageBase {

    @FindBy(xpath = "//h3/following-sibling::a[text()='Shop All Tests']")
    private WebElement shopAllTestButton;


    public void clickShopAllTestsButton(){
        wait.until(ExpectedConditions.visibilityOf(shopAllTestButton)).click();
    }
}
