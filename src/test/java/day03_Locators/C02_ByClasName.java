package day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ByClasName {
    public static void main(String[] args) throws InterruptedException {
        // amazona gidip nutella araması yapın
        //ilk sayfadakiürünlerden en yüksek fiyatlısını bulun

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.amazon.com");
        Thread.sleep(3000);

        WebElement aramaKutusu=driver.findElement(By.name("field-keywords"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);

        List<WebElement> fiyatlarListesi= driver.findElements(By.className("a-price-whole")) ;
        // WebElement bir obje oldugundan, direk yazdirilamaz
        System.out.println(fiyatlarListesi);

        // Bunun icin for-each loop kullanarak
        // her bir webelement uzerindeki yazilari tek tek yazdirmaliyiz
        for (WebElement each: fiyatlarListesi
        ) {
            System.out.print(each.getText()+" ");
        }
        // en yuksek fiyati bulabilmek icin java bilgimizi kullanmaliyiz
        // 1- web elementlerden getText ile fiyati String olarak alin
        // 2- string fiyati kiyaslama yapabilmek icin Integer'a cevirin
        // 3- en yuksek fiyati bulup yazdirin

        String fiyatStr;
        Integer fiyatInt;
        Integer enYuksekFiyat=0;
        for (WebElement each: fiyatlarListesi) {

            fiyatStr= each.getText();
            fiyatInt=Integer.parseInt(fiyatStr);

            if (fiyatInt>enYuksekFiyat){
                enYuksekFiyat=fiyatInt;
            }

        }
        System.out.println("");
        System.out.println("En yuksek urun fiyati : " + enYuksekFiyat);


        Thread.sleep(3000);
        driver.close();
    }
}
