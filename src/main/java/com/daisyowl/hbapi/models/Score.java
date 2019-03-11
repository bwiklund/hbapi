package com.daisyowl.hbapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Score {
  @Id
  public String id;

  @Indexed
  public String userId;

  @Indexed
  public String testId;

  @Indexed(direction = IndexDirection.DESCENDING)
  public double score;
}
