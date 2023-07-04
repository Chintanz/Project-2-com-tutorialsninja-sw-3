package desktops;

import Utility.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class DesktopsTest extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
@Test
public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
   //Mouse hover on Desktops Tab.and click
    mouseHoverToElementAndClick(By.xpath("//ul[@class='nav navbar-nav']/li/a[text()='Desktops']"));
  //Click on “Show All Desktops”
  clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
  //Select Sort By position "Name: Z to A"
   clickOnElement(By.xpath("//select[@id='input-sort']/option[text()='Name (Z - A)']"));
   Thread.sleep(1000);
   //Verify the Product will arrange in Descending order.
    }
@Test
public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
    //Mouse hover on Desktops Tab.and click
    mouseHoverToElementAndClick(By.xpath("//ul[@class='nav navbar-nav']/li/a[text()='Desktops']"));
    //Click on “Show All Desktops”
    clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
    //Select Sort By position "Name: Z to A"
    clickOnElement(By.xpath("//select[@id='input-sort']/option[text()='Name (Z - A)']"));
    Thread.sleep(1000);
    //Select product “HP LP3065
    mouseHoverToElementAndClick(By.xpath("//a[text()='HP LP3065']"));
    //Verify the Text "HP LP3065
    String exHPLP3065 = "HP LP3065";
    String acHPLP3065 = getTextFromElement(By.xpath("//h1[text()='HP LP3065']"));
    Assert.assertEquals("HP LP3065",acHPLP3065);
    Thread.sleep(1000);
    // Select Delivery Date "2022-11-30"
    //Enter Qty "1” using Select class.
    clickOnElement(By.xpath("//input[@id='input-quantity']"));
    //Click on “Add to Cart” button
    clickOnElement(By.xpath("//button[@id='button-cart']"));
    Thread.sleep(1000);
    //Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
    String actualMessage = "Success: You have added HP LP3065 to your shopping cart";
    String expectedMessage = driver.findElement(By.xpath("//div[text()='Success: You have added ']")).getText();
    String[] exp = expectedMessage.split("!");
    Assert.assertEquals("Error Message is not Displayed", exp[0], actualMessage);
    Thread.sleep(1000);
    // Click on link “shopping cart” display into success message
    clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
    // Verify the text "Shopping Cart"
    String actMessage = "Shopping Cart";
    String expMessage = driver.findElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")).getText();
    String[] exp1 = expectedMessage.split("(1.00kg)");
    Assert.assertEquals("Error Message is not Displayed", exp[0], actualMessage);
    Thread.sleep(1000);
    //Verify the Product name "HP LP3065"
     String exptHPLP3065= "HP LP3065";
     String actHPLP3065 = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/a[1]"));
     Assert.assertEquals("HP LP3065",actHPLP3065);
    Thread.sleep(1000);
     //Verify the Delivery Date "2022-11-30"
    String exptDate= "2022-11-30";
    String actDate = getTextFromElement(By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]"));
    Assert.assertEquals("2022-11-30",actDate);
    Thread.sleep(1000);
    //Verify the Model "Product21"
    String exptProduct= "Product21";
    String actProduct = getTextFromElement(By.xpath("//td[contains(text(),'Product 21')]"));
    Assert.assertEquals("Product21",actProduct);
    Thread.sleep(1000);
    //Verify the Todat "£74.73"
    String exptTotal= "£74.73";
    String actTotal = getTextFromElement(By.xpath("//td[text()='£74.73']"));
    Assert.assertEquals("£74.73",actTotal);
    Thread.sleep(1000);

}
    @After
    public void tearDown () {
      closeBrowser();
    }

}
