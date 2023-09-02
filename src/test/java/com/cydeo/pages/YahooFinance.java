package com.cydeo.pages;

import com.cydeo.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YahooFinance {
    public YahooFinance(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(name="q")
    public WebElement searchBox;
}
