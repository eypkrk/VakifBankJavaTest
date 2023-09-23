import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

//üst tarafta bulunan butonlar için genel bir class
public class TopMenu extends BasePage{
    int i;
    private final By individualId = By.id("ctl00_ctl06_ctl00_rptMenu_ctl00_hypLink");
    private final By nextBtn = By.cssSelector("div[class='slick-holder slick-initialized slick-slider slick-dotted'] button[class='slick-next slick-arrow']");

    private final By digital = By.cssSelector("li a[id='ctl00_ctl06_ctl00_rptMenu_ctl02_hypLink']");

    private final By openBank = By.xpath("//div[1][@class='krediBox clearfix']");
    private final By remoteCustomer = By.xpath("//div[2][@class='krediBox clearfix']");
    private final By invidualCredit = By.cssSelector("a[id='ctl00_ctl06_ctl00_rptMenu_ctl03_hypLink']");
    private final By applyNow = By.cssSelector("div[class='applyBox clearfix'] div[class='col-xs-12 col-sm-4'] ");
    private final By cards = By.cssSelector("li[class='level3'] a[id='ctl00_ctl06_ctl00_rptMenu_ctl04_hypLink']");
    private final By cardsApplyNow = By.cssSelector("div[id='ctl00_ctl12_ContentPane'] a[class='black-btn big']");
    private final By searchApplyCard = By.cssSelector("div[id='btnBasvur2'] input");
    private final By tcNo = By.cssSelector("td input[id='txtKimlikNo']");
    private final By phone3 = By.cssSelector("td input[id='txtCepTelKod']");
    private final By phone7 = By.cssSelector("td input[id='txtCepTelNo']");
    private final By search = By.cssSelector("td input[id='imgSorgula']");
    private final By creditCardApply = By.cssSelector("div input[id='imgKaydet']");
    private final By tcApplyCredit = By.cssSelector("td input[id='tbKimlikNo']");
    private final By back = By.cssSelector("td[align='center'] a img");
    private final By dateApplyCredit = By.cssSelector("div input[id='txtDogumTarihi']");
    private final By dateMonth = By.cssSelector("select[class='ui-datepicker-month']");
    private final By dateYear = By.cssSelector("select[class='ui-datepicker-year']");
    private final By dateDay = By.cssSelector("a[class='ui-state-default']");
    private final By monthsOfMoney = By.cssSelector("td input[id='txtGelir']");
    private final By phone3ForCard = By.cssSelector("td input[id='txtCepTelKod']");
    private final By phone7ForCard = By.cssSelector("td input[id='txtCepTelNo']");
    private final By cardType = By.cssSelector("div[id='SCPanelKartTip'] select");
    private final By lastDay = By.cssSelector("select[id='ddSonOdeme']");
    private final By radioInternet = By.cssSelector("input[id='ddSanalIslemIzni_1']");
    private final By electronicNews = By.cssSelector("input[id='rdTicariIzin_0']");
    private final By limit = By.cssSelector("input[id='rdPeriyodik_1']");
    private final By kvkk = By.cssSelector("input[id='chkKvkkOnaylama']");
    private final By backCard = By.cssSelector("a img[src='images/btn_geri.png']");
    private final By deposit = By.cssSelector("li a[id='ctl00_ctl06_ctl00_rptMenu_ctl06_hypLink']");
    private final By  bee = By.xpath("//div[1][@class='krediBox clearfix']/div[@class='krediText']");
    private final By openNow = By.xpath("//p[1]/a[@class='black-btn big']");
    private  final By pays = By.cssSelector("a[id='ctl00_ctl06_ctl00_rptMenu_ctl07_hypLink']");
    private final By afterOneBank = By.xpath("//div[1][@class='krediBox clearfix']/div");
    private final By forAssert = By.cssSelector("span[id='ctl00_ctl16_lblHeaderText']");
    private final By insurance = By.cssSelector("a[id='ctl00_ctl06_ctl00_rptMenu_ctl08_hypLink']");
    private final By forInsuranceAssert = By.cssSelector("div[id='ctl00_ctl12_ContentPane'] h3");
    private final By searchBtn = By.cssSelector("div[class='new-search visible-lg']");
    private final By textAreaSearch = By.cssSelector("div[class='new-search visible-lg'] input[type='text']");


    public TopMenu(WebDriver driver) {
        super(driver);
        driver.get(baseUrl);
    }

    public void invidualClick(){
        seeForWait(individualId);
        click(individualId);
    }

    public void nextSlider()throws Exception{
       int x = 10;
       for (i = 0; i < x; i++){
           click(nextBtn);
           Thread.sleep(3000);
       }
    }

    public void digitalBtn(){
        click(digital);
    }

    public void openBank(){
        seeForWait(openBank);
        click(openBank);
    }

    public void remoteCustomer(){
        click(remoteCustomer);
    }

    public void backWait(){
        seeForWait(openBank);
    }
    public void invidualCredit(){
        seeForWait(invidualCredit);
        click(invidualCredit);
    }
    public void applyNow(){
        click(applyNow);
    }
//yeni sekmeye geçmek için yapılan işlem
    public void switchTo(){
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }
//kartlar
    public void cards(){
        click(cards);
        scroll(200);
        click(cardsApplyNow);
        click(searchApplyCard);
        sKeys(tcNo,"1234568989631");
        sKeys(phone3,"123");
        sKeys(phone7,"8956522");
        click(search);
        click(back);
        click(creditCardApply);
        sKeys(tcApplyCredit,"1234568989631");
        seeForWait(dateApplyCredit);
        click(dateApplyCredit);
        WebElement dateMonths = driver.findElement(dateMonth);
        Selector(dateMonths,"Oca");
        seeForWait(dateYear);
        WebElement dateYears = driver.findElement(dateYear);
        Selector(dateYears,"2020");
        chooseDay(dateDay,"30");
        sKeys(monthsOfMoney,"150000");
        sKeys(phone3ForCard,"123");
        sKeys(phone7ForCard,"7894562");
        WebElement cardsType = driver.findElement(cardType);
        Selector(cardsType,"Galatasaray");
        WebElement lastDays = driver.findElement(lastDay);
        Selector(lastDays,"2. Hafta");
        click(radioInternet);
        click(electronicNews);
        click(limit);
        click(kvkk);
        click(backCard);
    }
//yatırım
    public void investment()throws Exception{
        click(deposit);
        scroll(200);
        click(bee);
        scroll(400);
        seeForWait(openNow);
        click(openNow);
        Thread.sleep(7000);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(tabs.get(0));
        System.out.println(driver.getCurrentUrl());

    }
    //ödeme
    public void pay(){
        click(pays);
        scroll(200);
        click(afterOneBank);
        scroll(200);
    }
    //ödeme assert işlemi için
    public String assertText(){
        WebElement stext = find(forAssert);
        return stext.getText();
    }
//sigorta
    public void insurance(){
        click(insurance);
        scroll(200);

    }
//bireysel içinde ki yazı asser etmek için yapılan kısım
    public String insuranceText(){
        WebElement sText = find(forInsuranceAssert);
        return sText.getText();
    }

    //arama butonu için yapıldı
    public void searchBtn()throws Exception{
        WebElement search = find(searchBtn);
        moveTo(search);
        seeForWait(textAreaSearch);
        sKeys(textAreaSearch,"emekli");
        useKeyboard(textAreaSearch, Keys.ENTER);
        Thread.sleep(2000);
    }

}
