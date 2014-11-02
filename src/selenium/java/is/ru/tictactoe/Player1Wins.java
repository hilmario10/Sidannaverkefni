package is.ru.tictactoe;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
// import junit.framework.TestCase;
import static org.junit.Assert.*;


/**
 * Created by: arni11, bjarnthor12, sigruns12, sindris12, sindri12, theodor11 & thordurt12
 * Copyright (c) 2013
 * Project: TicTacToe
 * Package: com.example.tests
 * Date: 19/11/13
 */

/**
 * Tests new game.
 */
public class Player1Wins {
  /**
   * Selenium var.
   */
  private Selenium selenium;

  /**
   * Setup the selenium test.
   * @throws Exception throws exception.
   */
  @Before
  public void setUp() throws Exception {
    WebDriver driver = new FirefoxDriver();
    String baseUrl = System.getenv("STAGING_SERVER");
    selenium = new WebDriverBackedSelenium(driver, baseUrl);
  }

  /**
   * Tests new game.
   * @throws Exception throws exception.
   */
  @Test
  public void testNewGame() throws Exception {
    selenium.open("/");
    selenium.type("id=a", "Player1");
    selenium.type("id=b", "Player2");
    selenium.click("css=button.btn.btn-default");
    selenium.waitForPageToLoad("5000");
    
    selenium.click("0");
    Thread.sleep(1000);
    selenium.click("3");
    Thread.sleep(1000);
    selenium.click("1");
    Thread.sleep(1000);
    selenium.click("4");
    Thread.sleep(1000);
    selenium.click("3");
    Thread.sleep(1000);
    selenium.click("8");
    

  }

  /**
   * Stops selenium.
   * @throws Exception throws exception.
   */
  @After
  public void tearDown() throws Exception {
    selenium.stop();
  }
}