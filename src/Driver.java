package Amazon_Classes;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Excel_Utility.read_excel;
import Page_Objects.pom;

public class Driver 
{
	public WebDriver driver;
	private static String url="https://www.amazon.in";
	private static Actions action;
	private static Logger log=Logger.getLogger(Driver.class);
	private static String property_path="C:\\Users\\Prabhath Sharma\\workspace\\Amazon\\src\\Amazon_Classes\\log4j.properties";
	public void open_browser()
	{
		try
		{
			log.info("Entered open_browser method");
			log.info("Firefox browser will be lauched soon!!");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			log.info("Done maximizing!!");
			driver.manage().deleteAllCookies();
			FirefoxProfile profile=new FirefoxProfile();
			profile.setPreference("reader.parse-on-load.enabled", false);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.error("Something went wrong while launching browser",e);
		}
		
	}
	public void getURL(String url)
	{
		try
		{
			driver.get(url);
			log.info("Entered URL: "+url);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.error("Something went wrong while passing url!!",e);
		}
	}
	public String getTitle()
	{
		try
		{
			log.info("Entered getTitle method");
			driver.getTitle();
			String title=driver.getTitle();
			System.out.println(title);
			log.info("getTitle method- "+title);
			return title;
		}
		catch(NoSuchElementException nse)
		{
			nse.printStackTrace();
			log.error("Something went wrong while getting title",nse);
		}
		return "Unable to get page title!!";
	}
	public void signin_link()
	{
		try
		{
			log.info("Entered signin method");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			action=new Actions(driver);
			action.moveToElement(driver.findElement(By.cssSelector("#nav-link-yourAccount")));
			action.build().perform();
			driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
			WebElement ele_signin=driver.findElement(pom.signin);
			if(ele_signin.isDisplayed())
			{
				log.info("Signin button displayed");
				driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
				ele_signin.click();
				//WebElement ele_email=driver.findElement(By.id("ap_email"));
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				//WebDriverWait wait_signin=new WebDriverWait(driver, 20);
				//wait_signin.until(ExpectedConditions.visibilityOf(ele_email));
				
			}
			else
			{
				log.info("Unable to find the Signin button");
			}
		}
		catch(NoSuchElementException nse)
		{
			nse.printStackTrace();
			log.error("Something went wrong while finding signin link!!",nse);
		}
		
	}
	public void signin_button()
	{
		try
		{
			log.info("Entered signin_button method");
			driver.findElement(pom.submit).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		catch(NoSuchElementException nse)
		{
			nse.printStackTrace();
			log.error("Something went wrong while logging in",nse);
		}
	}	
	public void send_email()
	{
		try
		{
			log.info("Entered send_email method");
			driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
			String email=read_excel.emailid();
			driver.findElement(pom.emailid).clear();
			driver.findElement(pom.emailid).sendKeys(email);
			log.info("Entered emailid as: "+email);
		}
		catch(NoSuchElementException nse)
		{
			nse.printStackTrace();
			log.error(nse);
		}
	}
	public void send_password()
	{
		try
		{
			log.info("Entered send_password method");
			String password=read_excel.password();
			System.out.println("Password:"+ password);
			
			driver.findElement(pom.pwd).clear();
			driver.findElement(pom.pwd).sendKeys(password);
			log.info("Entered password as: "+password);
		}
		catch(NoSuchElementException nse)
		{
			nse.printStackTrace();
			log.error(nse);
		}
	}
	public String verify_signin()
	{
		try
		{
			log.info("Entered verify_signin method");
			WebElement ele_login_verify=driver.findElement(pom.loginverify);
			String login_name=ele_login_verify.getText();
			log.info("Title: "+login_name);
			return login_name;
		}
		catch(NoSuchElementException nse)
		{
			nse.printStackTrace();
			log.error("Something went wrong while verifying signin",nse);
		}
		return "Signin failed!!";
	} 
	public String product_search(String product)
	{
		try
		{
			log.info("Entered product_search method");
			driver.findElement(pom.search).clear();
			driver.findElement(pom.search).sendKeys(product);
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			driver.findElement(pom.search_submit).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector("#result_0 > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > a:nth-child(1) > h2:nth-child(1)")).click();
			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
			return product;
		}
		catch(NoSuchElementException nse)
		{
			nse.printStackTrace();
			log.error("Something went wrong while searching for a product",nse);
		}
		return "Unable to pass product parameter";
	}
	public String before_cart_item_name()
	{
		try
		{
			log.info("Entered before_cart_item_name method");
			WebElement ele_before=driver.findElement(pom.before_add_cart_item_name);
			String before_cart=ele_before.getText().toString();
			log.info("Getting text of product before adding that to cart - "+before_cart);
			return before_cart;
		}
		catch(NoSuchElementException nse)
		{
			nse.printStackTrace();
			log.error("Before_adding_product_cart - Something went wrong while getting text of product",nse);
		}
		return "Unble to get the item name!!";
	}
	public void add_cart()
	{
		try
		{
			log.info("Entered add_cart methods");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(pom.addcart).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(pom.cart_announce).click();
		}
		catch(NoSuchElementException nse)
		{
			nse.printStackTrace();
			log.error("Something went wrong while adding product to cart",nse);
		}
	}
	public String after_cart_item_name()
	{
		try
		{
			log.info("Entered after_cart_item_name method");
			WebElement ele_after=driver.findElement(pom.after_add_cart_item_name);
			String after_cart=ele_after.getText().toString();
			log.info("Getting text of the product aftering adding to cart"+after_cart);
			return after_cart;
		}
		catch(NoSuchElementException nse)
		{
			nse.printStackTrace();
			log.error("Something went wrong while getting text after adding to the cart",nse);
		}
		return "Unable to find element after add cart";
	}
	public int cart_count()
	{
		try
		{
			log.info("Entered cart_count method");
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			WebElement ele_count=driver.findElement(pom.cart_count);
			String cart=ele_count.getText().toString();
			int count=Integer.parseInt(cart);
			log.info("No of items in cart: "+count);
			return count;
		}
		catch(NoSuchElementException nse)
		{
			nse.printStackTrace();
			log.error("Something went wrong while getting count from the cart...",nse);
		}
		return 0;
	}
	public void delete_cart_items()
	{
		try
		{
			log.info("Entered delete_cart_items");
			int total_items=cart_count();
			if(total_items>0)
			{
				log.info("Items present in cart");
				for(int i=1;i<=total_items;i++)
				{
					String item_delete1="div.sc-list-item:nth-child"+"(" + i + ")";
					String item_delete2=" > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > span:nth-child(1) > span:nth-child(1) > input:nth-child(1)";
					String final_delete=item_delete1+item_delete2;
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					driver.findElement(By.cssSelector(final_delete)).click();
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				}
			}
			else
			{
				log.info("No items are present in the cart");
			}

		}
		catch(NoSuchElementException nse)
		{
			nse.printStackTrace();
			log.error("Something went while deleting items from cart",nse);
		}
			
	}	
	public void logout()
	{
		try
		{
			log.info("Entered logout method");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			action=new Actions(driver);
			action.moveToElement(driver.findElement(By.cssSelector("#nav-link-yourAccount > span:nth-child(2)")));
			action.build().perform();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement ele_logout=driver.findElement(pom.logout);
			String logout_text=ele_logout.getText().toString();
			log.info("Logout: "+logout_text);
			if(logout_text.equals("Not Prabhath? Sign Out"))
			{
				log.info("Good Bye!! Have a nice day");
				driver.findElement(pom.logout).click();
				System.out.println("Finally it worked!!");
			}
			else
			{
				log.error("Unable to find the signout button");
			}
		}
		catch(NoSuchElementException nse)
		{
			nse.printStackTrace();
			log.error("Something went wrong while signing out",nse);
		}
	}
	public void close_browser()
	{
		try
		{
			log.info("Entered close_browser");
			driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
			driver.close();
			driver.quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.error("Unable to close the browser",e);
		}
	}
	

}

