package com.epam.utils.property_handler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChromeDriverPropertyHandler extends PropertyHandler {

    private String chromeDriverPath;

    public ChromeDriverPropertyHandler() {
        super();
    }

    public String getDriverBinaryPath() {
        try {
            super.confProperties.load(fis);
            chromeDriverPath = super.confProperties.getProperty("chromeDriver.path");
        } catch (IOException e) {
            System.err.println(e.getCause());
        } finally {
            super.closeFIStream();
        }
        return chromeDriverPath;
    }

    public List<String> getBrowserOptionsArgs() {
        List<String> chromeOptionsArgs = new ArrayList<String>();
        try {
            chromeOptionsArgs = getPropListByKey("chrome.options.args");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            super.closeFIStream();
        }
        return chromeOptionsArgs;
    }
}
