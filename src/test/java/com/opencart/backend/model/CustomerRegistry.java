package com.opencart.backend.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CustomerRegistry {
  public static Customer getCustomer(){
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    return new Customer()
            .withFirstName("Name" + timeStamp)
            .withLastName("Last" + timeStamp)
            .withEmail("main" + timeStamp + "@mail.com")
            .withPhone("123456789")
            .withPassword("111111")
            .withAddress1("Lomonosova st. 46/1")
            .withCity("Kyiv")
            .withCountry("Ukraine")
            .withRegion("Kyiv");
  }
}
