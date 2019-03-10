package com.daisyowl.hbapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stats")
public class StatsApi {
    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String hi(){
        return "good day sir";
    }
}
