package com.daisyowl.hbapi.models;


import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Document
public class User {
  @org.springframework.data.annotation.Id
  public String id;

  @Indexed(unique = true)
  public String username;

  @Indexed(unique = true)
  public String email;

  public String passwordHash;

  public static User fromUserCreateDTO(UserCreateDTO newUser) {
    User user = new User();
    user.username = newUser.username;
    user.email = newUser.email;
    user.SetPasswordFromPlaintext(newUser.password);
    return user;
  }

  void SetPasswordFromPlaintext(String passwordPlaintext) {
    this.passwordHash = new BCryptPasswordEncoder().encode(passwordPlaintext);
  }

  public boolean CheckPassword(String passwordPlaintext) {
    return new BCryptPasswordEncoder().matches(passwordPlaintext, this.passwordHash);
  }
}
