package myaccounts;

import Utility.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class MyAccountsTest extends Utility {
    String baseUrl="http://tutorialsninja.com/demo/index.php";
    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }
    public void selectMyAccountOptions(String option)
    {
        String anyOption = option.toLowerCase();
        String expression = "//a[text()='" + anyOption + "']";
        driver.findElement(By.xpath(expression)).click();
    }
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        // Click on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));

        // Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        clickOnElement(By.xpath("//a[text()='Register']"));
        //selectMyAccountOptions("Register");

        // Verify the text “Register Account”.
        String expectedText = "Register Account";
        String actualText = getTextFromElement(By.xpath("//h1[text()='Register Account']"));
        Assert.assertEquals("Text : Register Account", expectedText, actualText);
    }
@Test
public void verifyUserShouldNavigateToLoginPageSuccessfully(){
    // Click on My Account Link.
    clickOnElement(By.xpath("//span[text()='My Account']"));

    // Call the method “selectMyAccountOptions” method and pass the parameter “Loginr”
    clickOnElement(By.xpath("//a[text()='Login']"));
    //selectMyAccountOptions("Register");

    // Verify the text “Returning Customer”.
    String expectedText = "Returning Customer";
    String actualText = getTextFromElement(By.xpath("//h2[text()='Returning Customer']"));
    Assert.assertEquals("Text : Returning Customer", expectedText, actualText);
}
@Test
public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
    // Click on My Account Link.
    clickOnElement(By.xpath("//span[text()='My Account']"));

    // Call the method “selectMyAccountOptions” method and pass the parameter “Register”
    clickOnElement(By.xpath("//a[text()='Register']"));
    Thread.sleep(1000);
    //selectMyAccountOptions("Register");
   //Enter First Name
    sendTextToElement(By.xpath("//input[@id='input-firstname']"),"Abcd");
    sendTextToElement(By.xpath("//input[@id='input-lastname']"),"Efgh");
    sendTextToElement(By.xpath("//input[@id='input-email']"),"xyz@gmail.com");
    Thread.sleep(1000);
    sendTextToElement(By.xpath("//input[@id='input-telephone']"),"01234567891");
    sendTextToElement(By.xpath("//input[@id='input-password']"),"chintz111");
    sendTextToElement(By.xpath("//input[@id='input-confirm']"),"chintz111");
    Thread.sleep(1000);
    clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
    clickOnElement(By.xpath("//input[@name='agree']"));
    clickOnElement(By.xpath("//input[@value='Continue']"));
    Thread.sleep(1000);
    // Verify the message “Your Account Has Been Created!”
    String expectedMessage = "Your Account Has Been Created!";
    String actualMessage = getTextFromElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
    Assert.assertEquals("Text : Your Account Has Been Created!", expectedMessage, actualMessage);
    //Click on Continue Button
    clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    Thread.sleep(1000);
    //Click on My Account Link.
    clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
    //Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
    clickOnElement(By.xpath("//a[contains(text(),'Logout')]"));
    // Verify the text “Account Logout”
    String expectedText = "Account Logout";
    String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
    Assert.assertEquals("Text : Account logout", expectedText, actualText);
    Thread.sleep(1000);
    //Click on Continue button
    clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
}
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        // Click on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));
        //Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        clickOnElement(By.xpath("//a[contains(text(),'Login')]"));
        Thread.sleep(1000);
        // Enter Email address
        sendTextToElements(By.xpath("//input[@id='input-email']"), "xyz@gmail.com");
        //Enter Password
        sendTextToElements(By.xpath("//input[@id='input-password']"), "chintz111");
        //Click on Login button
        clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));
        Thread.sleep(1000);
        //Verify text “My Account”
        String expectedText = "My Account";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'My Account')]"));
        // Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        Thread.sleep(1000);
        // Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        clickOnElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[5]/a[1]"));
        //Verify the text “Account Logout”
        String expectText = "Account Logout";
        String actText = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Assert.assertEquals("Text : Account logout", expectText, actText);
        // Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

@After
    public void tearDown() {
      closeBrowser();
    }

}
