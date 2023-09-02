package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utils.ConfigReader;
import com.cydeo.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class GoolgeSearchStepDefinitions {

    GoogleSearchPage googleSearchElement = new GoogleSearchPage();

    @Given("user is on the google page")
    public void userIsOnTheGooglePage() {
        Driver.getDriver().get(ConfigReader.getProperty("env"));
    }

    @When("user types apple in th google search box and clicks enter")
    public void userTypesAppleInThGoogleSearchBoxAndClicksEnter() {
        googleSearchElement.searchBox.sendKeys("apple" + Keys.ENTER);
    }

    @Then("user sees apple in the page title")
    public void userSeesAppleInThePageTitle() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("apple"));
    }

    @When("user types orange in th google search box and clicks enter")
    public void userTypesOrangeInThGoogleSearchBoxAndClicksEnter() {
        googleSearchElement.searchBox.sendKeys("orange" + Keys.ENTER);
    }

    @Then("user sees orange in the page title")
    public void userSeesOrangeInThePageTitle() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("orange"));
    }
//         ******************Parameterization*************************
    @When("user types {string} in th google search box and clicks enter")
    public void user_types_in_th_google_search_box_and_clicks_enter(String string) {
        googleSearchElement.searchBox.sendKeys(string + Keys.ENTER);
    }
    @Then("user sees {string} in the page title")
    public void user_sees_in_the_page_title(String string) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));
    }

    //         ******************Scenario Outline*************************

    @When("user searches for {string} capital")
    public void user_searches_for_capital(String string) {
        googleSearchElement.searchBox.sendKeys("capital of "+string + Keys.ENTER);
    }
    @Then("user should see {string} in the result")
    public void user_should_see_in_the_result(String capital) {
        Assert.assertEquals(capital, googleSearchElement.result.getText());
    }

    @Then("user should be able to search for following:")
    public void user_should_be_able_to_search_for_following(List<String> searchKey) {
        for (String s : searchKey) {
            googleSearchElement.searchBox.clear();
            googleSearchElement.searchBox.sendKeys(s + Keys.ENTER);
        }
    }

}
