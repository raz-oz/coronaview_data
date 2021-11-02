package com.rad.ms.corona_view.data.DB_Entities;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

public interface HospitalizedRepository extends MongoRepository<Hospitalized, String> {
    Hospitalized findBy_id(long _id);

}