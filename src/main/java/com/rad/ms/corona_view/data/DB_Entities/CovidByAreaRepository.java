package com.rad.ms.corona_view.data.DB_Entities;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CovidByAreaRepository extends MongoRepository<CovidByArea, String> {
    CovidByArea findBy_id(String _id);
    List<CovidByArea> findByTownCode(String townCode);
}
