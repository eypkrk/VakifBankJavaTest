import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
//Her test başlarken yapılacak genel işlemler
public class BaseTest {
    WebDriver driver;
    TopMenu topMenu;

    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver();
    }
    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        topMenu = new TopMenu(driver);
        topMenu.invidualClick();
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }
}
