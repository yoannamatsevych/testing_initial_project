package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

//
//
//    private Driver(){}
//
//    private static WebDriver driver;
//
//    public static WebDriver getDriver(){
//        if(driver == null) {
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//
//                driver.manage().window().maximize();
//                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//            }
//            return driver;
//    }
//
//    public static void quitDriver(){
//        if(driver != null){
//            driver.manage().deleteAllCookies();
//            driver.quit();
//            driver = null;
//        }
//    }


    private static WebDriver driver;

    private Driver(){}

    public static WebDriver getDriver(){
        if(driver == null){
            //This info should come from a global file where we put such important information
            String browser = ConfigReader.getProperty("browser");

            switch (browser.toLowerCase()){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class);
                    driver = new SafariDriver();
                    break;
                default:
                    throw new IllegalStateException(browser + " browser does not match any case!!!");
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicitWait")), TimeUnit.SECONDS);
        }
        return driver;
    }


    public static void quitDriver(){
        if(driver != null){
            driver.manage().deleteAllCookies();
            driver.quit();
            driver = null;
        }
    }

}
