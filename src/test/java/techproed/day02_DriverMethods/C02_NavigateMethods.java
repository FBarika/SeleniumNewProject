package techproed.day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_NavigateMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Techproeducation sayfasina gidelim
        driver.navigate().to("https://techproeducation.com"); //get() methodu ile ayni mantikta calisir.
        Thread.sleep(3000);//Java kodlarini bekletmek icin Thread.sleep kullanabiliriz.

        //Sonra Amazon sayfasina gidelim
        driver.navigate().to("https://amazon.com");
        Thread.sleep(3000);

        //Amazon sayfasinin basligini yazdiralim
        System.out.println("Amazon Sayfa Basligi : " + driver.getTitle());
        Thread.sleep(3000);

        //Techproeducation sayfasina geri dönelim
        driver.navigate().back();
        Thread.sleep(3000);

        //Sayfa basligini yazdiralim
        System.out.println("Techproeducation Sayfa Basligi : " +driver.getTitle());
        Thread.sleep(3000);

        //Amazon sayfasina tekrar dönüp Url'i yazdiralim
        driver.navigate().forward();
        System.out.println("Amazon Sayfasi Url'i : " + driver.getCurrentUrl());
        Thread.sleep(3000);

        //Amazon sayfasindayken sayfayi yenileyelim.
        driver.navigate().refresh();
        Thread.sleep(3000);

        //Sayfayi kapatalim
        driver.close();

        /*
        ÖDEV

        Yeni bir Class olusturalim.C05_NavigationMethods
Youtube ana sayfasina gidelim . https://www.youtube.com/
Amazon soyfasina gidelim. https://www.amazon.com/
Tekrar YouTube’sayfasina donelim
Yeniden Amazon sayfasina gidelim
Sayfayi Refresh(yenile) yapalim
Sayfayi kapatalim / Tum sayfalari kapatalim

         */






    }
}
