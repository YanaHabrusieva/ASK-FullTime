package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class def_3_10 {
    @Given("^I navigate to \"([^\"]*)\" page$")
    public void iNavigateToPage(String page) throws Throwable {
        if (page.equalsIgnoreCase("login")) {
            getDriver().get("http://ask-stage.portnov.com/#/login");
        } else if (page.equalsIgnoreCase("registration")) {
            getDriver().get("http://ask-stage.portnov.com/#/registration");
        } else {
            throw new RuntimeException("Not supported " + page);
        }
    }

    @When("^I type email \"([^\"]*)\" on \"([^\"]*)\" page$")
    public void iTypeEmailOnPage(String email, String page) throws Throwable {
        if (page.equalsIgnoreCase("login")) {
            getDriver().findElement(By.xpath("//input[@placeholder='Email *']")).sendKeys(email);
        } else if (page.equalsIgnoreCase("registration")) {
            getDriver().findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
        } else {
            throw new RuntimeException("Not supported " + page);
        }
    }

    @And("^I type password \"([^\"]*)\" on \"([^\"]*)\" page$")
    public void iTypePasswordOnPage(String pass, String page) throws Throwable {
        if (page.equalsIgnoreCase("login")) {
            getDriver().findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys(pass);
        } else if (page.equalsIgnoreCase("registration")) {
            getDriver().findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
        } else {
            throw new RuntimeException("Not supported " + page);
        }
    }

    @And("^I click Sign in button$")
    public void iClickSignInButton() throws Throwable {
        getDriver().findElement(By.xpath("//*[contains(text(),'Sign In')]")).click();
        sleep(2000);
    }

    @When("I click on Quizzes on left menu")
    public void iClickOnOnLeftMenu() throws Throwable {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
        sleep(2000);
    }

    @When("I click create new quiz button")
    public void iClickCreateNewQuizButton() throws Throwable {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();
        sleep(2000);

    }

    @When("I type title of the quiz {string}")
    public void iTypeTitleOfTheQuiz(String Testname) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='mat-input-2']")).sendKeys(Testname);
    }

    @And("I click on Add question button")
    public void iClickOnAddQuestionButton() {
        getDriver().findElement(By.xpath("//div[@class='controls ng-star-inserted']//span[1]")).click();
    }

    @When("I select textual type of Question")
    public void iSelectTextualTypeOfQuestion() throws Throwable {
        getDriver().findElement(By.xpath("//div[contains(text(),'Textual')]")).click();
        Thread.sleep(2000);
    }

    @Then("I type text of question {string}")
    public void iTypeTextOfQuestion(String textOfquestion) {
        getDriver().findElement(By.xpath("//*[@placeholder='Question *']")).sendKeys(textOfquestion);
    }

    @And("I save the quiz")
    public void iSaveTheQuiz() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        Thread.sleep(2000);
    }


    @When("I click on Assignments on left menu")
    public void iClickOnAssignmentsOnLeftMenu() throws InterruptedException {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Assignments')]")).click();
        Thread.sleep(2000);
    }

    @And("click on Create New Assignment button")
    public void clickOnCreateNewAssignmentButton() {
        getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-primary']")).click();
    }

    @Then("I select quiz Test Quiz")
    public void iSelectQuiz() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Select Quiz To Assign')]")).click();
        getDriver().findElement(By.xpath("//span[@class='mat-option-text'][contains(text(),'Test Quiz')]")).click();

    }

    @Then("I select student Sophia Jones")
    public void iSelectStudentSophiaJones() {
        getDriver().findElement(By.xpath("//mat-list-option[85]//div[1]//mat-pseudo-checkbox[1]")).click();
    }

    @Then("I click Give assignment button")
    public void iClickGiveAssignmentButton() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Give Assignment')]")).click();
        Thread.sleep(2000);
    }

    @When("I click Log out")
    public void iClickLogOut() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Log Out')]")).click();
    }

    @And("I confirm Log Out")
    public void iConfirmLogOut() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
        Thread.sleep(2000);
    }

    @When("I click on My Assignments")
    public void iClickOnMyAssignments() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'My Assignments')]")).click();
    }

    @Then("Student Assignment page should have quiz {string}")
    public void studentAssignmentPageShouldHaveQuiz(String arg0) {
        String resultLegend= getDriver().findElement(By.xpath("//tr[9]//td[1]")).getText();
        assertThat(resultLegend).isEqualToIgnoringCase("Test Quiz");
    }

    @Then("select quiz {string} from Assignments and delete")
    public void selectQuizFromAssignmentsAndDelete(String arg0) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Quiz: Test Quiz')]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Quiz: Test Quiz')]//mat-icon[@class='mat-icon material-icons'][contains(text(),'more_vert')]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//span[contains(text(),'Delete Assignment')]")).click();
        Thread.sleep(2000);


    }

    @And("I confirm delete")
    public void iConfirmDelete() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Delete')]")).click();
    }
}