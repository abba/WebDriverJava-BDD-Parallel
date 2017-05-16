package testhooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import static support.Driver.*;

/**
 * Created by zsuleiman on 31/01/2017.
 */
public class Hooks {



    @Before
    public void setUp() {

        setSystemsProperties();
                initialiseDriver();
        aDriver.manage().window().maximize();

    }


    @After
    public void tearDown(Scenario scenario) {

        screenShotOnFailure(scenario);
        quiteDriver();

    }
}
