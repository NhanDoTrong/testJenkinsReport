package testcases.techpanda.account;

import cores.common.BasePage_Executor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Level_02_Apply_BasePage_Part_II_Teacher {
    WebDriver driver;
    BasePage_Executor basePage;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();

        basePage = new BasePage_Executor();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @BeforeMethod
    public void beforeMethod() {
        basePage.openPageUrl(driver,"http://live.techpanda.org/");
        basePage.clickToElement(driver,"//div[@class='footer']//a[text()='My Account']");
    }

    @Test
    public void TC_01_LoginWithEmptyEmailAndPassword() {
        basePage.sendKeyToElement(driver,"//input[@id='email']","");
        basePage.sendKeyToElement(driver,"//input[@id='pass']","");
        basePage.clickToElement(driver,"//button[@id='send2']");
        basePage.getTextElement(driver,"//div[@id='advice-required-entry-email']");
        assertEquals(basePage.getTextElement(driver,"//div[@id='advice-required-entry-email']"), "This is a required field.");
        assertEquals(basePage.getTextElement(driver,"//div[@id='advice-required-entry-pass']"), "This is a required field.");
    }

    @Test
    public void TC_02_LoginWithInvalidEmail() {
        driver.findElement(By.id("email")).sendKeys("123@456.789");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();

        assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test(description = "Email not exist in application")
    public void TC_03_LoginWithIncorrectEmail() {
        driver.findElement(By.id("email")).sendKeys("auto_test" + randomNumber() + "@live.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();

        assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(), "Invalid login or password.");
    }

    @Test(description = "Password less than 6 characters")
    public void TC_04_LoginWithInvalidPassword() {
        driver.findElement(By.id("email")).sendKeys("auto_test" + randomNumber() + "@live.com");
        driver.findElement(By.id("pass")).sendKeys("123");
        driver.findElement(By.id("send2")).click();

        assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void TC_05_LoginWithIncorrectPassword() {
        driver.findElement(By.id("email")).sendKeys("auto_test" + randomNumber() + "@live.com");
        driver.findElement(By.id("pass")).sendKeys(randomNumber() + "");
        driver.findElement(By.id("send2")).click();

        assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(), "Invalid login or password.");
    }

    @Test
    public void TC_06_LoginWithValidEmailAndPassword() {
        driver.findElement(By.id("email")).sendKeys("automationfc.vn@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123123");
        driver.findElement(By.id("send2")).click();

        assertTrue(driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p[contains(.,'Automation FC')]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p[contains(.,'automationfc.vn@gmail.com')]")).isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int randomNumber() {
        Random rand = new Random();
        return rand.nextInt(999999);
    }

}

