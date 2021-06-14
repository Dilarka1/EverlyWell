package com.everlywell.tests;

import com.everlywell.pages.HomePage;
import com.everlywell.pages.ItemPage;
import com.everlywell.pages.TestKitsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PromotionCodeTest extends TestBase {

    //"Verify user gets discount if user adds 5 items in cart")
    @Test(description = "Verify calculation of shopping cart total")
    public void discountTest() {
        HomePage homePage = new HomePage();
        ItemPage itemPage = new ItemPage();
        TestKitsPage testKitsPage = new TestKitsPage();

        homePage.clickShopAllTestsButton();
        testKitsPage.clickOnRandomTestKit();
        itemPage.closeDiscountFrame();
        itemPage.selectQuantityAs5();
        itemPage.clickOnAddToCartButton();
        itemPage.clickOnShoppingCart();

        itemPage.clickOnAddPromotionCodeButton();
        itemPage.enterPromotionCode("FS20");


        double itemPrice = Double.parseDouble(itemPage.getItemPrice().replace("$", ""));
        double subTotal = Double.parseDouble(itemPage.getSubTotalPrice().replace("$", ""));
        double total = Double.parseDouble(itemPage.getTotalPrice().replace("$", ""));

        double promotionDiscount = subTotal * 0.20; // %20 discount from promotion code
        double discount = itemPrice;//buy 5 get 1 free

        if (promotionDiscount > discount ){
            discount = promotionDiscount;
        }

        String shipping = itemPage.getShippingPrice();
        double shippingPrice = 0;

        if (!shipping.equalsIgnoreCase("free")) {
            shippingPrice = Double.parseDouble(shipping);
        }

        double expectedSubTotal = (itemPrice * 5);
        double expectedTotal = expectedSubTotal + shippingPrice - discount;

        Assert.assertEquals(total, expectedTotal);
    }
}
