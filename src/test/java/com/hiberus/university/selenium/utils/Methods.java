package com.hiberus.university.selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class Methods {

    public static WebDriver initChromeDriver(boolean headless) {
        // --------- CONFIGURACIÓN DEL DRIVER --------- \\
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--enable-features=NetworkService,NetworkServiceInProcess", "--disable-dev-shm-usage");
        if (headless)
            options.addArguments("--headless", "--window-size=1920,1200");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if (!headless)
            driver.manage().window().maximize();

        return driver;
    }

    public static WebDriver initFirefoxDriver(boolean headless) {
        // --------- CONFIGURACIÓN DEL DRIVER --------- \\
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--enable-features=NetworkService,NetworkServiceInProcess");
        if (headless)
            options.addArguments("--headless", "--window-size=1920,1200");

        WebDriver driver = new FirefoxDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public static WebDriver initEdgeDriver() {
        // --------- CONFIGURACIÓN DEL DRIVER --------- \\
        WebDriverManager.edgedriver().setup();

        WebDriver driver = new EdgeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }
}
