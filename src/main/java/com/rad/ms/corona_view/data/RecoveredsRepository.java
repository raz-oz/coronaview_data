package com.rad.ms.corona_view.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecoveredsRepository extends MongoRepository<Recovered, String> {
    Recovered findBy_id(long _id);
}