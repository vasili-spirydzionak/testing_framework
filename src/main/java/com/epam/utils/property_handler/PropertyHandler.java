package com.epam.utils.property_handler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public abstract class PropertyHandler {

    protected Properties confProperties;
    protected FileInputStream fis;
    protected String delimeter = "\\,";

    public PropertyHandler() {
        try {
            fis=new FileInputStream("src/main/resources/framework.properties");
            confProperties = new Properties();
        } catch (FileNotFoundException e) {
            System.err.println(e.getCause());
        }
    }

    public void closeFIStream() {
        try {
            fis.close();
        } catch (IOException e) {
            System.err.println(e.getCause());
        }
    }

    public List<String> getPropListByKey(String key) throws IOException {
        confProperties.load(fis);
        return Arrays.asList(confProperties.getProperty(key).split(delimeter));
    }

    public abstract String getDriverBinaryPath()throws IOException ;
    public abstract List<String> getBrowserOptionsArgs()throws IOException ;

}
