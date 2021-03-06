package com.rad.ms.corona_view.data.DB_Entities;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface HospitalizedRepository extends MongoRepository<Hospitalized, String> {
    Hospitalized findBy_id(String _id);
    Hospitalized findBydate(String date);


}