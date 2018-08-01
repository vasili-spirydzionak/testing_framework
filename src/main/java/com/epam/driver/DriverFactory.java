package com.epam.driver;

import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverFactory {
    private static ThreadLocal<WebDriverThread> driverThread;
    private static List<WebDriverThread> webDriverThreadPool = Collections.synchronizedList(new ArrayList<WebDriverThread>());

    public static WebDriver getDriver() throws Exception {
        WebDriver driver = driverThread.get().getDriver();
        return driver;
    }

    public static void instantiateDriverObject() throws Exception {
        driverThread = new ThreadLocal<WebDriverThread>() {
            @Override
            protected WebDriverThread initialValue() {
                WebDriverThread webDriverThread = new WebDriverThread();
                webDriverThreadPool.add(webDriverThread);
                return webDriverThread;
            }
        };
    }

    public static void quitDriver() throws Exception {
        for (WebDriverThread webDriverThread : webDriverThreadPool) {
            webDriverThread.quitDriver();
        }
    }
}
