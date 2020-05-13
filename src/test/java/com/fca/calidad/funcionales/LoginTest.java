package com.fca.calidad.funcionales;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	 System.setProperty("webdriver.chrome.driver","/Users/Admin2/Documents/ChromeDriver/chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void LoginTest() throws Exception {
    driver.get("http://the-internet.herokuapp.com/login");
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("tomsmith");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
    driver.findElement(By.xpath("//form[@id='login']/button/i")).click();
    // Warning: assertTextPresent may require manual changes
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*You logged into a secure area![\\s\\S]*$"));
  }
  
  @Test
  public void FailLoigTest() throws Exception {
    driver.get("http://the-internet.herokuapp.com/login");
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("cualquiera");
    driver.findElement(By.id("login")).click();
    driver.findElement(By.xpath("//form[@id='login']/button/i")).click();
    WebElement texto = driver.findElement(By.id("flash"));
    String resultadoesperado = "Your username is invalid!";
    String resultadoejecucion = texto.getText(); 
    assertThat(resultadoejecucion, containsString (resultadoesperado));
  }

  private Matcher<String> containsString(String resultadoesperado) {
	// TODO Auto-generated method stub
	return null;
}

@After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
