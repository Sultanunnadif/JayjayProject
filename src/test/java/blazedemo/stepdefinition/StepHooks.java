package blazedemo.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import webdriverbase.BaseDriver;

public class StepHooks extends BaseDriver {
    @Before
    public void setUp() {
        getDriver();
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
