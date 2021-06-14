package com.everlywell.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.List;

public class TestKitsPage extends PageBase {
    @FindBy(xpath = "//div[@class='container']//a[@aria-label]")
    public List<WebElement> testKits;


    /**
     * This method will shuffle the testKits list.
     * In this case each and every time automation will click on a random test kit
     */

    public void clickOnRandomTestKit(){
        Collections.shuffle(testKits);
        testKits.get(0).click();
    }

    public void clickOnFirstTestKit(){
        testKits.get(0).click();
    }

    public void clickOnSpecifiedTestKit(String testKitName){
        testKits.get(testKits.indexOf(testKitName)).click();
    }


}
