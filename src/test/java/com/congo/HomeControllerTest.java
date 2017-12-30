package com.congo;

import com.congo.pageObjects.HomePage;
import org.hamcrest.CoreMatchers;
import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsNull;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

public class HomeControllerTest {
    private WebDriver driver;

    private String driverPath = System.getenv("CHROME_WEB_DRIVER");

    private String baseUrl = "http://localhost";
    private String port = System.getProperty("port");
    private String url;
    private HomePage homePage;

    @Before
    public void setUp() throws Exception {
        if(port == null){
            port = "8090";
        }
        System.setProperty("webdriver.chrome.driver", driverPath);

        url = baseUrl + ":" + port;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--no-sandbox");
        driver = new ChromeDriver(options);
        driver.get(url);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void pageTitleIsCongo() {
        Assert.assertThat(homePage.getTitle(), CoreMatchers.equalTo("Congo"));
    }

    @Test
    public void usersCanGoHome() {
        WebElement homeLink = getLink("Home");

        Assert.assertThat(homeLink, IsNot.not(IsNull.nullValue()));
        Assert.assertThat(homeLink.getTagName(), CoreMatchers.equalTo("a"));
        Assert.assertThat(homeLink.getAttribute("href"), CoreMatchers.equalTo(url + "/#"));
    }

    @Test
    public void usersCanViewNewProducts(){
        WebElement newProductLink = getLink("New Products");

        Assert.assertThat(newProductLink, IsNot.not(IsNull.nullValue()));
        Assert.assertThat(newProductLink.getTagName(), CoreMatchers.equalTo("a"));
        Assert.assertThat(newProductLink.getAttribute("href"), CoreMatchers.equalTo(url + "/#"));
    }

    @Test
    public void usersCanViewDepartments(){
        WebElement departmentsLink = getLink("Departments");

        Assert.assertThat(departmentsLink, IsNot.not(IsNull.nullValue()));
        Assert.assertThat(departmentsLink.getTagName(), CoreMatchers.equalTo("a"));
        Assert.assertThat(departmentsLink.getAttribute("href"), CoreMatchers.equalTo(url + "/#"));
    }

    private WebElement getLink(String linkName){
        return homePage.getMenuLinks().stream().filter((element) -> element.getText().contains(linkName)).findFirst().get();
    }
}
