package com.rad.ms.corona_view.data;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface HospitalizedRepository extends MongoRepository<Hospitalized, String> {
    Hospitalized findBy_id(long _id);

}