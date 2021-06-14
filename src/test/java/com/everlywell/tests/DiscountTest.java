package com.everlywell.tests;

import com.everlywell.pages.HomePage;
import com.everlywell.pages.ItemPage;
import com.everlywell.pages.TestKitsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DiscountTest extends TestBase {

    
    @Test(description = "Verify user gets discount if user adds 5 items in cart")
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

        double itemPrice = Double.parseDouble(itemPage.getItemPrice().replace("$",""));
        double subTotal = Double.parseDouble(itemPage.getSubTotalPrice().replace("$",""));
        double total = Double.parseDouble(itemPage.getTotalPrice().replace("$",""));
        double discount = Double.parseDouble(itemPage.getDiscountedPrice().replace("$",""));

        String shipping = itemPage.getShippingPrice();
        double shippingPrice = 0;

        if (!shipping.equalsIgnoreCase("free")){
            shippingPrice = Double.parseDouble(shipping);
        }

        //buy 5 get 1 free that means discount should be equal to 1 item price
        Assert.assertEquals(discount,itemPrice);

        double expectedSubTotal = ( itemPrice * 5 );
        double expectedTotal = expectedSubTotal + shippingPrice - discount; //buy 5 get 1 free

        Assert.assertEquals(total,expectedTotal);
    }
}
