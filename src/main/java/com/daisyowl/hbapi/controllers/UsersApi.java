package com.daisyowl.hbapi.controllers;

import com.daisyowl.hbapi.HBRequest;
import com.daisyowl.hbapi.models.User;
import com.daisyowl.hbapi.models.UserRepository;
import com.daisyowl.hbapi.models.dto.UserCreateDTO;
import com.sun.media.sound.InvalidDataException;
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
  public User create(@RequestBody @Valid UserCreateDTO userDto) throws Exception {
    User user = userDto.toUser();

    // we check now if the username or email is taken, because the key is not unique, so we can allow nameless temporary user accounts
    boolean usernameIsTaken = repository.findByUsername(user.username) != null;
    boolean emailIsTaken = repository.findByEmail(user.email) != null;

    // TODO: combine all errors into one object and send that back, also define these declaratively somehow?
    if (usernameIsTaken) throw new InvalidDataException("username is taken");
    if (emailIsTaken) throw new InvalidDataException("email is taken");

    User savedUser = repository.save(user);
    return savedUser;
  }

}
