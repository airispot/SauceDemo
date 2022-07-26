package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryTests extends BaseTest {
private final String TEST_ITEM_NAME = "Sauce Labs Onesie";
    @Test
    public void abc () throws InterruptedException {
        loginPage.login("standard_user", "secret_sauce");
        String actualPrice = productPage.getProductPrice(TEST_ITEM_NAME);
        String actualDescription = productPage.getProductDescription(TEST_ITEM_NAME);
        Assert.assertEquals(actualPrice, "$7.99");
        Assert.assertEquals(actualDescription, "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.");
    productPage.clickAddToCartButton(TEST_ITEM_NAME);
    productPage.openProductDetails(TEST_ITEM_NAME);
    //....
        Thread.sleep(5000);



    }
}
