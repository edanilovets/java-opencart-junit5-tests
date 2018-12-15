package com.opencart.backend.pages;

import com.opencart.backend.model.Product;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    ProductsPage(WebDriver driver) {
        super(driver);
    }

    public EditProductPage clickAddNewProductButton(){
        addNewButton.click();
        return new EditProductPage(driver);
    }

    public ProductsPage deleteProduct(){
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

    public boolean isInProductsList(Product product) {
        List<WebElement> lines = driver.findElements(By.cssSelector("#form-product > div > table > tbody > tr"));
        for (WebElement element : lines) {
            String productName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String productModel = element.findElement(By.cssSelector("td:nth-child(4)")).getText();
            if (productName.equals(product.getProductName()) && productModel.equals(product.getProductModel())) {
                return true;
            }
        }
        return false;
    }

    public boolean isNotInProductsList(Product product) {
        return !isInProductsList(product);
    }

    public EditProductPage pressEditButtonByIndex(int index) {
        WebElement editButton = driver.findElements(By.cssSelector("#form-product > div > table > tbody > tr > td > a")).get(index);
        editButton.click();
        return new EditProductPage(driver);
    }

    public ProductsPage selectProductByIndex(int index) {
        WebElement checkbox = driver.findElements(By.cssSelector("#form-product > div > table > tbody > tr > td > input[type=checkbox]")).get(index);
        checkbox.click();
        return this;
    }

    public Product getProductByIndex(int index) {
        WebElement row = driver.findElements(By.cssSelector("#form-product > div > table > tbody > tr")).get(index);
        return new Product().withProductName(row.findElements(By.cssSelector("td")).get(2).getText())
                .withProductModel(row.findElements(By.cssSelector("td")).get(3).getText());

    }
}
