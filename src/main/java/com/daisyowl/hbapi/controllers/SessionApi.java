package com.daisyowl.hbapi.controllers;

import com.daisyowl.hbapi.models.*;
import com.daisyowl.hbapi.models.dto.UserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/session")
public class SessionApi {
  @Autowired
  UserRepository userRepository;

  @Autowired
  SessionTokenRepository sessionRepository;

  @RequestMapping(method = RequestMethod.POST)
  public void create(@RequestBody UserLoginDTO userLoginDTO, HttpServletResponse response){
    User user = userRepository.findByUsername(userLoginDTO.username);
    if (user.CheckPassword(userLoginDTO.password)) {
      SessionToken sessionToken = new SessionToken();
      sessionToken.userId = user.id;
      sessionToken.token = UUID.randomUUID().toString();
      sessionToken.date = new Date();
      sessionRepository.save(sessionToken);
      response.addCookie(new Cookie("hb-auth", sessionToken.token));
    }
  }
}
