package com.rad.ms.corona_view.data.Service;



import com.rad.ms.corona_view.data.DB_Entities.*;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface IDataService {

    List<Hospitalized> getHospitalized();

    List<Isolations> getIsolationsByDate();

    List<CovidByArea> getCovidByArea();

    List<Recovered> getRecoveredByDate();
    Recovered getRecoveredByID(long ID);
    List<Recovered> getRecoveredByFirstName();

    HttpStatus updateDbData();

    HttpStatus updateDbDataFromRecoveredDB();
    HttpStatus updateDbDataFromIsolationsDB();
    HttpStatus updateDbDataFromCovidByAreaDB();
    HttpStatus updateDbDataFromHospitalizedDB();
}
