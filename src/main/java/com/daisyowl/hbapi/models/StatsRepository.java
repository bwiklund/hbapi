package com.daisyowl.hbapi.models;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StatsRepository extends MongoRepository<Stats, String> {
  List<Stats> findByUserId(String id);
}
