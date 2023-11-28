package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    static String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }


    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {

        //Enter “standard_user” username
      sendTextToElement(By.xpath("//input[@name='user-name']"),"standard_user");


        // Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");

        // Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        // Verify the text “PRODUCTS”
        verifyText(By.xpath("//span[@class='title']"),"Products");


    }


    @Test
    public void verifyThatSixProductsAreDisplayedOnPage () {

        //  Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"),"standard_user");

        // Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");

        // Click on ‘LOGIN’ button
        sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");

       // Verify that six products are displayed on page
        List<WebElement> numberOfProduct = driver.findElements(By.className("inventory_item"));
        System.out.println("Number of Product in Page: " + numberOfProduct.size()); // display the no of products using size method



    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
