package laptopsandnotebooks;

import Utility.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        //Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='nav navbar-nav']/li/a[text()='Laptops & Notebooks']"));
        //Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        // Select Sort By "Price (High > Low)"
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        Thread.sleep(1000);
        //Verify the Product price will arrange in High to Low order
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='nav navbar-nav']/li/a[text()='Laptops & Notebooks']"));
        //Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        // Select Sort By "Price (High > Low)"
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        Thread.sleep(1000);
        //Select Product “MacBook”
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));
        //Verify the text “MacBook”
        String exMacBook = "MacBook";
        String acMacBook = getTextFromElement(By.xpath("//h1[normalize-space()='MacBook']"));
        Assert.assertEquals("MacBook", acMacBook);
        Thread.sleep(1000);
        //Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //Verify the message “Success: You have added MacBook to your shopping cart!"
        String actualMessage = "Success: You have added MacBook to your shopping cart";
        String expectedMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        String[] exp = expectedMessage.split("!");
        Assert.assertEquals("Error Message is not Displayed", exp[0], actualMessage);
        Thread.sleep(1000);

        //Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //String actMessage = "Shopping Cart";
        String expMessage = driver.findElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")).getText();
        String[] exp1 = expectedMessage.split("(1.00kg)");
        Assert.assertEquals("Error Message is not Displayed", exp[0], actualMessage);
        Thread.sleep(1000);

        //Verify the Product name "MacBook"
        String exptMacBook= "MacBook";
        String actMacBook = getTextFromElement(By.xpath("(//a[contains(text(),'MacBook')])[2]"));
        Assert.assertEquals(exptMacBook,actMacBook);
        Thread.sleep(1000);
        //Change Quantity "2"
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"),"2");
        // Click on “Update” Tab
        clickOnElement(By.xpath("//button[contains(@type,'submit')]"));

        //Verify the message “Success: You have modified your shopping cart!"
        String expSuccess = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success alert-dismissible')]/i")).getText();
        String[] ex = expectedMessage.split("(!)");
        Assert.assertEquals("Error Message is not Displayed", exp[0], actualMessage);
        Thread.sleep(1000);
        //Change currency
        mouseHoverToElementAndClick(By.xpath("//span[contains(text(),'Currency')]"));
        //Select £Pound Sterling
        clickOnElement(By.xpath("//button[contains(text(),'£Pound Sterling')]"));
        //Verify the Total £4,424.70
        String exTotal = "£4,424.70";
        String acTotal = getTextFromElement(By.xpath("(//td[contains(text(),'£4,424.70')])[3]"));
        Assert.assertEquals(exTotal,acTotal);
        Thread.sleep(1000);
        //Click on “Checkout” button
        clickOnElement(By.xpath("//a[text()='Checkout']"));
        // Verify the Text “New Customer”
        Thread.sleep(5000);
        String expNewCustomer = "New Customer";
        String actNewCustomer = getTextFromElement(By.xpath("//h2[contains(text(),'New Customer')]"));
        Assert.assertEquals("Text : New Customer", expNewCustomer, actNewCustomer);
          Thread.sleep(1000);
        //2.18 Click on “Guest Checkout” radio button
        mouseHoverToElementAndClick(By.xpath("//label[normalize-space()='Guest Checkout']"));
        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"),"Abcde");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"),"Efghh");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"),"xyzc@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"),"11234567891");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"),"Wembley");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"),"London");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"),"HA1 1HA");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-country']"), "United Kingdom");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-zone']"), "Greater London");
        Thread.sleep(1000);
        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        //2.22 Add Comments About your order into text area
        sendTextToElements(By.xpath("//textarea[@name='comment']"),"None");
        Thread.sleep(1000);
        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        //2.25 Verify the message “Warning: Payment method required!”
        String exError = "Warning: Payment method required!";
        String acError = getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
       Assert.assertEquals(exError,acError);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}










