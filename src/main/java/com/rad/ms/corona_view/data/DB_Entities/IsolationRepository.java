package com.rad.ms.corona_view.data.DB_Entities;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

public interface IsolationRepository extends MongoRepository<Isolations, String> {
    Isolations findBy_id(long _id);
     Isolations findBydate(String date);
}