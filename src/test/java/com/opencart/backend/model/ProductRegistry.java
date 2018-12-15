package com.opencart.backend.model;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ProductRegistry {
    //private static AtomicInteger COUNTER = new AtomicInteger(0);
    public static Product getProduct(){
        //int index = COUNTER.incrementAndGet();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        return new Product()
                .withProductName("AAA_" + timeStamp)
                .withProductModel("AAA_" + timeStamp)
                .withMetaTagTitle("AAA_" + timeStamp);
    }
    public static List<Product> getListOfProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product().withProductName("Apple iPhone X").withProductModel("iphone-x").withMetaTagTitle("iphone-x"));
        products.add(new Product().withProductName("Apple iPhone 8").withProductModel("iphone-8").withMetaTagTitle("iphone-8"));
        products.add(new Product().withProductName("Apple iPhone 7").withProductModel("iphone-7").withMetaTagTitle("iphone-7"));
        products.add(new Product().withProductName("Apple iPhone 5S").withProductModel("iphone-5s").withMetaTagTitle("iphone-5s"));
        products.add(new Product().withProductName("Apple MacBook Pro").withProductModel("macbook-pro").withMetaTagTitle("macbook-pro"));
        products.add(new Product().withProductName("Apple MacBook Air").withProductModel("macbook-air").withMetaTagTitle("macbook-air"));
        products.add(new Product().withProductName("Apple Mac Mini").withProductModel("mac-mini").withMetaTagTitle("mac-mini"));
        products.add(new Product().withProductName("Apple iPad").withProductModel("ipad").withMetaTagTitle("ipad"));
        products.add(new Product().withProductName("Apple iMac").withProductModel("imac").withMetaTagTitle("imac"));
        products.add(new Product().withProductName("Apple iMac Pro").withProductModel("imac-pro").withMetaTagTitle("imac-pro"));
        return products;
    }

}
