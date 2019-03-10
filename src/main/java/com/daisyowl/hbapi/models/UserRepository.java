package com.daisyowl.hbapi.models;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Stats, String> {  }
