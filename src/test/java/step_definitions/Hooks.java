package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup(){
        // all logic for setup : creating object of webdriver, making some setting for webdriver
        System.out.println("Running in Cucumber Before hook");
    }
    @After
    public void cleanUp(){
        //all clean up logic: close browser , clean up cookies
        System.out.println("Running in Cucumber After hook");

    }
}
