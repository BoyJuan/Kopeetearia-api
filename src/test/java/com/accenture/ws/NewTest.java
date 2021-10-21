package com.accenture.ws;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;


public class NewTest {


private ChromeDriver driver;
private String baseUrl = "http://localhost:8080/kopeetearia-angular/api";



@BeforeClass
public void setup() throws InterruptedException {
System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
driver = new ChromeDriver() ;
// Maximize window
driver.manage().window().maximize();



// Navigate to site URL
driver.get(baseUrl);



Thread.sleep(3000);
}



@Test
public void addOrderDiscountedTest() throws InterruptedException {
placeOrder("Latte", "4.5", true);
Thread.sleep(2000);
Assert.assertTrue(driver.getPageSource().contains("Latte"));
}



@Test
public void addOrderNotDiscountedTest() throws InterruptedException {
placeOrder("Cappuccino", "5.5", false);
Thread.sleep(2000);
Assert.assertTrue(driver.getPageSource().contains("Latte"));
}





@Test
public void editOrderTest() throws InterruptedException{
Thread.sleep(3000);



driver.findElement(By.id("editOrderButton")).click();
Thread.sleep(1000);
// update feature
driver.findElement(By.id("editOrderOrderName")).clear(); //clear text box
driver.findElement(By.id("editOrderOrderName")).sendKeys("Today's Brew");
driver.findElement(By.id("editOrderPrice")).clear();
driver.findElement(By.id("editOrderPrice")).sendKeys("3.5");
driver.findElement(By.id("editOrderDiscounted")).click();
driver.findElement(By.id("saveOrderButton")).click();
Thread.sleep(1000);
Assert.assertTrue(driver.getPageSource().contains("Today's Brew"));
}



@Test
public void deleteOrderTest() throws InterruptedException {
Thread.sleep(4000);
driver.findElement(By.id("deleteOrderButton")).click();
Assert.assertFalse(driver.getPageSource().contains("Today's Brew"));
}






public void placeOrder(String orderName, String orderPrice, boolean selectDiscount) {
driver.findElement(By.id("addOrderOrderName")).sendKeys(orderName);
driver.findElement(By.id("addOrderPrice")).sendKeys(orderPrice);
if (selectDiscount) {
driver.findElement(By.id("addOrderDiscounted")).click();
}



driver.findElement(By.id("addOrderButton")).click();
}





}