package com.daisyowl.hbapi.controllers;

import com.daisyowl.hbapi.HBRequest;
import com.daisyowl.hbapi.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stats")
public class UsersApi {
  @Autowired
  HBRequest hbRequest;

  @Autowired
  private UserRepository repository;

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Stat> index() {
    return repository.findAll();
  }
  
}
