package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingPage;
import pages.TechGlobalLoginFormPage;
import pages.TechGlobalResetPasswordPage;
import utilities.TestData;
import utilities.Waiter;

public class TechGlobalLoginFormPageTest extends TechGlobalBasePageTest{

// why my browser does not quit when test FAIL
    @BeforeMethod
    public void setUp(){
        techGlobalFrontendTestingPage = new TechGlobalFrontendTestingPage();
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();

        techGlobalFrontendTestingPage.getFrontendPage();
        techGlobalFrontendTestingPage.getCard("Login Form");
    }

    /*
    Test Case 1: Validate TechGlobal Login Form card
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    Then user should heading1 as “Login Form”
    And user should see “Please enter your username” label and username input box
    And user should see “Please enter your password” label and password input box
    And user should see “LOGIN” button
    And user should see “Forgot Password?” link
     */
    @Test(priority = 1, description = "validating TechGlobal Login Form card")
    public void validateTechGlobalLoginFormCard(){
        /**
         * validating that user is on the “Login Form” page
         */

        Assert.assertEquals(techGlobalLoginFormPage.loginFormH1.getText(), TestData.loginFormH1);

        for (int i = 0; i < 2; i++) {
            /**
             * validating that USERNAME and PASSWORD labels are displayed and their text is how it's expected
             */
            Assert.assertTrue(techGlobalLoginFormPage.loginFormBoxLabels.get(i).isDisplayed());
            Assert.assertEquals(techGlobalLoginFormPage.loginFormBoxLabels.get(i).getText(),
                    TestData.labelForLoginFormBoxes[i]);

            /**
             *  validating that USERNAME and PASSWORD input boxes are displayed
             */
            Assert.assertTrue(techGlobalLoginFormPage.loginFormBoxInputs.get(i).isDisplayed());

        }

        /**
         * validating that LOGIN BUTTON is displayed and clickable
         */
        Assert.assertTrue(techGlobalLoginFormPage.loginFormLoginButton.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.loginFormLoginButton.isEnabled());

        /**
         * validating that FORGOT PASSWORD LINK is displayed
         */

        Assert.assertTrue(techGlobalLoginFormPage.loginFormForgotPasswordLink.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.loginFormForgotPasswordLink.isEnabled());

    }


    /*Test Case 2: Validate TechGlobal Login Form card valid login
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “TechGlobal” and password as “Test1234”
    And user clicks on “LOGIN” button
    Then user should see “You are logged in” message
    And user should see “LOGOUT” button
     */
    @Test(priority = 2, description = "validate TechGlobal Login Form card valid login")
    public void validatingLoginFormValidLogin(){
            techGlobalLoginFormPage.loginFormBoxInputs.get(0).sendKeys(TestData.loginFormCorrectUsername);
            techGlobalLoginFormPage.loginFormBoxInputs.get(1).sendKeys(TestData.loginFormCorrectPassword);
            techGlobalLoginFormPage.loginFormLoginButton.click();

            Assert.assertTrue(techGlobalLoginFormPage.loginFormYouAreLoggedInMassage.isDisplayed());
            Assert.assertTrue(techGlobalLoginFormPage.loginFormLogoutButton.isDisplayed());
            Assert.assertTrue(techGlobalLoginFormPage.loginFormLogoutButton.isEnabled());
    }

    /*Test Case 3: Validate TechGlobal Login Form card valid login and then logout
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “TechGlobal” and password as “Test1234”
    And user clicks on “LOGIN” button
    And user clicks on “LOGOUT” button
    Then user should be navigated back to Login Form
     */

   // If we can do like this
    @Test(priority = 3, description = "validate TechGlobal Login Form card valid login and then logout")
    public void validatingTechGlobalLoginFormValidLoginLogout(){
        techGlobalLoginFormPage.loginFormBoxInputs.get(0).sendKeys(TestData.loginFormCorrectUsername);
        techGlobalLoginFormPage.loginFormBoxInputs.get(1).sendKeys(TestData.loginFormCorrectPassword);
        techGlobalLoginFormPage.loginFormLoginButton.click();
        techGlobalLoginFormPage.loginFormLogoutButton.click();

        Assert.assertTrue(techGlobalLoginFormPage.loginFormLoginButton.isDisplayed());
    }

    /*Test Case 4: Validate TechGlobal Login Form card Forgot Password?
    Link and Reset Password page
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user clicks on “Forgot Password?” link
    Then user should see “Reset Password” heading1
    And user should see “Enter your email address and we'll send you a link to reset
    your password.” message
    And user should see email input box
    And user should see “SUBMIT” button
     */

        // Should it be heading 1 or 2, because there is heading 2 in the code
    @Test(priority = 4, description = "validate TechGlobal Login Form card Forgot Password Link " +
            "and Reset Password page")
    public void validatingLoginFormForgotPasswordLink(){
        techGlobalResetPasswordPage = new TechGlobalResetPasswordPage();

        techGlobalLoginFormPage.loginFormForgotPasswordLink.click();
        /**
         * validating header of page
         */
        Assert.assertTrue(techGlobalResetPasswordPage.resetPasswordH2.isDisplayed());
        Assert.assertEquals(techGlobalResetPasswordPage.resetPasswordH2.getText(), TestData.resetPasswordH2);
        /**
         * validating LABEL message
         */
        Assert.assertTrue(techGlobalResetPasswordPage.resetPasswordLabel.isEnabled());
        Assert.assertEquals(techGlobalResetPasswordPage.resetPasswordLabel.getText(), TestData.resetPasswordPageMessage);
        /**
         * validating EMAIL BOX is displayed
         */
        Assert.assertTrue(techGlobalResetPasswordPage.resetPasswordEmailBox.isDisplayed());
        /**
         * validating SUBMIT button is displayed and clickable
         */
        Assert.assertTrue(techGlobalResetPasswordPage.resetPasswordSubmitButton.isDisplayed());
        Assert.assertTrue(techGlobalResetPasswordPage.resetPasswordSubmitButton.isEnabled());

    }

    /*Test Case 5: Validate TechGlobal Login Form card Reset Password link
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user clicks on “Forgot Password?” link
    When user enters a valid email to email input box
    And user clicks on “SUBMIT” button
    Then user should see “A link to reset your password has been sent to your email
    address.” message
     */
   @Test(priority = 5, description = "validate TechGlobal Login Form card Reset Password link")
    public void validatingLoginFormResetPasswordLink(){
        techGlobalResetPasswordPage = new TechGlobalResetPasswordPage();
        techGlobalLoginFormPage.loginFormForgotPasswordLink.click();
        techGlobalResetPasswordPage.resetPasswordEmailBox.sendKeys("tg@gmail.com");
        techGlobalResetPasswordPage.resetPasswordSubmitButton.click();

        /**
         * validation of confirmation message
         */
        Assert.assertTrue(techGlobalResetPasswordPage.resetPasswordConfirmationMessage.isDisplayed());
        Assert.assertEquals(techGlobalResetPasswordPage.resetPasswordConfirmationMessage.getText(),
                TestData.resatPasswordConfirmationMessage);
   }
   /*Test Case 6: Validate TechGlobal Login Form card invalid login with
    wrong username
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “john” and password as “Test1234”
    And user clicks on “LOGIN” button
    Then user should see “Invalid Username entered!” message
    */
    @Test(priority = 6, description = "Validate TechGlobal Login Form card invalid login with wrong username")
    public void validatingLoginFormInvalidLoginWithWrongUsername(){
        techGlobalLoginFormPage.loginFormBoxInputs.get(0).sendKeys(TestData.wrongUsername);
        techGlobalLoginFormPage.loginFormBoxInputs.get(1).sendKeys(TestData.loginFormCorrectPassword);
        techGlobalLoginFormPage.loginFormLoginButton.click();

       Assert.assertTrue(techGlobalLoginFormPage.wrongInputErrorMessage.isDisplayed());
       Assert.assertEquals(techGlobalLoginFormPage.wrongInputErrorMessage.getText(), TestData.errorMessageWrongUsername);
    }

    /*Test Case 7: Validate TechGlobal Login Form card invalid login with
    wrong password
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “TechGlobal” and password as “1234”
    And user clicks on “LOGIN” button
    Then user should see “Invalid Password entered!” message
     */

    @Test(priority = 7, description = "validate TechGlobal Login Form card invalid login with wrong password")
    public void validatingLoginFormInvalidLoginWithWrongPassword(){
        techGlobalLoginFormPage.loginFormBoxInputs.get(0).sendKeys(TestData.loginFormCorrectUsername);
        techGlobalLoginFormPage.loginFormBoxInputs.get(1).sendKeys(TestData.wrongPassword);
        techGlobalLoginFormPage.loginFormLoginButton.click();

        Assert.assertTrue(techGlobalLoginFormPage.wrongInputErrorMessage.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.wrongInputErrorMessage.getText(), TestData.errorMessageWrongPassword);

    }
    /*Test Case 8: Validate TechGlobal Login Form card invalid login with
    both wrong credentials
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “john” and password as “1234”
    And user clicks on “LOGIN” button
    Then user should see “Invalid Username entered!” message
     */
    @Test (priority = 8, description = "validate TechGlobal Login Form card invalid login with " +
            "both wrong credentials")
    public void validatingLoginFormInvalidLoginWithWrongBothCredentials(){
        techGlobalLoginFormPage.loginFormBoxInputs.get(0).sendKeys(TestData.wrongUsername);
        techGlobalLoginFormPage.loginFormBoxInputs.get(1).sendKeys(TestData.wrongPassword);
        techGlobalLoginFormPage.loginFormLoginButton.click();

        Assert.assertTrue(techGlobalLoginFormPage.wrongInputErrorMessage.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.wrongInputErrorMessage.getText(), TestData.errorMessageWrongUsername);
    }



}
