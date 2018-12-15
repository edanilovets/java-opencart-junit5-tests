package com.opencart.backend.pages;

import com.opencart.backend.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  //Admin login page locators
  @FindBy(id = "input-username")
  private WebElement username;
  @FindBy(id = "input-password")
  private WebElement password;
  @FindBy(xpath = "//button[contains(text(),'Login')]")
  private WebElement loginButton;

  public LoginPage open() {
    driver.get("http://localhost:8080/opencart/admin/");
    return this;
  }

  public DashboardPage loginAs(User user) {
    username.sendKeys(user.getName());
    password.sendKeys(user.getPassword());
    loginButton.click();
    return new DashboardPage(driver);
  }

}
