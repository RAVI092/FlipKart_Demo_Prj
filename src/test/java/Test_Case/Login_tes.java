package Test_Case;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Base_cls;
import Pages.Login;
import junit.framework.Assert;
public class Login_tes extends Base_cls {
	ExtentReports e;
	ExtentTest l;
	
	@BeforeTest
	public void rep1() throws IOException
	{	
		e=new ExtentReports(System.getProperty("user.dir") +"/test-output/FlipKart_LoginReport.html", true);
		e.addSystemInfo("user","ravi");
		
	}

	
	
	@Test
	public void log_test() throws IOException 
	{
		l=e.startTest("log_test");
		loadUrl(prop("url"));
		Login log=new Login();
		log.sign_in(prop("username"),prop("password"));
		Assert.assertEquals(d1.getTitle(), "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	
	@Test
	public void log_test_invalid_data() throws IOException 
	{
		l=e.startTest("log_test_invalid_data");
		loadUrl(prop("url"));
		Login log=new Login();
		log.sign_in(prop("Invalid_uname"),prop("pass"));
//		Assert.assertEquals(d1.getTitle(), "");
	}
	@Test
	public void log_test_invalid_data1() throws IOException 
	{
		l=e.startTest("log_test_invalid_data1");
		loadUrl(prop("url"));
		Login log=new Login();
		log.sign_in(prop("Invalid_uname"),prop("pass"));
		Assert.assertEquals(d1.getTitle(), "");
	}
	
	@AfterMethod
	public void rep3(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			l.log(LogStatus.FAIL, "Test Case failed"+result.getStatus());
			l.log(LogStatus.FAIL, "Test Case failed"+result.getHost());
			l.log(LogStatus.FAIL, "Test Case failed"+result.getName());
			l.log(LogStatus.FAIL,l.addScreenCapture(scrsht("Login")));
		}
		else if (result.getStatus()==ITestResult.SUCCESS) {
			l.log(LogStatus.PASS, "Test Case passed"+result.getStatus());
			l.log(LogStatus.PASS, "Test Case passed"+result.getHost());
			l.log(LogStatus.PASS, "Test Case passed"+result.getName());
			l.log(LogStatus.PASS,l.addScreenCapture(scrsht("Login")));
		}
		else if (result.getStatus()==ITestResult.SKIP) {
			l.log(LogStatus.SKIP, "Test Case skipped"+result.getStatus());
			l.log(LogStatus.SKIP, "Test Case skipped"+result.getHost());
			l.log(LogStatus.SKIP, "Test Case skipped"+result.getName());
			l.log(LogStatus.SKIP,l.addScreenCapture(scrsht("Login")));
		}
		e.endTest(l);
	}
	@AfterTest
	public void rep4()
	{
		e.flush();
		e.close();
	}
	
}