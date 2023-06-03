package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_findelements {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Sayfadaki linklerin sayısını ve linkleri yazdıralım.
        /*
        findelement ile bir webelemente ulasabilirken,birden fazla webelement icin findelement() methodunu kullaniriz.
        Bu webelement lerin sayisina ulasmak icin ya da bu web elementlerin yazisini konsola yazdirabilmek icin
        List<Webelement> linklerListesi = driver.findElement(By.locator("locator degeri") oalrak kullaniriz.
        Olusturmus oldugumuz list'i loop ile konsola yazdirabiliriz.
        */

        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("Linklerin Sayisi = "+ linklerListesi.size());

        for (WebElement w:linklerListesi) {
            System.out.println(w.getText());
        }
        /* Yazisi olmayan linkleri getirir bize.
        for (WebElement w:linklerListesi) {
    if (!w.getText().isEmpty()){
        System.out.println(w.getText());
    }
}
         */

        //lambda ile yazdiralim
        linklerListesi.forEach(link -> {if (!link.getText().isEmpty())
        {System.out.println(link.getText());}});

        //Hallo,anmelden webElementinin yazısını yazdıralım
        System.out.println("**********************************************************");
        System.out.println(driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText());
        WebElement webElementYazisi = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        System.out.println(webElementYazisi.getText());
        //webelement üzerindeki yaziyi almak istiyorsak getText() methodunu kullaniriz.




        driver.close();
    }
    /*
    ÖDEV

    //Amazon sayfasına gidiniz
    //iphone aratınız
    //çıkan sonuç yazısını konsola yazdırınız
    //çıkan ürünlerden ilk 5 tanesine tıklayıp sayfa başlıklarını yazdırınız
     */

}
