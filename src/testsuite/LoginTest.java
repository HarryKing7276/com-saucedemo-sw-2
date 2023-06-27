package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
//  2.  Create the package ‘testsuite’ and create the following class inside the
//     ‘testsuite’ package.
//     1. LoginTest

public class LoginTest extends BaseTest {
    /**
     * 3. Write down the following test into ‘LoginTest’ class
     * 1. userShouldLoginSuccessfullyWithValidCredentials
     * * Enter “standard_user” username
     * * Enter “secret_sauce” password
     * * Click on ‘LOGIN’ button
     * * Verify the text “PRODUCTS”
     */
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {


        // * Enter “standard_user” username
        driver.findElement(By.xpath("//input[@class='input_error form_input'][@type='text']")).sendKeys("standard_user");
        // * Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // * Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        // * Verify the text “PRODUCTS”
        String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();
        String expectedText = "Products";
        Assert.assertEquals("We are not right text", actualText, expectedText);
        System.out.println("We are successfully on PRODUCTS with right x-path");
        Thread.sleep(5000);
    }

    /**
     * 2. verifyThatSixProductsAreDisplayedOnPage
     * * Enter “standard_user” username
     * * Enter “secret_sauce” password
     * * Click on ‘LOGIN’ button
     * * Verify that six products are displayed on page
     */
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException {
        // * Enter “standard_user” username
        driver.findElement(By.xpath("//input[@class='input_error form_input'][@type='text']")).sendKeys("standard_user");
        // * Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // * Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //  * Verify that six products are displayed on page
        // Class Name locator to find multiple elements - image/products on page
        List<WebElement> listOfProducts = driver.findElements(By.xpath("//img[@class='inventory_item_img']"));
        System.out.println("Total products displayed are " + listOfProducts.size());

        Thread.sleep(5000);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
