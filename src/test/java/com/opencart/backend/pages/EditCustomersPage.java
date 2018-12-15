package com.opencart.backend.pages;

import com.opencart.backend.model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EditCustomersPage extends BasePage {

  EditCustomersPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "address-add")
  private WebElement addAddressButton;

  //Required Customer Details
  @FindBy(id = "input-firstname")
  private WebElement firstNameLocator;
  @FindBy(id = "input-lastname")
  private WebElement lastNameLocator;
  @FindBy(id = "input-email")
  private WebElement emailLocator;
  @FindBy(id = "input-telephone")
  private WebElement phoneLocator;
  @FindBy(id = "input-password")
  private WebElement passwordLocator;
  @FindBy(id = "input-confirm")
  private WebElement confirmLocator;

  //Address Required
  @FindBy(id = "input-firstname1")
  private WebElement firstNameLocator1;
  @FindBy(id = "input-lastname1")
  private WebElement lastNameLocator1;
  @FindBy(id = "input-address-11")
  private WebElement addressLocator11;
  @FindBy(id = "input-city1")
  private WebElement cityLocator1;
  @FindBy(id = "input-country1")
  private WebElement countyLocator1;
  @FindBy(id = "input-zone1")
  private WebElement zoneLocator1;


  public EditCustomersPage fillCustomerDetailsFormRequired(Customer customer) {
    firstNameLocator.sendKeys(customer.getFirstName());
    lastNameLocator.sendKeys(customer.getLastName());
    emailLocator.sendKeys(customer.getEmail());
    phoneLocator.sendKeys(customer.getPhone());
    passwordLocator.sendKeys(customer.getPassword());
    confirmLocator.sendKeys(customer.getPassword());
    return this;
  }

  public CustomersPage saveCustomer() {
    saveButton.click();
    return new CustomersPage(driver);
  }

  public EditCustomersPage setNewsletter(String text) {
    Select news = new Select(driver.findElement(By.id("input-newsletter")));
    news.selectByVisibleText(text);
    return this;
  }

  public EditCustomersPage setStatus(String text) {
    Select status = new Select(driver.findElement(By.id("input-status")));
    status.selectByVisibleText(text);
    return this;
  }

  public EditCustomersPage setSafe(String text) {
    Select safe = new Select(driver.findElement(By.id("input-safe")));
    safe.selectByVisibleText(text);
    return this;
  }

  public EditCustomersPage clickAddAddress() {
    addAddressButton.click();
    return this;
  }

  public EditCustomersPage fillCustomersAddressFormRequired(Customer customer) {
    firstNameLocator1.sendKeys(customer.getFirstName());
    lastNameLocator1.sendKeys(customer.getLastName());
    addressLocator11.sendKeys(customer.getAddress1());
    cityLocator1.sendKeys(customer.getCity());
    Select country = new Select(countyLocator1);
    country.selectByVisibleText(customer.getCountry());
    Select region = new Select(zoneLocator1);
    region.selectByVisibleText(customer.getRegion());
    return this;
  }
}
