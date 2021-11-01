package com.rad.ms.corona_view.data;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface IsolationRepository extends MongoRepository<Isolations, String> {
    Isolations findBy_id(long _id);
}