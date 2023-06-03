package techproed.day04_Locators_Xpath_Css;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C02_WebelementLocator {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://amazon.com");

        // arama kutusuna "city bike" yazıp aratın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike", Keys.ENTER);

       // sonuc yazısını yazdırın
        List<WebElement> sonucYazisi = driver.findElements(By.className("sg-col-inner"));
        System.out.println(sonucYazisi.get(0).getText());

        //Xpath ile List kullanmadan tek seferde locate aldik
        WebElement sonucYazisiXpath = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        // sonuc sayısını yazdırın
        String [] sonucSayisi = sonucYazisi.get(0).getText().split(" ");
        System.out.println("sonucSayisi = " + sonucSayisi[2]);

        //Sayfadaki onikinci elementi list kullanmadan xpath'in index özelligini kullanarak locate aldik.
        //xpath te index ile degil sira mantigi ile aliyoruz.
        WebElement onikinciElement = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[12]"));
        System.out.println(onikinciElement.getText());

        // ilk ürünün locatini alın
        List<WebElement> urunler = driver.findElements(By.className("s-image"));
        WebElement ilkUrun = urunler.get(0);

       // ilk ürünün, görünür olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkUrun.isDisplayed());//True

        // ilk ürünün, erisilebilir olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkUrun.isEnabled());//True

        // ilk ürünün, secilebilir olup olmadıgını true, false seklinde yazdırın
        System.out.println(ilkUrun.isSelected());//False döner cünkü web element secilme özelligine sahip degil.

        // ilk urune tıklayın
        ilkUrun.click(); //web elementin üstüne tiklar.

       // sayfayı kapatın
        driver.close();

        //Relative Xpath syntax -->  //tagname[@attributeName='atributeValue']
                                     //input[@type ='text']
      //                             (//input[@type='type'])[1]
                                      //*[@type='text']

        /*Aldigimiz xpath unique olmadigi zaman parantez kullanarak index belirtebiliriz.
          Böylelikle webelementleri List'e atip istedigimiz elemnti almakla ugrasmayiz.
          Xpath'in degisik kullanma yollari vardir.
        */

        /*
        ÖDEV
        //Techproeducation sayfasına gidelim
    //Çıkan reklamı locate edip kapatalım
    //Arama bölümünde qa aratalım
    //Sayfa başlığının qa içerdiğini doğrulayalım
    //Carrer Opportunities In QA linkinin görünür ve erişilebilir olduğunu doğrulayalım
    //Carrer Opportunities In QA linkine tıklayalım
    //Başlığın Opportunities içerdiğini test edelim
    //Tekrar anasayfaya dönelim ve url'in https://techproeducation.com/ olduğunu doğrulayalım
        */
        /*
        ÖDEV
        //https://id.heroku.com/login sayfasina gidin
        //Bir mail adersi giriniz
        //Bir password giriniz
        //Login butonuna tiklayiniz
        //"There was a problem with your login." texti gorunur ise
        //"kayit yapilamadi" yazdiriniz
        //eger yazi gorunur degilse "kayit yapildi" yazdiriniz
        //sayfayı kapatiniz
         */


    }
}
/*
TÜM ÖDEVLER
**********************************************
ödev : 1
GetMethods
Amazon sayfasina gidelim. https://www.amazon.com/
Sayfa basligini(title) yazdirin
Sayfa basliginin "Amazon" icerdigini test edin
Sayfa adresini(url) yazdirin
Sayfa url'inin "amazon" icerdigini test edin.
Sayfa handle degerini yazdirin
Sayfa HTML kodlarinda "Gateway" kelimesi gectigini test edin
Sayfayi kapatin.
**********************************************
ödev : 2
NavigationMethods
Youtube ana sayfasina gidelim . https://www.youtube.com/
Amazon soyfasina gidelim. https://www.amazon.com/
Tekrar YouTube'sayfasina donelim
Yeniden Amazon sayfasina gidelim
Sayfayi Refresh(yenile) yapalim
Sayfayi kapatalim / Tum sayfalari kapatalim
**********************************************
ödev : 3
ManageWindow
Amazon soyfasina gidelim. https://www.amazon.com/
Sayfanin konumunu ve boyutlarini yazdirin
Sayfayi simge durumuna getirin
simge durumunda 3 saniye bekleyip sayfayi maximize yapin
Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
Sayfayi fullscreen yapin
Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
Sayfayi kapatin
**********************************************
ödev : 4
ManageWindowSet
Amazon soyfasina gidelim. https://www.amazon.com/
Sayfanin konumunu ve boyutlarini yazdirin
Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
Sayfayi kapatin
**********************************************
ödev : 5
Yeni bir class olusturalim (Homework)
ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) "facebook"
oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
Sayfa URL'inin "facebook" kelimesi icerdigini dogrulayin, icermiyorsa "actual" URL'i
yazdirin.
https://www.walmart.com/ sayfasina gidin.
Sayfa basliginin "Walmart.com" icerdigini dogrulayin.
Tekrar "facebook" sayfasina donun
Sayfayi yenileyin
Sayfayi tam sayfa (maximize) yapin  9.Browser'i kapatin
**********************************************
ödev : 6
Youtube web sayfasına gidin ve sayfa başlığının "youtube" olup olmadığını doğrulayın  (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
Sayfa URL'sinin "youtube" içerip içermediğini (contains) doğrulayın, içermiyorsa doğru  URL'yi yazdırın.
Daha sonra Amazon sayfasina gidin https://www.amazon.com/
Youtube sayfasina geri donun
Sayfayi yenileyin
Amazon sayfasina donun
Sayfayi tamsayfa yapin
Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa  doğru başlığı(Actual Title) yazdırın.
Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
URL'yi yazdırın
Sayfayi kapatin
**********************************************
ödev : 7
Amazon sayfasına gidiniz
iphone aratınız
çıkan sonuç yazısını konsola yazdırınız
çıkan ürünlerden ilk 5 tanesine tıklayıp sayfa başlıklarını yazdırınız
CÖZÜM:
//-ÖDEV-
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");
        //iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //çıkan sonuç yazısını konsola yazdırınız
        WebElement sonucYazisi = driver.findElement(By.xpath("//h1//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());
        String [] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi = "+sonucSayisi[2]);
        //çıkan ürünlerden ilk 5 tanesine tıklayıp sayfa başlıklarını yazdırınız
        for (int i = 0; i < 5 ; i++) {
            List<WebElement> urunler = driver.findElements(By.xpath("//*[@class='a-section aok-relative s-image-fixed-height']"));
            Thread.sleep(2000);
            urunler.get(i).click();
            Thread.sleep(2000);
            System.out.println((i+1)+". Urun basligi : "+driver.getTitle());
            driver.navigate().back();
            Thread.sleep(2000);
        }
        driver.close();
 */
