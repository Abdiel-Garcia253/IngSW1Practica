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

public class UadyVirtualLoginTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver","/Users/Admin2/Documents/ChromeDriver/chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  }

  @Test
  public void LoginTestPass() throws Exception {
    driver.get("https://www.google.com/search?q=uady+virtual&rlz=1C1CHBF_esMX884MX884&oq=uady+virtual&aqs=chrome.0.69i59j0l4j69i60l3.3362j0j7&sourceid=chrome&ie=UTF-8");
    driver.findElement(By.xpath("//div[@id='rso']/div/div/div/a/h3")).click();
    driver.findElement(By.xpath("//nav[@id='essentialnavbar']/div/div/div/div/div/div/ul/li/a/em")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("a16211444");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Erronea");
    driver.findElement(By.id("login")).click();
    driver.findElement(By.id("loginbtn")).click();
    // Se usa el assertTrue con la finalidad de encontrar dentro del BODY un texto que solo aparece posterior a loguearse
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*VISTA GENERAL DE MIS CURSOS[\\s\\S]*$"));
  }
  
  @Test
  public void LoginTestFail() throws Exception {
    driver.get("https://www.google.com/search?q=uady+virtual&rlz=1C1CHBF_esMX884MX884&oq=uady+virtual&aqs=chrome.0.69i59j0l4j69i60l3.3588j0j4&sourceid=chrome&ie=UTF-8");
    driver.findElement(By.xpath("//div[@id='rso']/div/div/div/a/h3")).click();
    driver.findElement(By.xpath("//nav[@id='essentialnavbar']/div/div/div/div/div/div/ul/li/a/em")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("a16211444");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("erronea");
    driver.findElement(By.id("login")).click();
    driver.findElement(By.id("loginbtn")).click();
    //Se usa el assertTrue con la finalidad de encontrar dentro del BODY un texto que solo aparece si falla el logueo
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Datos erróneos\\. Por favor, inténtelo otra vez\\.[\\s\\S]*$"));
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