package my.samples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by sheppardt on 7/19/2016.
 */
public class searchGoogleTest {

    @DataProvider(name = "myShoppingTest")
    public Object[][] createData(){
        return new Object[][]{
                {"Best Buy"},
                {"Amazon"},
                {"Macy's"},
                {"Sears"}

        };
    }
    @Test(dataProvider = "myShoppingTest")
    public void method(String stores){

        // Create a new instance of the Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sheppardt\\Desktop\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        // Navigate to Google home page
        driver.get("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys(stores);

        // Submit the form (WebDriver will find the form for us from the element)
        element.submit();

        //Wait for results to be shown
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.titleContains(stores));

        // Should see: "[stores] - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }

}