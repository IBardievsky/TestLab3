package myprojects.automation.assignment3;

import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private By catalogueLink = By.id("subtab-AdminCatalog");
    private By categoriesLink = By.id("subtab-AdminCategories");
    private By addCategory = By.id("page-header-desc-category-new_category");
    private By nameOfTheCategory = By.className("copy2friendlyUrl");
    private By saveCategory = By.id("category_form_submit_btn");
    private By filterByName = By.cssSelector("thead > tr:nth-child(1) > th:nth-child(3) > span > a:nth-child(1) > i");

    public GeneralActions(WebDriver driver) {
        this.driver = driver;

    }

    /**
     * Logs in to Admin Panel.
     * @param login
     * @param password
     */
    public void login(String login, String password) {
        // TODO implement logging in to Admin Panel
        driver.navigate().to(Properties.getBaseAdminUrl());
        WebElement loginInput = driver.findElement(By.id("email"));
        WebElement passInput = driver.findElement(By.id("passwd"));
        WebElement loginButton = driver.findElement(By.className("ladda-label"));
        loginInput.sendKeys(login);
        passInput.sendKeys(password);
        loginButton.click();
    }

    /**
     * Adds new category in Admin Panel.
     * @param categoryName
     */
    public void createCategory(String categoryName) throws InterruptedException {
        // TODO implement logic for new category creation
        waitForContentLoad(catalogueLink);
        Actions actions = new Actions(driver);
        WebElement catalogueLink = driver.findElement(this.catalogueLink);
        actions.moveToElement(catalogueLink).perform();
        waitForContentLoad(categoriesLink);
        WebElement categoriesLink = driver.findElement(this.categoriesLink);
        actions.moveToElement(categoriesLink).click().perform();
        WebElement addCategory = driver.findElement(this.addCategory);
        addCategory.click();
        WebElement nameOfTheCategory = driver.findElement(this.nameOfTheCategory);
        nameOfTheCategory.sendKeys(categoryName);
        WebElement saveCategory = driver.findElement(this.saveCategory);
        saveCategory.click();
        WebElement filterByName = driver.findElement(this.filterByName);
        waitForContentLoad(this.filterByName);
        filterByName.click();
    }

    /**
     * Waits until page loader disappears from the page
     * @param element
     */
    public void waitForContentLoad(By element) {
       new WebDriverWait(driver, 30)
               .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}
