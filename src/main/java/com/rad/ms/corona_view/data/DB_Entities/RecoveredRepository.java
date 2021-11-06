package com.rad.ms.corona_view.data.DB_Entities;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

public interface RecoveredRepository extends MongoRepository<Recovered, String> {
    Recovered findBy_id(String _id);

}