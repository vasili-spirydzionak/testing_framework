package com.epam.utils.property_handler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FirefoxDriverPropertyHandler extends PropertyHandler {

    private String firefoxDriverPath;

    public FirefoxDriverPropertyHandler() {
        super();
    }

    public String getDriverBinaryPath() {
        try {
            confProperties.load(fis);
            firefoxDriverPath = confProperties.getProperty("firefoxDriver.path");
        } catch (IOException e) {
            System.err.println(e.getCause());
        } finally {
            closeFIStream();
        }
        return firefoxDriverPath;
    }

    public List<String> getBrowserOptionsArgs() {
        List<String> firefoxOptionsArgs = new ArrayList<String>();
        try {
            firefoxOptionsArgs = getPropListByKey("firefox.options.args");
        } catch (FileNotFoundException e) {
            System.err.println(e.getCause());
        } catch (IOException e) {
            System.err.println(e.getCause());
        } finally {
            closeFIStream();
        }
        return firefoxOptionsArgs;
    }
}
