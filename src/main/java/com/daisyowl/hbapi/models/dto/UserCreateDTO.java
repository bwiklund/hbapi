package com.daisyowl.hbapi.models.dto;

import com.daisyowl.hbapi.models.User;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

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

  public User toUser() {
    User user = new User();
    user.username = username;
    user.email = email;
    user.SetPasswordFromPlaintext(password);
    return user;
  }
}
