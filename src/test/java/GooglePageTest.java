import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GooglePageTest{
    public WebDriver driver;
    public WebDriver setUp(String browserName){

        if (browserName.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();

            System.out.println(browserName);
        }else if (browserName.equalsIgnoreCase("firefox")){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
            System.out.println(browserName);
        }

        driver.manage().window().maximize();
        return driver;
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void googleText() throws InterruptedException {
        setUp("Chrome");
        driver.get("https://www.google.com/");
        Thread.sleep(1000);
        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("naveen automation labs");
        driver.findElement(By.name("q")).submit();
        //driver.findElement(By.xpath("//h3"))
        System.out.println("jenkinssssss");
    }
    @Test
    public static void main(String[] args){
        System.out.println("jenkinssssss");
    }
}

