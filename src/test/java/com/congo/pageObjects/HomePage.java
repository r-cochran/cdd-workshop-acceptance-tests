package com.congo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage {
    @FindBy(className="nav-link")
    private List<WebElement> navLinks;

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> getMenuLinks() {
        return navLinks;
    }
}
