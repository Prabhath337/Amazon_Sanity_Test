package TestNG;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import Amazon_Classes.Driver;
import Excel_Utility.read_excel;
import Page_Objects.pom;

public class test_amazon
{
	//WebDriver driver;
	Driver d=new Driver();
	String url="https://www.amazon.in";
	private static String property_path="C:\\Users\\Prabhath Sharma\\workspace\\Amazon\\src\\Amazon_Classes\\log4j.properties";
	  @BeforeTest
  	public void beforeMethod() 
  {
	  PropertyConfigurator.configure(property_path);
	  d.open_browser();
	  
  }
  @Test(priority=0)
  	public void navigate()
  {
	  d.getURL(url);
  }
  @Test(priority=1)
  	public void verify_title()
  {
	 String exp_title=d.getTitle();
	 System.out.println(exp_title);
	 Assert.assertEquals(exp_title, "Online Shopping: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
  }
  @Test(priority=3)
  	public void loggingin()
  {
	  d.signin_link();
  }
  @Test(priority=4)
  	public void verify_emailid()
  {
	  String excel_email=read_excel.emailid();
	  d.send_email();
	  String ele_email=d.driver.findElement(pom.emailid).getAttribute("value").toString();
	  Assert.assertEquals(excel_email,ele_email );
  } 
  @Test(priority=5)
  	public void verify_password()
  {
	  String excel_pwd=read_excel.password();
	  d.send_password();
	  String ele_pwd=d.driver.findElement(pom.pwd).getAttribute("value").toString();
	  Assert.assertEquals(excel_pwd,ele_pwd );
  } 
  @Test(priority=6)
  	public void verify_login()
  {
	  d.signin_button();
	  String signin=d.verify_signin();
	  Assert.assertEquals("Hello, amazsele", signin);
  }
  @Test(priority=7)
  	public void verify_product()
  {
	  String prod=d.product_search("Macbook in laptop");
	  String ele_prod=d.driver.findElement(pom.search).getAttribute("value").toString();
	  Assert.assertEquals(prod, ele_prod);
  }
  @Test(priority=8)
  	public void verify_text_before_after()
  {
	  String before_cart=d.before_cart_item_name();
	  d.add_cart();
	  String after_cart=d.after_cart_item_name();
	  Assert.assertEquals(before_cart, after_cart);
  }
  @Test(priority=9)
  	public void delete_items()
  {
	  d.delete_cart_items();
  }
  @Test(priority=10)
  	public void signout()
  {
	  d.logout();
  }
  @AfterTest
  	public void afterMethod() 
  {
	  d.close_browser();
  }

}
