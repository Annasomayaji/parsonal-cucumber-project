package com.nopcommerce.demo.steps;

import com.nopcommerce.demo.propertyreader.PropertyReader;
import com.nopcommerce.demo.utility.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Utility {
    String browser= PropertyReader.getInstance().getProperty("browser");

    @Before
    public void setup(){
        selectBrowser(browser);
    }


    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
           final byte[] screenshot= getScreenShot();
           scenario.attach(screenshot,"image/png", scenario.getName());
        }
        closeBrowser();
    }

}
