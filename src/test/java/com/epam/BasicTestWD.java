package com.epam;

import com.epam.driver.DriverFactory;
import com.epam.page.StartPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BasicTestWD extends DriverFactory {
    private StartPage start = null;

    @BeforeSuite
    public void setUp() {
        try {
            DriverFactory.instantiateDriverObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public void getPage() {
        start = new StartPage();
    }

    @Test
    public void cheeseExample() throws Exception {
        start.googleExampleThatSearchesFor("Cheese!");
    }

    @Test
    public void googleMilkExample() throws Exception {
        start.googleExampleThatSearchesFor("Milk!");
    }

    @Test
    public void googleAppleExample() throws Exception {
        start.googleExampleThatSearchesFor("Apple!");
    }

    @Test
    public void googleNutExample() throws Exception {
        start.googleExampleThatSearchesFor("Nut!");
    }

    @AfterSuite
    public void tearDown() {
        try {
            DriverFactory.quitDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

