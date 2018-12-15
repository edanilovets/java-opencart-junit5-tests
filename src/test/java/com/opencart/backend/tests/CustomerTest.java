package com.opencart.backend.tests;

import com.opencart.backend.model.Customer;
import com.opencart.backend.pages.CustomersPage;
import com.opencart.backend.pages.DashboardPage;
import com.opencart.backend.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.opencart.backend.model.CustomerRegistry.getCustomer;
import static com.opencart.backend.model.UserRegistry.getAdmin;
import static com.opencart.backend.tests.Annotations.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

//todo: Implement assertions using database

class CustomerTest extends TestBase {

  @Test
  @Fast
  @UI
  @DisplayName("Adding of New customer with only required fields")
  void canAddNewCustomerWithOnlyRequiredData() {
    Customer customer = getCustomer();
    DashboardPage dashboardPage = new LoginPage(driver)
            .open()
            .loginAs(getAdmin());

    CustomersPage customersPage = dashboardPage
            .openCustomersPage()
            .clickAddNewCustomerButton()
            .fillCustomerDetailsFormRequired(customer)
            .saveCustomer();

    assertTrue(customersPage.isInCustomersList(customer));

  }

  @Test
  @UI
  @DisplayName("Adding of New customer with other data enabled")
  void canAddNewCustomerWithOtherCustomerDataEnabled(){
    Customer customer = getCustomer();
    DashboardPage dashboardPage = new LoginPage(driver)
            .open()
            .loginAs(getAdmin());

    CustomersPage customersPage = dashboardPage
            .openCustomersPage()
            .clickAddNewCustomerButton()
            .fillCustomerDetailsFormRequired(customer)
            .setNewsletter("Enabled")
            .setStatus("Disabled")
            .setSafe("Yes")
            .saveCustomer();

    assertTrue(customersPage.isInCustomersList(customer));
  }

  @Test
  @DisplayName("Adding of New customer with address form filled")
  void canAddNewCustomerWithOneAddress(){
    Customer customer = getCustomer();
    DashboardPage dashboardPage = new LoginPage(driver)
            .open()
            .loginAs(getAdmin());

    CustomersPage customersPage = dashboardPage
            .openCustomersPage()
            .clickAddNewCustomerButton()
            .fillCustomerDetailsFormRequired(customer)
            .clickAddAddress()
            .fillCustomersAddressFormRequired(customer)
            .saveCustomer();

    assertTrue(customersPage.isInCustomersList(customer));

  }

}
