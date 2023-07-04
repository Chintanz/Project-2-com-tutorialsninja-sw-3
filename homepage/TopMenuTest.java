package homepage;

import Utility.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * create method with name "selectMenu" it has one parameter name "menu" of type string.
     */
    @Test
    public void selectMenu() {
        String menu = "Desktops";
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li/a[text()='" + menu + "']")).click();
    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        //Mouse hover on “Desktops” Tab and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='nav navbar-nav']/li/a[text()='Desktops']"));
        // call selectMenu method and pass the menu = “Show All Desktops”
        String menu = "Show All Desktops";
        driver.findElement(By.xpath("//a[contains(text(),'Show AllDesktops')]")).click();
        Thread.sleep(1000);
        //Verify the text ‘Desktops’
        String expectDesktops = "Desktops";
        String actualDesktops = getTextFromElement(By.xpath("//h2[normalize-space()='Desktops']"));
        Assert.assertEquals("Desktops",actualDesktops);
   }
   @Test
   public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
        //Mouse hover on “Laptops & Notebooks” Tab and click
       mouseHoverToElementAndClick(By.xpath("//ul[@class='nav navbar-nav']/li/a[text()='Laptops & Notebooks']"));
       //call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
       String menu = "Show All Laptops & Notebooks";
       driver.findElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]")).click();
       Thread.sleep(1000);
       // Verify the text ‘Laptops & Notebooks’
       String expectLapNote = "Laptops & Notebooks";
       String actualLapNote = getTextFromElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"));
       Assert.assertEquals("Laptops & Notebooks",actualLapNote);
   }
   @Test
   public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        // Mouse hover on “Components” Tab and click
       mouseHoverToElementAndClick(By.xpath("//a[text()='Components']"));
       //call selectMenu method and pass the menu = “Show All Components”
       String menu = "Show All Components";
       driver.findElement(By.xpath("//a[text()='Show AllComponents']")).click();
       Thread.sleep(1000);
       //Verify the text ‘Components’
       String expectComponents = "Components";
       String actualComponents = getTextFromElement(By.xpath("//h2[text()='Components']"));
       Assert.assertEquals("Components",actualComponents);
   }



    @After
        public void tearDown () {
        closeBrowser();
        }

    }


