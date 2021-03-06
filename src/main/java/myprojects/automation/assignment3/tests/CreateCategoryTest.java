package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;
import org.openqa.selenium.WebDriver;


public class CreateCategoryTest extends BaseScript {

    private static String login = "webinar.test@gmail.com";
    private static String password = "Xcg7299bnSmMuRLp9ITw";
    private static String categoryName = "QA Test";

    public static void main(String[] args) throws InterruptedException {
        // TODO prepare driver object
         WebDriver driver = getConfiguredDriver();
        // ...
        GeneralActions actions = new GeneralActions(driver);

        // login
        actions.login(login,password);

        // create category
        actions.createCategory(categoryName);

        // check that new category appears in Categories table

        // finish  script
        driver.quit();
    }
}
