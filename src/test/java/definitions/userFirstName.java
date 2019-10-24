package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class userFirstName {
    @When("I type First name {string}")
    public void iTypeFirstName(String Fname) {
        getDriver().findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys(Fname);
    }

    @And("I type Last name {string}")
    public void iTypeLastName(String Lname) {
        getDriver().findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys(Lname);
    }

    @And("I type group code {string}")
    public void iTypeGroupCode(String groupCode) {
        getDriver().findElement(By.xpath("//*[@placeholder='Group Code']")).sendKeys(groupCode);
    }

    @And("I type confirm password {string}")
    public void iTypeConfirmPassword(String confPass) {
        getDriver().findElement(By.xpath("//*[@placeholder='Confirm Password']")).sendKeys(confPass);
    }

    @And("I click Register me button")
    public void iClickRegisterMeButton() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();
        Thread.sleep(2000);
    }

    @Then("message {string}")
    public void message(String text) {
        String message=getDriver().findElement(By.xpath("//*[contains(text(),'"+text+"')]")).getText();
        assertThat(message.contains(text)).isTrue();
    }
}
