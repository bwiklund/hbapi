package com.daisyowl.hbapi;

import com.daisyowl.hbapi.models.Stats;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/stats")
public class StatsApi {
    @RequestMapping(value = "hi", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Stats hi(){
        Stats stats = new Stats();
        stats.userId = 1234;
        stats.myStrings = new ArrayList<>();
        stats.myStrings.add("hello");
        stats.myStrings.add("hi");
        return stats;
    }
}
