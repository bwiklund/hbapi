package com.daisyowl.hbapi.controllers;

import com.daisyowl.hbapi.models.User;
import com.daisyowl.hbapi.models.UserLoginDTO;
import com.daisyowl.hbapi.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1/session")
public class SessionApi {
  @Autowired
  UserRepository repository;

  @RequestMapping(method = RequestMethod.POST)
  public void create(@RequestBody UserLoginDTO userLoginDTO, HttpServletResponse response){
    User user = repository.findByUsername(userLoginDTO.username);
    if (user.CheckPassword(userLoginDTO.password)) {
      response.addCookie(new Cookie("hb-auth", "SureWhyNot"));
    }
  }
}
