package com.daisyowl.hbapi;

import com.daisyowl.hbapi.models.Stats;
import com.daisyowl.hbapi.models.StatsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stats")
public class StatsApi {
  private static final Logger LOGGER = LoggerFactory.getLogger(StatsApi.class);

  @Autowired
  private StatsRepository repository;

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Stats> index() {
    return repository.findAll();
  }

  @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void create(@RequestBody Stats stats) {
    repository.save(stats);
  }
}
