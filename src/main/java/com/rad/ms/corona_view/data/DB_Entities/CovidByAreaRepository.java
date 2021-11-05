package com.rad.ms.corona_view.data.DB_Entities;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Map;

public interface CovidByAreaRepository extends MongoRepository<CovidByArea, String> {
    CovidByArea findBy_id(long _id);
    List<CovidByArea> findByTownCode(String townCode);
}
