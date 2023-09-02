package com.cydeo.step_definitions;

import com.cydeo.pages.YahooFinance;
import com.cydeo.utils.ConfigReader;
import com.cydeo.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class YahooTest {
    YahooFinance yahooFinanceElement = new YahooFinance();
    @Given("user is on yahoo finance page")
    public void userIsOnYahooFinancePage() {
        Driver.getDriver().get(ConfigReader.getProperty("env"));
        yahooFinanceElement.searchBox.sendKeys("Yahoo Finance" + Keys.ENTER);
        Driver.getDriver().findElement(By.partialLinkText("yahoo")).click();
    }

    @When("user clicks on {string} and selects equaty screener")
    public void userClicksOnAndSelectsEquatyScreener(String arg0) {
        Driver.getDriver().findElement(By.xpath("//button[@title='Close modal']")).click();
        Driver.getDriver().findElement(By.linkText(arg0)).click();
    }

    @Then("user is on the new screener page with title Free Stock Screener")
    public void userIsOnTheNewScreenerPageWithTitleFreeStockScreener() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(Driver.getDriver().getTitle());
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Stock Screeners"));
    }
}
