package com.daisyowl.hbapi.controllers;

import com.daisyowl.hbapi.HBRequest;
import com.daisyowl.hbapi.models.Score;
import com.daisyowl.hbapi.models.ScoreRepository;
import com.daisyowl.hbapi.models.dto.ScoreCreateDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/scores")
public class ScoresApi {
  private static final Logger LOGGER = LoggerFactory.getLogger(ScoresApi.class);

  @Autowired
  HBRequest hbRequest;

  @Autowired
  private ScoreRepository repository;

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Score> index() {
    return repository.findAll();
  }

  @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void create(@RequestBody ScoreCreateDTO scoreCreateDto, HttpServletRequest request) {
    Score score = new Score();
    score.score = scoreCreateDto.score;
    score.testId = scoreCreateDto.testId;
    score.userId = hbRequest.user.id;
    repository.save(score);
  }

  @GetMapping("test/{testId}")
  public List<Score> testLeaderboard(@PathVariable String testId){
    return repository.findFirst10ByTestIdOrderByScoreDesc(testId);
  }

  // FIXME TODO move this outside of the rest controller for debugging
  @GetMapping("mock")
  public void fillScoreboardWithMockData(){
    ArrayList<Score> mockScores = new ArrayList<>();
    for (int i = 0; i < 1000000; i++) {
      Score score = new Score();
      score.testId = "reactionTime";
      score.score = Math.random() * 1000;
      mockScores.add(score);
    }
    repository.saveAll(mockScores);
  }
}
