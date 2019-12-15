package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
// purpose of driver class is to initialize the driver. Only one time initialize and as static. once you run script,
// run your test always system uses the same driver
        public static WebDriver driver;  // WebElement comes from Selenium. Selenium is not a tool.
                                        // Selenium only provide extra library which allows us to intract Html based web application.

        public static WebDriver driverSetup(String browser){
            if(driver !=null){
                return driver;
            }
            switch(browser.toLowerCase()){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "ff":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver=new InternetExplorerDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver=new OperaDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
            }
            driver.manage().window().fullscreen();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.HOURS.SECONDS);

            return driver;
        }
        public static void closeDriver(){
            if(driver !=null){
                driver.quit();
                driver=null;
            }
        }


    }



