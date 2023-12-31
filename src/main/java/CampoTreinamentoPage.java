import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CampoTreinamentoPage {

    private static WebDriver driver;

    CampoTreinamentoPage() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(this.getClass().getClassLoader().getResource("componentes.html").toString());
        driver.manage().window().fullscreen();
    }

    private WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void insertText(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public String getElementValue(By by) {
        return findElement(by).getAttribute("value");
    }

    public String getElementText(By by) {
        return findElement(by).getText();
    }

    public void clickOnElement(By by) {
        findElement(by).click();
    }

    public boolean isElementSelected(By by) {
        return findElement(by).isSelected();
    }

    public void selectValueOnCombobox(By by, String scholarship) {
        new Select(findElement(by)).selectByVisibleText(scholarship);
    }

    public String getSelectedValueOnCombobox(By by) {
        return new Select(findElement(by)).getFirstSelectedOption().getText();
    }

    public void selectMultipleValuesOnCombobox(By by, String[] sports) {
        Select select = new Select(findElement(by));

        for (String sport :
                sports) {
            select.selectByVisibleText(sport);
        }
    }

    public ArrayList<String> getSelectedValuesOnCombobox(By by) {
        List<WebElement> allSelectedOptions = new Select(findElement(by)).getAllSelectedOptions();

        ArrayList<String> sports = new ArrayList<>();
        for (WebElement webElement :
                allSelectedOptions) {
            sports.add(webElement.getText());
        }

        return sports;
    }

    public void clickOnLink(String linkText) {
        clickOnElement(By.linkText(linkText));
    }

    public String getPageHeader(By by) {
        return getElementText(by);
    }

    public void closeBrowser() {
        driver.quit();
    }

}
