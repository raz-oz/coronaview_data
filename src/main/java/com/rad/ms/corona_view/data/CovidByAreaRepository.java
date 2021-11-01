package com.rad.ms.corona_view.data;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CovidByAreaRepository extends MongoRepository<CovidByArea, Long> {
    CovidByArea findBy_id(long _id);

}
