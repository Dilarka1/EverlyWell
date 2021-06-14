package com.everlywell.pages;

import com.everlywell.utilities.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ItemPage extends PageBase {

    @FindBy(xpath = "//button[text()='Add to Cart']")
    private WebElement addToCartButton;

    @FindBy(id = "productQuantity")
    private WebElement productQuantityDropdown;

    @FindBy(xpath = "//div[@data-testid='cart-content']")
    private WebElement div;

    @FindBy(xpath = "//button[@data-testid='cart-promo-link']")
    private WebElement addPromotionCodeButton;

    @FindBy(xpath = "//button[@data-testid='cart-promo-input']")
    private WebElement promotionCodeInput;

    @FindBy(xpath = "//div[@data-testid='cart-subtotal']")
    private WebElement cartSubTotal;

    //I assume discount will be in cart total table after code deployed to QA Env
    @FindBy(xpath = "//div[@data-testid='discount']")
    private WebElement discountPrice;

    //shipping web element hardcodded for now.
    // It will take 2nd amount in the list
    @FindBy(xpath = "(//div[@data-testid='cart-subtotal']/../div)[2]")
    private WebElement shippingPrice;

    @FindBy(xpath = "//div[@data-testid='cart-total-price']")
    private WebElement cartTotalPrice;

    @FindBy(xpath = "//div[@data-testid='cart-item-price']")
    private WebElement itemPrice;

    @FindBy(xpath = "//div[@data-prepost='pre']//span[text()='x']")
    private WebElement discountFrameCloseButton;

    @FindBy(id = "ju_iframe_550192")
    private WebElement discountFrame;


    public void closeDiscountFrame(){
        wait.until(ExpectedConditions.visibilityOf(discountFrame));
        driver.switchTo().frame(discountFrame);
        discountFrameCloseButton.click();
        driver.switchTo().defaultContent();
    }

    public void clickOnAddToCartButton() {
        wait.until(ExpectedConditions.visibilityOf(addToCartButton)).click();
    }

    /**
     * @param quantity of items
     */
    public void selectAQuantity(String quantity) {
        Select dropdown = new Select(productQuantityDropdown);
        dropdown.selectByValue(quantity);
    }


    public void selectQuantityAs5() {
        Select dropdown = new Select(productQuantityDropdown);
        dropdown.selectByValue("5");
    }

    public String getSelectedQuantity() {
        Select dropdown = new Select(productQuantityDropdown);
        return dropdown.getAllSelectedOptions().get(0).getText();
    }

    public void clickOnAddPromotionCodeButton() {
        wait.until(ExpectedConditions.visibilityOf(addPromotionCodeButton)).click();
    }

    public void enterPromotionCode(String promotionCode){
        wait.until(ExpectedConditions.visibilityOf(promotionCodeInput)).sendKeys(promotionCode, Keys.ENTER);
    }

    public String getItemPrice(){
        return wait.until(ExpectedConditions.visibilityOf(itemPrice)).getText();
    }

    public String getSubTotalPrice(){
        return wait.until(ExpectedConditions.visibilityOf(cartSubTotal)).getText();
    }

    public String getDiscountedPrice(){
        return wait.until(ExpectedConditions.visibilityOf(discountPrice)).getText();
    }

    public String getShippingPrice(){
        return wait.until(ExpectedConditions.visibilityOf(shippingPrice)).getText();
    }

    public String getTotalPrice(){
        return wait.until(ExpectedConditions.visibilityOf(cartTotalPrice)).getText();
    }


}
