package com.daisyowl.hbapi.models;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserCreateDTO {
  @NotNull
  @NotBlank
  public String username;

  @Email
  public String email;

  @NotNull
  @NotBlank
  @Length(min = 6)
  public String password;
}
