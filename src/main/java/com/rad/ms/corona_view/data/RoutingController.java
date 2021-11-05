package com.rad.ms.corona_view.data;

import com.rad.ms.corona_view.data.DB_Entities.CovidByArea;
import com.rad.ms.corona_view.data.DB_Entities.Hospitalized;
import com.rad.ms.corona_view.data.DB_Entities.Isolations;
import com.rad.ms.corona_view.data.Service.IDataService;
import com.rad.ms.corona_view.data.DB_Entities.Recovered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@RestController
public class RoutingController {

    @Autowired
    private IDataService accessService;

    /**----------------Recovered-----------------*/
    @GetMapping("/recovered/{recovered_id}")
    public Recovered get_RecoveredByID(@PathVariable(value = "recovered_id") String _id) {
        return accessService.getRecoveredByID(Long.parseLong(_id));
    }

    /**--------------Hospitalized---------------*/
    @GetMapping("/hospitalized/{date}")
    public Hospitalized getHospitalized(@PathVariable(value = "date") String date) {
        return accessService.getHospitalized(date);
    }

    /**---------------Isolations----------------*/
    @GetMapping("/isolated/{date}")
    public  Isolations getIsolationsByDate(@PathVariable(value = "date") String date) {
        return accessService.getIsolationsByDate(date);
    }

    /**------------------Area------------------*/
    @GetMapping("/covidbyarea/town_code={town_code}")
    public List<CovidByArea> getCovidByArea_town_code(@PathVariable(value = "town_code") String code) {
        return accessService.getCovidByArea_town_code(code);
    }
    @GetMapping("/covidbyarea/id={id}")
    public  CovidByArea getCovidByArea(@PathVariable(value = "id") long id) {
        return accessService.getCovidByArea_id(id);
    }

    /**------------------updatedata------------------*/
    @GetMapping( "/updatedata")
    public HttpStatus updateDb() {
        return accessService.updateDbData();
    }
}
