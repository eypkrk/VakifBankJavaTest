import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

// temel işlemlerin tutulduğu class find search vs.
public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    String baseUrl = "https://www.vakifbank.com.tr/";

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }


    public void click(By locator){
        find(locator).click();
    }

    public void sKeys(By locator,String text){
        find(locator).sendKeys(text);
    }

    public void scroll(int value){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,"+ value +")");
    }

    public void seeForWait(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void Selector(WebElement locator,String text){
        Select chooseMonth = new Select(locator);
        chooseMonth.selectByVisibleText(text);
    }

    public void chooseDay(By locator,String text){
        List<WebElement> days = driver.findElements(locator);
        for(WebElement day:days){
            String cDay = day.getText();
            if (cDay.equals(text)){
                day.click();
            }
        }
    }

    public void moveTo(WebElement locator){
        actions = new Actions(driver);
        actions.moveToElement(locator).perform();
    }

    public void useKeyboard(By locator,Keys btn){
        find(locator).sendKeys(btn);
    }
}
