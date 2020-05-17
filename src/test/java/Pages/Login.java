package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import Base.Base_cls;

public class Login extends Base_cls {
public Login()
{
	PageFactory.initElements(d1, this);
}

@FindBy(xpath = "//*[@type='text' and @class='_2zrpKA _1dBPDZ']")
WebElement user_name;

@FindBy(xpath="//*[@class='_2zrpKA _3v41xv _1dBPDZ']")
WebElement pass;

@FindBy(css = "button[class='_2AkmmA _1LctnI _7UHT_c']")
WebElement login_click;
public void sign_in(String u_name,String login_password)
{
	user_name.sendKeys(u_name);
	pass.sendKeys(login_password);
	login_click.click();
	
}
	
}
