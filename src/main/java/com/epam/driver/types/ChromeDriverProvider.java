package com.epam.driver.types;

import com.epam.utils.property_handler.ChromeDriverPropertyHandler;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverProvider implements DriverProvider {

    private String chromeBinaryPath;
    private ChromeOptions options;

    public ChromeDriverProvider() {
        chromeBinaryPath = new ChromeDriverPropertyHandler().getDriverBinaryPath();
        options = new ChromeOptions();
    }

    @Override
    public WebDriver getWebDriverObject(MutableCapabilities capabilities) {
        DriverProvider.setBinaryPathInSystemProperties(chromeBinaryPath);
        ChromeOptions options = (ChromeOptions) capabilities;
        return new ChromeDriver(options);
    }

    @Override
    public MutableCapabilities getCapabilities() {
        options.setCapability("chrome.binary", chromeBinaryPath);
        options.addArguments(new ChromeDriverPropertyHandler().getBrowserOptionsArgs());
        return options;
    }

}
