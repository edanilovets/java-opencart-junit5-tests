package com.opencart.backend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
  public WebDriver driver;

  BasePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  //Action Panel
  @FindBy(xpath = "//a[@data-original-title='Add New']")
  WebElement addNewButton;
  @FindBy(xpath = "//button[@data-original-title='Save']")
  WebElement saveButton;
  @FindBy(xpath = "//a[@data-original-title='Cancel']")
  WebElement cancelButton;
  @FindBy(xpath = "//button[@data-original-title='Delete']")
  WebElement deleteButton;

  //Admin Menu
  @FindBy(id = "menu-catalog")
  private WebElement menuCatalog;
  @FindBy(xpath = "//*[@id='collapse1']/li[2]/a")
  private WebElement menuCatalogProducts;
  @FindBy(id = "menu-customer")
  private WebElement menuCustomer;
  @FindBy(xpath = "//*[@id='collapse33']/li[1]/a")
  private WebElement menuCustomerCustomer;
  @FindBy(xpath = "//*[@id='user-profile']/parent::a")
  private WebElement userDropdown;
  @FindBy(xpath = "//*[@id='header']//a[contains(text(),'Your Profile')]")
  private WebElement yourProfile;
  @FindBy(xpath = "//*[@id='header']//span[contains(text(),'Logout')]/parent::a")
  private WebElement logout;

  public LoginPage logout(){
    logout.click();
    return new LoginPage(driver);
  }

  //Admin Menu methods
  public ProductsPage openProductsPage(){
    menuCatalog.click();
    menuCatalogProducts.click();
    return new ProductsPage(driver);
  }

  public CustomersPage openCustomersPage() {
    menuCustomer.click();
    menuCustomerCustomer.click();
    return new CustomersPage(driver);
  }
}
