package com.daisyowl.hbapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Stat {
  @Id
  public String id;

  public float score;
  public int userId;
  public List<String> myStrings;
}
