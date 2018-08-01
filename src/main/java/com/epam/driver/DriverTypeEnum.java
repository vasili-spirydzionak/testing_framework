package com.epam.driver;

import com.epam.driver.types.ChromeDriverProvider;
import com.epam.driver.types.FirefoxDriverProvider;
import org.openqa.selenium.WebDriver;

public enum DriverTypeEnum {
    CHROME {
        public WebDriver getWebDriverObject() {
            ChromeDriverProvider chromeProvider = new ChromeDriverProvider();
            return chromeProvider.getWebDriverObject(chromeProvider.getCapabilities());
        }
    },
    FIREFOX {
        public WebDriver getWebDriverObject() {
            FirefoxDriverProvider firefoxProvider = new FirefoxDriverProvider();
            WebDriver driver = firefoxProvider.getWebDriverObject(firefoxProvider.getCapabilities());
            return driver;
        }
    };

    public abstract WebDriver getWebDriverObject();
}
