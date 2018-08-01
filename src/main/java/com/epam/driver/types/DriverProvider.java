package com.epam.driver.types;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

public interface DriverProvider {

    static void setBinaryPathInSystemProperties(String path) {
        if (path.contains("chromedriver")) {
            System.setProperty("webdriver.chrome.driver", path);
        } else if (path.contains("geckodriver")) {
            System.setProperty("webdriver.gecko.driver", path);
        }
    }

    static String getBrowserNameFromSysProperties(){
            return System.getProperty("browser.name");
    }


    WebDriver getWebDriverObject(MutableCapabilities capabilities);

    MutableCapabilities getCapabilities();

    ;

}
