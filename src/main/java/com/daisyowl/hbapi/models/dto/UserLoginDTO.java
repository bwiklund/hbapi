package com.daisyowl.hbapi.models.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class UserLoginDTO {
  @NotNull
  @NotBlank
  public String username;

  @NotNull
  @NotBlank
  @Length(min = 6)
  public String password;
}
