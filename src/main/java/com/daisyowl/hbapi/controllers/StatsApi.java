package com.daisyowl.hbapi.controllers;

import com.daisyowl.hbapi.HBRequest;
import com.daisyowl.hbapi.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/stats")
public class StatsApi {
  private static final Logger LOGGER = LoggerFactory.getLogger(StatsApi.class);

  @Autowired
  HBRequest hbRequest;

  @Autowired
  private StatRepository repository;

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Stat> index() {
    return repository.findAll();
  }

  @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void create(@RequestBody Stat stats, HttpServletRequest request) {
    LOGGER.info("" + hbRequest.user.username);
    repository.save(stats);
  }
}
