package Page_Objects;

import org.openqa.selenium.By;

public class pom 
{
	public static By signin_mouseover=By.cssSelector("#nav-link-yourAccount");
	public static By signin=By.cssSelector("#nav-flyout-ya-signin > a:nth-child(1) > span:nth-child(1)");
	public static By emailid=By.id("ap_email");
	public static By pwd=By.id("ap_password");
	public static By submit=By.id("signInSubmit-input");
	public static By loginverify=By.cssSelector("#nav-link-yourAccount > span:nth-child(1)");
	public static By search=By.id("twotabsearchtextbox");
	public static By search_submit=By.cssSelector("input.nav-input:nth-child(2)");
	public static By before_add_cart_item_name=By.cssSelector("#title");
	public static By addcart=By.id("add-to-cart-button");
	public static By cart_announce=By.id("hlb-view-cart-announce");
	public static By after_add_cart_item_name=By.cssSelector(".a-nostyle > li:nth-child(1) > span:nth-child(1) > a:nth-child(1) > span:nth-child(1)");
	public static By cart_count=By.id("nav-cart-count");
	public static By logout=By.cssSelector("#nav-item-signout > span:nth-child(1)");
	public static By signout_mouseover=By.cssSelector("#nav-link-yourAccount > span:nth-child(2)");
	public static By delete_item_cart=By.cssSelector("div.sc-list-item:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > span:nth-child(1) > span:nth-child(1) > input:nth-child(1)");
	public static By cart_icon=By.id("nav-cart");
}
