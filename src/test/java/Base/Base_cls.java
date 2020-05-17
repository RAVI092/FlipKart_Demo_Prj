package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.google.common.io.Files;

public class Base_cls {
	
	public static WebDriver d1;

	public static void loadUrl(String url_address)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ravis\\Downloads\\chromedriver.exe");
		d1=new ChromeDriver();
		d1.get(url_address);
	}
	
	public static void url_che(String page_url12) throws IOException
	{
		URL u=new URL(page_url12);
		HttpURLConnection h=(HttpURLConnection)u.openConnection();
		h.setConnectTimeout(4000);
		h.connect();
		if(h.getResponseCode()==200)
		{
			System.out.println(h.getResponseMessage());
		}
		else
		{
			System.out.println("broken link present"+h.getResponseMessage());	
			Assert.assertEquals(d1.getTitle(), "");
		}
	}
	public static void link() throws IOException
	{
		List<WebElement> l=d1.findElements(By.tagName("a"));
		for(int i=0;i<l.size();i++)
		{
			WebElement l1=l.get(i);
			String page_url=l1.getAttribute("href");
			url_che(page_url);
		}
	}
	
	
	
	
	public static String scrsht(String img_name) throws IOException
	{
		long time=System.currentTimeMillis();
	TakesScreenshot t=((TakesScreenshot)d1);
	File s=t.getScreenshotAs(OutputType.FILE);
	File d=new File("Screen_shot\\"+img_name+time+".png");
	String screen_shot_path="C:\\Users\\ravis\\eclipse-workspace\\May_15\\Screen_shot\\"+img_name+time+".png";
	Files.copy(s, d);
	return screen_shot_path;
	}
	
	public static String prop(String s) throws IOException
	{

	FileInputStream f=new FileInputStream("Property\\flipkart.properties");
	Properties p=new Properties();
	p.load(f);
	String url_prop=p.getProperty(s);
	return url_prop;
}
	
	
	

}
