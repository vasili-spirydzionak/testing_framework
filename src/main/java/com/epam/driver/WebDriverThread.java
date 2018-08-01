package com.epam.driver;

import com.epam.driver.types.DriverProvider;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import static com.epam.driver.DriverTypeEnum.FIREFOX;

public class WebDriverThread {

    private final DriverTypeEnum DEFAULT_BROWSER = FIREFOX;
    private WebDriver webdriver;
    private DriverTypeEnum chosenDriver;

    public WebDriver getDriver() throws Exception {
        if (null == webdriver) {
            chosenDriver = defineType();
            instantiateBrowser();
        }
        return webdriver;
    }

    public void quitDriver() {
        if (null != webdriver) {
            webdriver.quit();
            webdriver = null;
        }
    }

    public void instantiateBrowser() throws MalformedURLException {
        webdriver = chosenDriver.getWebDriverObject();
    }

    public DriverTypeEnum defineType() {
        DriverTypeEnum type = null;
        try {
            type = DriverTypeEnum.valueOf(DriverProvider.getBrowserNameFromSysProperties().toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            System.err.println("The entered type is not supported or was not entered at all defaulting to " + DEFAULT_BROWSER);
            type = DEFAULT_BROWSER;
        }
        return type;
    }
}