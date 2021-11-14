package com.rad.ms.corona_view.data.Service;



import com.rad.ms.corona_view.data.DB_Entities.Hospitalized;
import com.rad.ms.corona_view.data.DB_Entities.CovidByArea;
import com.rad.ms.corona_view.data.DB_Entities.Isolations;
import com.rad.ms.corona_view.data.DB_Entities.Recovered;
import org.springframework.http.HttpStatus;

import java.util.List;

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
