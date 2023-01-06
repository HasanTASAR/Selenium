package A_Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class A03_2_ByClasName {
    public static void main(String[] args) throws InterruptedException {
        System.getProperty("webdriver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.get("https://www.trendyol.com");
        Thread.sleep(3000);

        WebElement aramaKutusu= driver.findElement(By.className("vQI670rJ"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);


        List<WebElement> fiyatListesi=driver.findElements(By.className("prc-box-dscntd"));
        System.out.println(fiyatListesi+" : ");

        for (WebElement each: fiyatListesi) {

            System.out.println(each.getText().replace("TL", "").replace(" ","").replace(",","."));
        }
        String fiyatStr;
        Double fiyatDoub;
        Double enYuksekFiyatDoub=0.0;
        for (WebElement each: fiyatListesi) {

            fiyatStr= each.getText().replace("TL", "").replace(" ","").replace(",",".");
            fiyatDoub=Double.parseDouble(fiyatStr);

            if (fiyatDoub>enYuksekFiyatDoub){
                enYuksekFiyatDoub=fiyatDoub;
            }
        }
        System.out.println("");
        System.out.println("En yuksek urun fiyati : " + enYuksekFiyatDoub);

        Thread.sleep(3000);
        driver.close();
    }
}
