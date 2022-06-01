package com.hiberus.university.selenium.support;

import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.utils.Flags;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import net.masterthought.cucumber.ReportBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static com.hiberus.university.selenium.utils.Methods.*;
import static org.openqa.selenium.remote.BrowserType.*;

@Slf4j
public class Hooks {
    private WebDriver driver;
    @Before
    public void before(Scenario scenario) {
        log.info("Starting scenario: " + scenario.getName());
        String browser = Flags.getInstance().getBrowser();
        boolean headless = Flags.getInstance().isHeadless();

        switch (browser) {
            case FIREFOX:
                driver = initFirefoxDriver(headless);
                break;
            case EDGE:
                driver = initEdgeDriver();
                break;
            default:
                driver = initChromeDriver(headless);
        }

        PagesFactory.start(driver);
    }

    @After
    public void after(Scenario scenario) {
        log.info("Ending scenario: " + scenario.getName());

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Imagen Scenario Fallido - " + scenario.getName());
        }

        driver.close();
    }

}
