package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TechGlobalLoginFormPage extends TechGlobalBasePage{

    public TechGlobalLoginFormPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "main_heading")
    public WebElement loginFormH1;

    @FindBy(css = ".LoginForm_form__b4o6J label")
    public List<WebElement> loginFormBoxLabels;

    @FindBy(css = ".LoginForm_form__b4o6J input")
    public List<WebElement> loginFormBoxInputs;

    @FindBy(id = "login_btn")
    public WebElement loginFormLoginButton;

    @FindBy(id = "forgot-password")
    public WebElement loginFormForgotPasswordLink;

    @FindBy(id = "success_lgn")
    public WebElement loginFormYouAreLoggedInMassage;

    @FindBy(id = "logout")
    public  WebElement loginFormLogoutButton;

    @FindBy(id = "error_message")
    public WebElement wrongInputErrorMessage;


}
