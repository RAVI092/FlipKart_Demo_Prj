package Test_Case;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Base.Base_cls;
import Pages.Home;
import Pages.Login;

public class Home_test extends Base_cls {
	ExtentReports e;
	ExtentTest l;
@BeforeTest
public void home_page_pre_requisit() throws IOException
{
	e=new ExtentReports(System.getProperty("user.dir") +"/test-output/FlipKart_LoginReport.html", true);
	e.addSystemInfo("user","ravi");
	loadUrl(prop("url"));
	Login log=new Login();
	log.sign_in(prop("username"),prop("password"));
}

@Test
public void home_page() throws IOException, InterruptedException
{
	Thread.sleep(4000);
	Home h=new Home();
	h.elec();
//	link();
}
}
