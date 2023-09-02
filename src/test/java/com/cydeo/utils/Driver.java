package com.cydeo.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            String browser = ConfigReader.getProperty("browser");
            switch (browser) {
                case "Chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    driverPool.get().manage().window().maximize();
                    break;

                case "Firefox":
                    System.out.println(WebDriverManager.firefoxdriver());
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    driverPool.get().manage().window().maximize();
                    break;

                case "Edge":
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS);
                    break;

                case "headless":
                    WebDriverManager.edgedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driverPool.set(new ChromeDriver(options));
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid browser name " + browser);
            }
        }

        return driverPool.get();
    }
    public static void driverQuit(){
        if(driverPool.get() != null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}

