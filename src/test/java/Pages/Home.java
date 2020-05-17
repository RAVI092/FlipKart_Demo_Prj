package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base_cls;

public class Home extends Base_cls {
	public Home()
	{
		PageFactory.initElements(d1, this);
	}
@FindBy(xpath = "//*[@class='_114Zhd']//li[1]//span[@class='_1QZ6fC _3Lgyp8']")
WebElement Electronics;

public void elec()
{
	Actions a=new Actions(d1);
	a.moveToElement(Electronics).build().perform();
	System.out.println(Electronics.getText());
}
}
