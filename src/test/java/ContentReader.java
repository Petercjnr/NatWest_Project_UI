import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ContentReader {
    List<String> getCoinName(WebDriver driver)  {

        WebElement tableBody = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[5]/table/tbody"));
        List<WebElement> tableRows = tableBody.findElements(By.tagName("tr"));
        List<String> collector = new ArrayList<>(tableRows.size());
        for (WebElement  row: tableRows) {

            List<WebElement> cells = row.findElements(By.tagName("td"));
            String coinName = cells.get(2).getText();
            collector.add(coinName);
        }
        return collector;
    }
}
