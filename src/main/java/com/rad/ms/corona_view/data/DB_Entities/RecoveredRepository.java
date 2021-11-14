package com.rad.ms.corona_view.data.DB_Entities;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecoveredRepository extends MongoRepository<Recovered, String> {
    Recovered findBy_id(String _id);

}