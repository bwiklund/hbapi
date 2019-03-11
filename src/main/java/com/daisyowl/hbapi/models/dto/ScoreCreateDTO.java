package com.daisyowl.hbapi.models.dto;

import javax.validation.constraints.NotNull;

public class ScoreCreateDTO {
  @NotNull
  public float score;

  @NotNull
  public String testId;
}
