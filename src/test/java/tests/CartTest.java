package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    private final String TEST_ITEM_NAME = "Sauce Labs Onesie";


    @Test
    public void removeItemFromTheCart() throws InterruptedException {
        loginPage.login("standard_user", "secret_sauce");
        productPage.clickAddToCartButton(TEST_ITEM_NAME);
        productPage.clickShoppingCartLink();
        String actualDescription = cartPage.getCartIProductDescription(TEST_ITEM_NAME);
        Assert.assertEquals(actualDescription, "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.");
    cartPage.clickRemoveButton();
    cartPage.clickContinueShoppingButton();
    Assert.assertTrue(productPage.isHeaderContainerDisplayed());
    }


    @Test

    public void checkoutStepOneTest(){

        loginPage.login("standard_user", "secret_sauce");
        productPage.clickAddToCartButton(TEST_ITEM_NAME);
        productPage.clickShoppingCartLink();

        cartPage.clickCheckoutButton();
        checkoutStepOnePage.checkoutStepOneForm("Ann","Smith","12345");
        checkoutStepTwoPage.clickFinishButton();
        checkoutCompletePage.clickBackHomeButton();
        Assert.assertTrue(productPage.isHeaderContainerDisplayed());
    }

    @Test

    public void checkoutStepTwoTest(){

        loginPage.login("standard_user", "secret_sauce");
        productPage.clickAddToCartButton(TEST_ITEM_NAME);
        productPage.clickShoppingCartLink();

        cartPage.clickCheckoutButton();
        checkoutStepOnePage.checkoutStepOneForm("Ann","Smith","12345");
        checkoutStepTwoPage.clickFinishButton();

        Assert.assertTrue(checkoutCompletePage.thankYouTextIsDisplayed());
    }

}
