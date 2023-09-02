package com.cydeo.pages;

import com.cydeo.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
    public GoogleSearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(name="q")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='SPZz6b']//h2//span")
    public WebElement result;
}
