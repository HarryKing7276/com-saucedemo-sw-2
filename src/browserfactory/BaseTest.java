package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    /**  1.  Create the package ‘browserfactory’ and create the
     *       class with the name ‘BaseTest’ inside the
     *      ‘browserfactory’ package. And write the browser setup
     *       code inside the class ‘Base Test’.
     */


    public void openBrowser(String baseUrl) {
        // Declare  the Browser
        driver = new ChromeDriver();
        // Launch the Url in the Browser
        driver.get(baseUrl);
        // Maximise the Browser
        driver.manage().window().maximize();
        // We will give implicit time to wait and load the Url
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    public void closeBrowser(){
        driver.quit();
    }

}
