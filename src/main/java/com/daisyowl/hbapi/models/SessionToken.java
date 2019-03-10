package com.daisyowl.hbapi.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class SessionToken {
  @Indexed
  public String userId;

  @Indexed(unique = true)
  public String token;

  @Indexed(expireAfterSeconds = 60*60*24)
  public Date date;
}
