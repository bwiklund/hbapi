package com.daisyowl.hbapi.models;

import org.springframework.data.annotation.Id;
import java.util.List;

public class Stats {
  @Id
  public String id;

  public float score;
  public int userId;
  public List<String> myStrings;
}
