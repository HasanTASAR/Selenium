package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3 {
    /* ...Exercise3...
    go to url : https://www.techlistic.com/p/selenium-practice-form.html
    fill the firstname
    fill the lastname
    check the gender
    check the experience
    fill the date
    choose your profession -> Automation Tester
    choose your tool -> Selenium Webdriver
    choose your continent -> Europa
    choose your command  -> Browser Commands
    click submit button
 */
    public static void main(String[] args) {
        System.setProperty("driver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1- go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");


        //2-fill the firstname
        driver.findElement(By.name("firstname")).sendKeys("Adım"+ Keys.ENTER);

        //3-fill the lastname
        driver.findElement(By.name("lastname")).sendKeys("Soyadım"+ Keys.ENTER);

        //4- check the gender
        driver.findElement(By.id("sex-0")).click();
        /*
         WebElement genderRadioButton = driver.findElement(By.id("sex-0"));
        genderRadioButton.click();
        genderRadioButton.sendKeys(Keys.PAGE_DOWN);
         */

        //5-check the experience
        driver.findElement(By.id("exp-1")).click();

        //6-fill the date
        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("25.12.2022"+Keys.ENTER);

        //7- choose your profession -> Automation Tester
        driver.findElement(By.id("profession-1")).click();

        //8-choose your tool -> Selenium Webdriver
        driver.findElement(By.id("tool-2")).click();

        //9-  choose your continent -> Europa
        driver.findElement(By.id("continents")).sendKeys("Europa" + Keys.ENTER);

        //10-    choose your command  -> Browser Commands
        driver.findElement(By.xpath("//option[text()='Browser Commands']")).click();

        //11-    click submit button
        driver.findElement(By.id("submit")).click();

       driver.close();
    }
}
