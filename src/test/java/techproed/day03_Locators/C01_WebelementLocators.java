package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_WebelementLocators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Arama kutusunu locate edelim
        //Arama kutusuna iphone yazdiralim ve aratalim.

        /*
        Bir webelementin locate'ini birden fazla kullanacaksaniz bir web element'e degisken olarak atayabilirsiniz.
        Webelement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox")); seklinde kullanabiliriz.
        1-Locate islemi bittikten sonra eger webelemente bir metin göndereceksek sendkeys() methodu kullaniriz.
        2-Webelemente tiklayacaksak click() methodu kullaniriz.
        3-webelementin üzerindeki yaziyi almak istiyorsak getText() methodunu kullaniriz.
        4-sendKeys() methodundan sonra (yani web elemnte metin gönderdikten sonra) Keys.ENTER ile ya da
        submit() methodu ile manuel olarak enter yaptigimiz gibi otomasyonda da yapabiliriz.

        */
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sayfayi kapatalim
        driver.close();



    }
}
