package com.opencart.backend.tests;

import com.opencart.backend.model.Product;
import com.opencart.backend.pages.DashboardPage;
import com.opencart.backend.pages.LoginPage;
import com.opencart.backend.pages.ProductsPage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static com.opencart.backend.model.ProductRegistry.getProduct;
import static com.opencart.backend.model.UserRegistry.getAdmin;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductTest extends TestBase {

  @Test
  @DisplayName("Adding of New product with only required fields")
  void canAddNewProductOnlyWithRequiredFields(){
    Product product = getProduct();

    DashboardPage dashboardPage = new LoginPage(driver)
            .open()
            .loginAs(getAdmin());

    ProductsPage productsPage = dashboardPage
            .openProductsPage()
            .clickAddNewProductButton()
            .enterProductName(product.getProductName())
            .enterMetaTagTitle(product.getMetaTagTitle())
            .activateDataTab()
            .enterProductModel(product.getProductModel())
            .saveProduct();

    assertTrue(productsPage.isInProductsList(product));

  }

  @Test
  @DisplayName("Canceling adding of New product after name and meta tag are entered")
  void canCancelAddingOfNewProduct(){
    Product product = getProduct();

    DashboardPage dashboardPage = new LoginPage(driver)
            .open()
            .loginAs(getAdmin());

    assertTrue(dashboardPage.openProductsPage().isNotInProductsList(product));
    assertTrue(dashboardPage
            .openProductsPage()
            .clickAddNewProductButton()
            .enterProductName(product.getProductName())
            .enterMetaTagTitle(product.getMetaTagTitle())
            .cancelProductEditing()
            .isNotInProductsList(product));
  }

  @Test
  @DisplayName("Deletion product from product list")
  void canDeleteProductFromList(){

    //index for selecting product
    int index = ThreadLocalRandom.current().nextInt(0, 10);

    DashboardPage dashboardPage = new LoginPage(driver)
            .open()
            .loginAs(getAdmin());

    ProductsPage productsPage = dashboardPage.openProductsPage();
    Product product = productsPage.getProductByIndex(index);

    assertTrue(productsPage.isInProductsList(product));
    productsPage.selectProductByIndex(index).deleteProduct();
    assertTrue(productsPage.isNotInProductsList(product));
  }


  @Disabled
  @Test
  @DisplayName("Modify name of existing product")
  void canEditExistingProductModifyProductName(){

    //index for selecting product
    int index = ThreadLocalRandom.current().nextInt(0, 10);

    DashboardPage dashboardPage = new LoginPage(driver)
            .open()
            .loginAs(getAdmin());

    ProductsPage productsPage = dashboardPage.openProductsPage();
    Product product = productsPage.getProductByIndex(index);

    ProductsPage productsPage1 = productsPage
            .pressEditButtonByIndex(index)
            .clearProductName()
            .enterProductName("Modified Name")
            .saveProduct();

    assertFalse(productsPage1.isInProductsList(product));
    product.withProductName("Modified Name");
    assertTrue(productsPage1.isInProductsList(product));
  }

}
