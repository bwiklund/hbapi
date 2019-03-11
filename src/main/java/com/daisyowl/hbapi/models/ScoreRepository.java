package com.daisyowl.hbapi.models;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ScoreRepository extends MongoRepository<Score, String> {
  List<Score> findByUserId(String id);

  List<Score> findFirst10ByTestIdOrderByScoreDesc(String testName);
}
