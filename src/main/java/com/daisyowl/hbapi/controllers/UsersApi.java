package com.daisyowl.hbapi.controllers;

import com.daisyowl.hbapi.HBRequest;
import com.daisyowl.hbapi.models.User;
import com.daisyowl.hbapi.models.UserCreateDTO;
import com.daisyowl.hbapi.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersApi {
  @Autowired
  HBRequest hbRequest;

  @Autowired
  private UserRepository repository;

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<User> index() {
    return repository.findAll();
  }

  @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public User create(@RequestBody @Valid UserCreateDTO newUser ) {
    User user = new User();
    user.username = newUser.username;
    user.email = newUser.email;

    User savedUser = repository.save(user);

    return savedUser;
  }

}
