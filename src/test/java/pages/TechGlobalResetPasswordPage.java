package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TechGlobalResetPasswordPage extends TechGlobalBasePage{

    public TechGlobalResetPasswordPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "sub_heading")
    public WebElement resetPasswordH2;

    @FindBy (xpath = "//input[@id='email']/../label")
    public WebElement resetPasswordLabel;

    @FindBy (id = "email")
    public WebElement resetPasswordEmailBox;

    @FindBy (id = "submit")
    public  WebElement resetPasswordSubmitButton;

    @FindBy (id = "confirmation_message")
    public WebElement resetPasswordConfirmationMessage;


}
