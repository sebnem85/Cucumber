package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    /*This method will get the hover over the WebElement
    You need to pass the element and driver.
    For example , we need to handle the action, drop-down,pop-ups etc. And you need to use "explicit wait"
    When you create a method in the BrowserUtils class whenever we can call this method it works anytime,anywhere and no
    need to create again and again.  */

    public static void hover(WebElement element, WebDriver driver) {

        Actions actions = new Actions(driver);

        actions.moveToElement(element).build().perform();
    }
    //HW==> drag and drop
    /*
    This method will take the text of the WebElement and return the String
    You need pass the element
     */
    public static String getText(WebElement element) {

        return element.getText();
    }

    /*
    This method will take the list of WeElement It will return list of text from the WebElement
     */
    public static List<String> getElementsText(List<WebElement> elements) {

        List<String> textList=new ArrayList<>();

        for (WebElement el:elements) {

            if(!el.getText().isEmpty()){
                textList.add(el.getText());

            }
        }
        return textList;
    }
    public static void visibilityOfElement(WebDriver driver, WebElement element, int time) {

        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element));


        //clickable,isAlertPresent------->use for all action methods  HW
    }
    public static void switchWindow(String targetTitle, WebDriver driver){

        String origin=driver.getWindowHandle();
        Set<String> allWindows=driver.getWindowHandles();
        for(String windows:allWindows){

            driver.switchTo().window(windows); // it switch the next one

            if(driver.getTitle().equals(targetTitle)){
                //break;
                return;

            }

        }

        driver.switchTo().window(origin);
    }


}



