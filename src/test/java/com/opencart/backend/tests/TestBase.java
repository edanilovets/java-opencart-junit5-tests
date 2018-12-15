package com.opencart.backend.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class TestBase {
  public static WebDriver driver;


  @BeforeAll
  public static void init() {
    driver = new ChromeDriver();

  }

  @AfterAll
  public static void tearDown() {
    driver.quit();
  }

}
