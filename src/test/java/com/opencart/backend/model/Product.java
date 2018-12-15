package com.opencart.backend.model;

public class Product {
  private String productName;
  private String metaTagTitle;
  private String productModel;

  public String getProductName() {
    return productName ;
  }

  public Product withProductName(String productName) {
    this.productName = productName;
    return this;
  }

  public String getMetaTagTitle() {
    return metaTagTitle;
  }

  public Product withMetaTagTitle(String metaTagTitle) {
    this.metaTagTitle = metaTagTitle;
    return this;
  }

  public String getProductModel() {
    return productModel;
  }

  public Product withProductModel(String productModel) {
    this.productModel = productModel;
    return this;
  }
}
