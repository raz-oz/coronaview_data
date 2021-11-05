package com.rad.ms.corona_view.data.Service;



import com.rad.ms.corona_view.data.DB_Entities.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

public interface IDataService {

    Hospitalized getHospitalized(String date);

    Isolations getIsolationsByDate(String date);

    List<CovidByArea> getCovidByArea_town_code(String town_code);
    CovidByArea getCovidByArea_id(long id);

    Recovered getRecoveredByID(long ID);

    HttpStatus updateDbData();

    HttpStatus updateDbDataFromRecoveredDB();
    HttpStatus updateDbDataFromIsolationsDB();
    HttpStatus updateDbDataFromCovidByAreaDB();
    HttpStatus updateDbDataFromHospitalizedDB();

}
