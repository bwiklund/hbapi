package com.daisyowl.hbapi.models;


import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
  @org.springframework.data.annotation.Id
  public String id;

  @Indexed(unique = true)
  public String username;

  @Indexed(unique = true)
  public String email;
}
