package com.daisyowl.hbapi.models;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SessionTokenRepository extends MongoRepository<SessionToken, String> {
  SessionToken findByToken(String token);
}
