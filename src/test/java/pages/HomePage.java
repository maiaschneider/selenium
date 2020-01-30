package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	 private WebDriver driver;
	 
	    //SELECTORES
	    //Enlace "Apply as a Freelancer"
	    @FindBy(className= "_2716rq5F")
	    WebElement linkApplyFreelancer;
	    
	    //Constructor
	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    public void clickLinkApplyFreelancer(){
	        linkApplyFreelancer.click();
	    }

}
