package com.daisyowl.hbapi;

import com.daisyowl.hbapi.models.Stats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/stats")
public class StatsApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(StatsApi.class);

    @Autowired
    public String myParameter;

    @RequestMapping(
            value = "hi",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Stats hi() {
        Stats stats = new Stats();
        stats.userId = 1234;
        stats.myStrings = new ArrayList<>();
        stats.myStrings.add("hello");
        stats.myStrings.add("hi");
        return stats;
    }

    @RequestMapping(
            value = "create",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createStats(@RequestBody Stats stats) {
        LOGGER.info("creating stats {}", stats);
    }
}
