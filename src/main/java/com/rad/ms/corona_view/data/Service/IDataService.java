package com.rad.ms.corona_view.data.Service;



import com.rad.ms.corona_view.data.DB_Entities.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface IDataService {
    /**----------------Recovered-----------------*/
    Recovered getRecoveredByID(String ID);
    HttpStatus updateDbDataFromRecoveredDB();
    List<Recovered> getAllRecovered();

    /**--------------Hospitalized---------------*/
    Hospitalized getHospitalized(String date);
    HttpStatus updateDbDataFromHospitalizedDB();
    List<Hospitalized> getAllHospitalized();
    Hospitalized getHospitalizedByID(String ID);

    /**---------------Isolations----------------*/
    Isolations getIsolationsByDate(String date);
    List<Isolations> getAllIsolations();
    HttpStatus updateDbDataFromIsolationsDB();
    Isolations getIsolationsByID( String ID);

    /**------------------Covid by area------------------*/
    CovidByArea getCovidByArea_id(String id);
    List<CovidByArea> getAllCovidbyarea();
    List<CovidByArea> getCovidByArea_town_code(String town_code);
    HttpStatus updateDbDataFromCovidByAreaDB();

    /**------------------update all data------------------*/
    HttpStatus updateDbData();


}
