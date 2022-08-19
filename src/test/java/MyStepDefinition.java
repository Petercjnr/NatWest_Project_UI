import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class MyStepDefinition {

    WebDriver chromeWebDriver;
    List<String> stepThree;


    @Given("Browser is open")
    public void browser_is_open() {
        System.setProperty("webdriver.chrome.driver" , "C:\\Users\\ucheo\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe");
        chromeWebDriver = new ChromeDriver();

    }
    @Then("Enter URl")
    public void enter_url() {
        chromeWebDriver.get("https://coinmarketcap.com");


    }
    @Then("Click on show rows by {int}")
    public void click_on_show_rows_by(Integer int1) throws InterruptedException {
        chromeWebDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        chromeWebDriver.findElement(By.id("cmc-cookie-policy-banner")).findElement(By.className("cmc-cookie-policy-banner__close")).click();
        WebElement showRows = chromeWebDriver.findElement(By.className("table-control-page-sizer"));
        WebElement dropDown = showRows.findElement(By.tagName("svg"));
        dropDown.click();
        WebElement twentyRow = chromeWebDriver.findElement(By.xpath("//*[@id=\"tippy-1\"]/div/div[1]/div/div/button[3]"));
        twentyRow.click();

    }
    @Then("capture page contents - price, name, market cap")
    public void capture_page_contents_price_name_market_cap() throws IOException {
        ContentReader reader = new ContentReader();
        stepThree  = reader.getCoinName(chromeWebDriver);
    }
   @Then("filter by Algorithm - {string}, followed by {string} and toggle {string}")
   public void filterByAlgorithmFollowedByAndToggle(String pow, String addFilter, String mineable) {
        WebElement Filters = chromeWebDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[4]/div[1]/span[2]/button[1]"));
        Filters.click();
        WebElement Algorithm = chromeWebDriver.findElement(By.xpath("///*[@id=\"__next\"]/div/div[1]/div[2]/div/div/ul/li[2]/div/span/button"));
        Algorithm.click();
        WebElement PoW = chromeWebDriver.findElement(By.xpath("//*[@id=\"tippy-507\"]/div/div[1]/div/div/div[1]/ul/li[5]"));
        PoW.click();
        WebElement AddFilter = chromeWebDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/ul/li[5]/button"));
        AddFilter.click();
        WebElement mineableButton = chromeWebDriver.findElement(By.xpath("//*[@id=\"mineable\"]"));
        mineableButton .click();


    }
    @Then("select {string} and select {string}")
    public void selectAndSelect(String arg0, String arg1) {
        WebElement allCryptocurrencies = chromeWebDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[6]/div/div/div[2]/div[1]/div[1]/button"));
        allCryptocurrencies.click();
        WebElement coins = chromeWebDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[6]/div/div/div[2]/div[1]/div[2]/div[2]/button"));
        coins.click();

    }
    @Then("select price and set minimum value to {int} and maximum to {double}")
    public void select_price_and_set_minimum_value_to_and_maximum_to(Integer int1, Double double1) {
        WebElement Price = chromeWebDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[6]/div/div/div[2]/div[1]/div[3]/button"));
        Price.click();
        WebElement inputPriceMinBox = chromeWebDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[6]/div/div/div[2]/div/div[4]/div[1]/div[1]/input[1]"));
        WebElement inputPriceMaxField = chromeWebDriver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[6]/div/div/div[2]/div/div[4]/div[1]/div[1]/input[2]"));

        inputPriceMinBox.sendKeys("100");
        inputPriceMaxField.sendKeys("1000");

    }
    @Then("compare page content to the content in step {int}")
    public void compare_page_content_to_the_content_in_step(Integer int1) throws IOException {
        ContentReader reader = new ContentReader();
        List<String> finalStep = reader.getCoinName(chromeWebDriver);

        Assert.assertFalse(finalStep.containsAll(stepThree));

    }




    // File in step 3 and this step.
}
