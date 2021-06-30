package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class amazonPage {

    public amazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//a[@class='nav-a  ']")
    public List<WebElement> tabs;

    public WebElement Tab (String Text){
        String locator = "//a[.=\""+Text+"\"]";
        return Driver.getDriver().findElement(By.xpath(locator));
    }


}
