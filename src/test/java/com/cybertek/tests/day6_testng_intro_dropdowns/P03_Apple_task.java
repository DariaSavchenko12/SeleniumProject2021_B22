package com.cybertek.tests.day6_testng_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P03_Apple_task {

    public static void main(String[] args) {

        //TC #03: FINDELEMENTS_APPLE
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://www.apple.com
        driver.get("https://www.apple.com");

        //3. Click to all of the headers one by one
            //  a. Mac, iPad, iPhone, Watch, TV, Music, Support

        // Storing 9 web elements including "apple" logo, and search box
        List<WebElement> headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));

        //4. Print out the titles of the each page
        //5. Print out total number of links in each page
        //6. While in each page:
            // a. Print out how many link is missing text TOTAL
            // b. Print out how many link has text TOTAL

    }
}
