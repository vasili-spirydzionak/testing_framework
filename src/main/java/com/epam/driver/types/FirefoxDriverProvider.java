package com.epam.driver.types;

import com.epam.utils.property_handler.FirefoxDriverPropertyHandler;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverProvider implements DriverProvider {

    private String firefoxBinaryPath;
    private FirefoxOptions options;

    public FirefoxDriverProvider() {
        firefoxBinaryPath = new FirefoxDriverPropertyHandler().getDriverBinaryPath();
        options = new FirefoxOptions();
    }

    @Override
    public WebDriver getWebDriverObject(MutableCapabilities capabilities) {
        DriverProvider.setBinaryPathInSystemProperties(firefoxBinaryPath);
        FirefoxOptions options = (FirefoxOptions) capabilities;
        return new FirefoxDriver(options);
    }

    @Override
    public MutableCapabilities getCapabilities() {
        options.setCapability("firefox.binary", firefoxBinaryPath);
        options.addArguments(new FirefoxDriverPropertyHandler().getBrowserOptionsArgs());
        return options;
    }
}
