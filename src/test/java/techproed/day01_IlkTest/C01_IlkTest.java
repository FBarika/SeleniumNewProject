package techproed.day01_IlkTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkTest {
    public static void main(String[] args) {

       System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
       //Java uygulamalarinda system özellilerini ayarlamak icin setProperty methodu ile kullaniriz.
        System.out.println(System.getProperty("webdriver.chrome.driver"));
        //getProperty ile "Key" degerini girerek "value" ya ulasabilirim.
       WebDriver driver = new ChromeDriver();
       //ChromeDriver türünde yeni bir obje olusturduk.

       driver.get("https://www.techproeducation.com");//get() methodu ile String olarak girilen url'e gideriz.




    }
}
