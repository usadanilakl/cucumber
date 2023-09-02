package com.cydeo.step_definitions;

import com.cydeo.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
//    @Before(value = "@db") // will only work for scenarios with the matching annotiations
//    public void setUpScenarios(){
//        System.out.println("comes from before");
//    }

    @After
    public void teardownScenarios(Scenario scenario) {
        //System.out.println("comes from after");

        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenario.getName());
        }

        Driver.driverQuit();
    }

//    @BeforeStep
//    public void setUpSteps(){
//        System.out.println("comes from beforeStep");
//    }
//
//    @AfterStep
//    public void teardownSteps(){
//        System.out.println("comes from afterStep");
//    }


}
