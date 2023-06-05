package techproed.day05_Xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C03_relativeLocators {
    public static void main(String[] args) throws InterruptedException {
        /*
        Benzer özelliklere sahip web elemntler icin relativ locator kullanabilirz.
        SYNTAX,
        driver.findElement(with(By.tagname).below().above().to_left_of().to_right_of().near()) gibi methodlr ile benzer özellillere sahip
        web elementleri locatini almadan o web elemente ulasabilriz.
         */
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--lang=en");
        WebDriver driver = new ChromeDriver(opt);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //amazona gidelim
        driver.get("https://amazon.com");



        //city bike aratalim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='text']"));
        aramaKutusu.sendKeys("city bike", Keys.ENTER);

        //relative locator kullanarak hybrid bikes altindaki elemente tiklayalim.
        //Webelemntlerin yazisini konsola yazdiralim.
        WebElement hybridBike = driver.findElement(By.xpath("//*[text()='Hybrid Bikes']"));
        System.out.println(hybridBike.getText());
        WebElement electricBike = driver.findElement(with(By.tagName("a")).below(hybridBike));
        System.out.println(electricBike.getText());
        WebElement completeBike = driver.findElement(with(By.tagName("a")).below(electricBike));
        System.out.println(completeBike.getText());
        System.out.println("**********************************************************");

        //Bikes altindaki tüm linkleri(web elementleri) console yazdiralim.
        List<WebElement> linklerListesi = driver.findElements(By.xpath("(//*[@class='a-list-item'])[position()>=9 and position()<=15]"));
        /*
        xpath kullaniminda bir sayfadaki webelementlere müdahale etmek istedigimizde xpath ile locate aldigimizda birden fazla sonuc verebilir.
        [position()>=9 and position()<=15] --> bu kullanimla aralik belirterek istedigimiz webelemntleri secip müdahale edebilirz.
         */

        //lambda ile yazdirdik.
        linklerListesi.forEach(t-> System.out.println(t.getText()));
        System.out.println("*******************************************************");
        //foreach ile yazdirdik
        for (WebElement w:linklerListesi) {
            System.out.println(w.getText());
        }

        //Bu linklerin hepsini tiklayalim ve sayfa basliklarini alalim.
        for (int i = 0; i < linklerListesi.size(); i++) {
            linklerListesi = driver.findElements(By.xpath("(//*[@class='a-list-item'])[position()>=10 and position()<=16]"));
            linklerListesi.get(i).click();
            Thread.sleep(3000);
            driver.navigate().back();
            Thread.sleep(3000);
        }



        //completeBike.click();

        //sayfayi kapatalim
        driver.close();



















    }
}
