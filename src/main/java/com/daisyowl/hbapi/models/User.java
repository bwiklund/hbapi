package com.daisyowl.hbapi.models;


import com.daisyowl.hbapi.models.dto.UserCreateDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Document
public class User {
  @org.springframework.data.annotation.Id
  public String id;

  @Indexed(unique = true, sparse = true)
  public String username;

  @Indexed(unique = true, sparse = true)
  public String email;

  @JsonIgnore
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

  @Override
  public String toString() {
    return username + " <" + email + ">";
  }
}
