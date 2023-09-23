import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;

//Test işlemlerinin yapıldığı class
public class Test_TopMenu extends BaseTest{

    @Test
    public void invidualTest()throws Exception{
        topMenu.invidualClick();
        topMenu.digitalBtn();
        topMenu.scroll(200);
        topMenu.openBank();
        topMenu.scroll(200);
        driver.navigate().back();
        topMenu.backWait();
        topMenu.remoteCustomer();
        topMenu.scroll(200);
        driver.navigate().back();
        topMenu.scroll(200);
        driver.navigate().back();
        topMenu.scroll(200);
        topMenu.nextSlider();
    }

    @Test
    public void invidualCredit(){
        topMenu.invidualCredit();
        topMenu.scroll(200);
        topMenu.applyNow();
        topMenu.switchTo();//Sağ click aktif olmadığı için alanları bulamıyoruz.Sendkeys yapamıyoruz.
        driver.switchTo().parentFrame();
    }

    @Test
    public void cards(){
        topMenu.cards();
    }

    @Test
    public void investment()throws Exception{
        topMenu.investment();
    }
    @Test
    public void pay(){
        topMenu.pay();
        Assertions.assertEquals("Vinov Nedir?",topMenu.assertText(),"Text is not equals");
    }
    @Test
    public void insurance(){
        topMenu.insurance();
        Assertions.assertEquals("Tüm risklere karşı Türkiye Sigorta'dan eksiksiz güvence!",topMenu.insuranceText(),"Text is not equals!!!");
    }
    @Test
    public void searchBtn()throws Exception{
        topMenu.searchBtn();//arama kısmı işlevini yerine getirmediinden arama yapamıyoruz.
    }
}
