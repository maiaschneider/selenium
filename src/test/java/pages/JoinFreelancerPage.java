package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class JoinFreelancerPage {

	 private WebDriver driver;
	 
	    //SELECTORES
	    
	    @FindBy(css= "#top > div.layout_layer.is-modal > div > div > header > div > h1") 
	    WebElement titlePage;
	   
	    @FindBy(className ="custom_select-options_item")
	    WebElement txtSelectTalent;
	    	    
	    @FindBy(id = "talent_create_applicant_email")
	    WebElement txtEmail;
	    
	    @FindBy(id = "talent_create_applicant_password")
	    WebElement txtPassword;
	  
	    @FindBy(id = "talent_create_applicant_password_confirmation")
	    WebElement txtPasswordConfirmation;
	    
	    @FindBy(id = "talent_create_applicant_full_name")
	    WebElement txtFullName;
	    
	    @FindBy(how = How.XPATH,using = "//span[@class='label_wrap']")
	    WebElement checkConfidential;
	
	    @FindBy( id = "save_new_talent_create_applicant")
	    WebElement btnJoin;
	    
	    
	    public JoinFreelancerPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    
	    public void fillFormJoin(String talent, String fullName,String email,String password){
	        clickOnElement(txtSelectTalent);
	       // clickOnElement(optionDeveloper);
	    	//selectTalent(talent);
	    	
	        sendText(txtEmail,email);
	        sendText(txtPassword,password);
	        sendText(txtPasswordConfirmation,password);
	        sendText(txtFullName,fullName);
	        clickOnElement(checkConfidential);
	        clickOnElement(btnJoin);
	    }
	    
	    public void selectTalent(String talent) {
	    	Select selectTalent = new Select(txtSelectTalent);
	    	selectTalent.selectByVisibleText(talent);
	    }
	    //Metodo generico para dar clic a un elemento
	    public void clickOnElement(WebElement element){
	        element.click();
	    }
	    //Metodo generico para enviar texto a los input
	    public void sendText(WebElement element,String text){
	        element.clear();
	        element.sendKeys(text);
	    }
	    public boolean isPageOpened(String title){
	        return titlePage.getText().contains(title);
	    }

	 		
}
