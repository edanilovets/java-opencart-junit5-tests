package com.opencart.backend.pages;

import com.opencart.backend.model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CustomersPage extends BasePage {

	CustomersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@data-original-title='Add New']")
	private WebElement addNewButton;
	@FindBy(xpath = "//button[@data-original-title='Save']")
	private WebElement saveButton;
	@FindBy(xpath = "//a[@data-original-title='Cancel']")
	private WebElement cancelButton;
	@FindBy(xpath = "//button[@data-original-title='Delete']")
	private WebElement deleteButton;



	public EditCustomersPage clickAddNewCustomerButton(){
		addNewButton.click();
		return new EditCustomersPage(driver);
	}

	public boolean isInCustomersList(Customer customer) {
		List<WebElement> lines = driver.findElements(By.cssSelector("#form-customer > table > tbody > tr"));
		for (WebElement element: lines){
			String email = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
			if (email.equals(customer.getEmail())){
				return true;
			}
		}
		return false;
	}
}
