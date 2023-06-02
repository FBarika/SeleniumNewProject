package techproed.day01_IlkTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {
    public static void main(String[] args) {
        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.com");
        //getTitle() Sayfa basligini verir.
        System.out.println("Amazon Actual Title : "+driver.getTitle());
        System.out.println("Amazon Actual Url : " + driver.getCurrentUrl()); //Amazon un Url' sini veriyor.
        String amazonWindowHandle = driver.getWindowHandle();
        System.out.println("Amazon Window Handle Degeri "+ amazonWindowHandle);


        driver.get("https://techproeducation.com");
        System.out.println("Techproeducation Actual Title : " + driver.getTitle());//Sayfa basligini verir.

        //getCurrentUrl() Gidilen sayfanin Url'ini verir.
        System.out.println("Techproed Actual Url : " + driver.getCurrentUrl());


        //getPageSource() Acilan sayfanin kaynak kodlarini verir.
        //System.out.println(driver.getPageSource());Bilerek yoruma aldik her calistirdigimizda console bütün kaynak kodlari verecegi icin

        //getWindowHandle() Gidilen sayfanin handle degerini(hashKod) verir. Bu handle degerini sayfalar arasi gecis icin kullaniriz.
        System.out.println("Techpro Window Handle Degeri : " + driver.getWindowHandle());




    }
}
