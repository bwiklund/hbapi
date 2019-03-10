package com.daisyowl.hbapi.models;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StatRepository extends MongoRepository<Stat, String> {
  List<Stat> findByUserId(String id);
}
