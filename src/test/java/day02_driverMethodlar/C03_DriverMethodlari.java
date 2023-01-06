package day02_driverMethodlar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.amazon.com");


        // pageSource'un MEOW icerdigini test edin

        String pageSource= driver.getPageSource();

        String expectedKelime="MEOW";

        if (pageSource.contains(expectedKelime)){
            System.out.println("page source testi PASSED");
        } else{
            System.out.println("Page source testi FAILED, MEOW kelimesi bulunamadi");
        }


        Thread.sleep(3000);
        driver.close();
    }
}


